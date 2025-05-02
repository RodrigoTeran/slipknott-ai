import os
import pickle
import tensorflow as tf
import numpy as np
from tensorflow.keras.models import load_model
import re

FOLDER = "codigos_de_prueba"

def simple_tokenizer(code):
    tokens = []
    code = code.replace('\r\n', '\n').replace('\r', '\n')
    
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

def encode(code, token_to_id, maxlen=500):
    ids = [token_to_id.get(tok, 0) for tok in simple_tokenizer(code)]
    return ids[:maxlen] + [0] * (maxlen - len(ids))

def abs_diff(x):
    return tf.math.abs(x)

# Cargar modelo y diccionario
model = load_model("modelo_plagio.keras", custom_objects={"abs_diff": abs_diff})
with open("token_to_id.pkl", "rb") as f:
    token_to_id = pickle.load(f)

# Mostrar archivos disponibles (Java, Python, C++)
archivos = [f for f in os.listdir(FOLDER) if f.endswith((".java", ".py", ".cpp", ".cc", ".cxx"))]
print("Archivos disponibles:")
for idx, fname in enumerate(archivos):
    print(f"{idx}: {fname}")

# Selección de archivos
idx1 = int(input("Selecciona el índice del primer archivo: "))
idx2 = int(input("Selecciona el índice del segundo archivo: "))

path1 = os.path.join(FOLDER, archivos[idx1])
path2 = os.path.join(FOLDER, archivos[idx2])

# Leer, codificar y predecir
with open(path1, encoding="utf-8") as f1, open(path2, encoding="utf-8") as f2:
    c1, c2 = f1.read(), f2.read()
    e1 = np.array([encode(c1, token_to_id)])
    e2 = np.array([encode(c2, token_to_id)])
    prob = model.predict([e1, e2])[0][0]
    print(f"\nProbabilidad de plagio entre {archivos[idx1]} y {archivos[idx2]}: {prob:.2f}")