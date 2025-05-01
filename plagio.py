import os
import pandas as pd
import tensorflow as tf
from tensorflow.keras import layers, models
from sklearn.metrics import classification_report, confusion_matrix
from sklearn.utils import resample
import numpy as np
import random
import matplotlib.pyplot as plt
import seaborn as sns

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
    path1 = os.path.join(VERSIONS_DIR, folder, f"{s1}.java")
    path2 = os.path.join(VERSIONS_DIR, folder, f"{s2}.java")
    try:
        with open(path1, "r", encoding="utf-8") as f1, open(path2, "r", encoding="utf-8") as f2:
            return f1.read(), f2.read()
    except:
        return "", ""

def simple_tokenizer(code):
    return code.replace("\n", " ").replace("(", " ").replace(")", " ").replace("{", " ").replace("}", " ").replace(";", " ").split()

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

    diff = layers.Lambda(lambda tensors: tf.math.abs(tensors[0] - tensors[1]))([x1, x2])
    merged = layers.concatenate([x1, x2, diff])

    dense = layers.Dense(64, activation="relu")(merged)
    output = layers.Dense(1, activation="sigmoid")(dense)

    model = models.Model(inputs=[input1, input2], outputs=output)
    model.compile(optimizer="adam", loss="binary_crossentropy", metrics=["accuracy"])
    return model

print("Construyendo el modelo...")
model = build_model(len(token_to_id))
model.summary()

print("Entrenando...")
history = model.fit(
    [X_train1, X_train2],
    y_train,
    batch_size=32,
    epochs=5,
    validation_split=0.1
)

print("Evaluando...")
y_pred_probs = model.predict([X_test1, X_test2])
y_pred = (y_pred_probs >= 0.3).astype(int)

print(classification_report(y_test, y_pred))

# Cantidad exacta de predicciones correctas
correct_preds = np.sum(y_pred.flatten() == y_test)
print(f"Predicciones correctas: {correct_preds} de {len(y_test)}")


# Matriz de confusión
print("Matriz de confusión:")
cm = confusion_matrix(y_test, y_pred)
sns.heatmap(cm, annot=True, fmt="d", cmap="Blues", xticklabels=["No Plagio", "Plagio"], yticklabels=["No Plagio", "Plagio"])
plt.xlabel("Predicción")
plt.ylabel("Real")
plt.title("Matriz de Confusión")
plt.show()

# Gráfica de entrenamiento
plt.figure(figsize=(12, 5))

plt.subplot(1, 2, 1)
plt.plot(history.history["accuracy"], label="Entrenamiento")
plt.plot(history.history["val_accuracy"], label="Validación")
plt.title("Precisión por Época")
plt.xlabel("Épocas")
plt.ylabel("Precisión")
plt.legend()

plt.subplot(1, 2, 2)
plt.plot(history.history["loss"], label="Entrenamiento")
plt.plot(history.history["val_loss"], label="Validación")
plt.title("Pérdida por Época")
plt.xlabel("Épocas")
plt.ylabel("Pérdida")
plt.legend()

plt.tight_layout()
plt.show()
