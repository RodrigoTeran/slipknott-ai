import os
import pandas as pd
import tensorflow as tf
from tensorflow.keras import layers, models
from tensorflow.keras.layers import Subtract
from sklearn.utils import resample
import numpy as np
import random
import pickle
from sklearn.metrics import classification_report, confusion_matrix
import matplotlib.pyplot as plt
import seaborn as sns
import re

BASE_DIR = "conplag_version_2"
VERSIONS_DIR = os.path.join(BASE_DIR, "versions", "version_2")
LABELS_PATH = os.path.join(BASE_DIR, "versions", "labels.csv")
TRAIN_PAIRS_PATH = os.path.join(BASE_DIR, "versions", "train_pairs.csv")
TEST_PAIRS_PATH = os.path.join(BASE_DIR, "versions", "test_pairs.csv")

labels_df = pd.read_csv(LABELS_PATH)
train_ids = pd.read_csv(TRAIN_PAIRS_PATH, header=None)[0].str.split("_", expand=True)
train_ids.columns = ["sub1", "sub2"]
train_df = pd.merge(train_ids, labels_df, on=["sub1", "sub2"])

test_ids = pd.read_csv(TEST_PAIRS_PATH, header=None)[0].str.split("_", expand=True)
test_ids.columns = ["sub1", "sub2"]
test_df = pd.merge(test_ids, labels_df, on=["sub1", "sub2"])

def load_code(s1, s2):
    folder = f"{s1}_{s2}"
    # Intentar con diferentes extensiones en orden
    extensions = ['.java', '.py', '.cpp', '.cc', '.cxx']
    
    for ext in extensions:
        path1 = os.path.join(VERSIONS_DIR, folder, f"{s1}{ext}")
        path2 = os.path.join(VERSIONS_DIR, folder, f"{s2}{ext}")
        if os.path.exists(path1) and os.path.exists(path2):
            try:
                with open(path1, "r", encoding="utf-8") as f1, open(path2, "r", encoding="utf-8") as f2:
                    return f1.read(), f2.read()
            except:
                continue
    return "", ""

def simple_tokenizer(code):
    # Tokenizador para Java, Python y C++
    tokens = []
    code = code.replace('\r\n', '\n').replace('\r', '\n')
    
    # Patrón mejorado para los tres lenguajes
    pattern = r'''
        \b\w+\b|                     # Palabras clave e identificadores
        [][{}()<>.,;:=+*/-]|         # Símbolos
        \n|                          # Saltos de línea
        "(?:\\.|[^"\\])*"|           # Strings con comillas dobles
        '(?:\\.|[^'\\])*'|           # Strings con comillas simples
        \#.*|                        # Directivas de preprocesador (C++)
        //.*|                        # Comentarios de una línea
        /\*.*?\*/|                   # Comentarios multilínea
        ::|->|<<|>>|&&|\|\||\+\+|\-- # Operadores específicos de C++
    '''
    
    tokens = re.findall(pattern, code, re.VERBOSE | re.DOTALL)
    return [token for token in tokens if token and token.strip()]

def build_vocab(code_pairs):
    vocab = set()
    for c1, c2 in code_pairs:
        vocab.update(simple_tokenizer(c1))
        vocab.update(simple_tokenizer(c2))
    return {tok: i + 1 for i, tok in enumerate(vocab)}  # 0 reservado para padding

def encode(code, token_to_id, maxlen=500):
    ids = [token_to_id.get(tok, 0) for tok in simple_tokenizer(code)]
    return ids[:maxlen] + [0] * (maxlen - len(ids))

print("Cargando pares de entrenamiento...")
train_codes = [load_code(r.sub1, r.sub2) for _, r in train_df.iterrows()]
print("Cargando pares de prueba...")
test_codes = [load_code(r.sub1, r.sub2) for _, r in test_df.iterrows()]

token_to_id = build_vocab(train_codes + test_codes)

with open("token_to_id.pkl", "wb") as f:
    pickle.dump(token_to_id, f)

X_train1 = np.array([encode(c1, token_to_id) for c1, _ in test_codes])  
X_train2 = np.array([encode(c2, token_to_id) for _, c2 in test_codes])  
y_train = np.array(test_df["verdict"].values) 

X_test1 = np.array([encode(c1, token_to_id) for c1, _ in train_codes]) 
X_test2 = np.array([encode(c2, token_to_id) for _, c2 in train_codes])  
y_test = np.array(train_df["verdict"].values)  

print("Rebalanceando datos...")
data = list(zip(X_train1, X_train2, y_train))
class_0 = [x for x in data if x[2] == 0]
class_1 = [x for x in data if x[2] == 1]
class_1_upsampled = resample(class_1, replace=True, n_samples=len(class_0), random_state=42)
balanced = class_0 + class_1_upsampled
random.shuffle(balanced)
X_train1, X_train2, y_train = zip(*balanced)
X_train1 = np.array(X_train1)
X_train2 = np.array(X_train2)
y_train = np.array(y_train)

def build_model(vocab_size, embedding_dim=64, input_len=500):
    input1 = layers.Input(shape=(input_len,))
    input2 = layers.Input(shape=(input_len,))

    embed = layers.Embedding(input_dim=vocab_size + 1, output_dim=embedding_dim)
    conv = layers.Conv1D(64, 5, activation="relu")
    pool = layers.GlobalMaxPooling1D()

    x1 = pool(conv(embed(input1)))
    x2 = pool(conv(embed(input2)))

    diff_raw = Subtract()([x1, x2])
    diff = tf.keras.layers.Lambda(abs_diff)(diff_raw)

    merged = layers.concatenate([x1, x2, diff])

    dense = layers.Dense(64, activation="relu")(merged)
    output = layers.Dense(1, activation="sigmoid")(dense)

    model = models.Model(inputs=[input1, input2], outputs=output)
    model.compile(optimizer="adam", loss="binary_crossentropy", metrics=["accuracy"])
    return model

def abs_diff(x):
    return tf.math.abs(x)

print("Construyendo el modelo...")
model = build_model(len(token_to_id))

# Mostrar el resumen del modelo
model.summary()

# Entrenar el modelo y guardar el historial
print("Entrenando el modelo...")
history = model.fit(
    [X_train1, X_train2], 
    y_train, 
    batch_size=32, 
    epochs=5, 
    validation_split=0.1
)

# Guardar el modelo
model.save("modelo_plagio.keras")

# Evaluar el modelo
print("Evaluando el modelo...")
y_pred_probs = model.predict([X_test1, X_test2])
y_pred = (y_pred_probs >= 0.5).astype(int)  # Umbral de 0.5

# Reporte de clasificación
print("\nReporte de Clasificación:")
print(classification_report(y_test, y_pred))

# Matriz de confusión
print("\nMatriz de Confusión:")
cm = confusion_matrix(y_test, y_pred)
plt.figure(figsize=(6, 6))
sns.heatmap(cm, annot=True, fmt="d", cmap="Blues", 
            xticklabels=["No Plagio", "Plagio"], 
            yticklabels=["No Plagio", "Plagio"])
plt.xlabel("Predicción")
plt.ylabel("Real")
plt.title("Matriz de Confusión")
plt.show()

# Gráficas de entrenamiento
plt.figure(figsize=(12, 5))

# Gráfica de precisión
plt.subplot(1, 2, 1)
plt.plot(history.history['accuracy'], label='Precisión entrenamiento')
plt.plot(history.history['val_accuracy'], label='Precisión validación')
plt.title('Precisión del modelo')
plt.ylabel('Precisión')
plt.xlabel('Época')
plt.legend(loc='lower right')

# Gráfica de pérdida
plt.subplot(1, 2, 2)
plt.plot(history.history['loss'], label='Pérdida entrenamiento')
plt.plot(history.history['val_loss'], label='Pérdida validación')
plt.title('Pérdida del modelo')
plt.ylabel('Pérdida')
plt.xlabel('Época')
plt.legend(loc='upper right')

plt.tight_layout()
plt.show()

# Cantidad exacta de predicciones correctas
correct_preds = np.sum(y_pred.flatten() == y_test)
print(f"\nPredicciones correctas: {correct_preds} de {len(y_test)}")
print(f"Precisión: {correct_preds/len(y_test):.2%}")