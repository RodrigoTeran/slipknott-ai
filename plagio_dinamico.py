import os
import pandas as pd
import subprocess
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import train_test_split, learning_curve
from sklearn.metrics import classification_report, confusion_matrix, ConfusionMatrixDisplay

# === CONFIGURACIÓN ===
BASE_DIR = r"C:\Users\dafne\OneDrive\Documentos\GitHub\slipknott-ai\conplag_version_2"
LABELS_PATH = os.path.join(BASE_DIR, "versions", "labels.csv")
VERSIONS_DIR = os.path.join(BASE_DIR, "versions", "version_2")
INPUT_EXAMPLE = "1\n1\na\n"

# === FUNCIONES AUXILIARES ===
def execute_java(sub_id, version_id):
    file_path = os.path.join(VERSIONS_DIR, f"{sub_id}_{version_id}", f"{sub_id}.java")
    if not os.path.exists(file_path):
        return "MISSING_FILE"

    try:
        base_dir = os.path.dirname(file_path)
        class_name = sub_id

        # Compilar
        subprocess.run(["javac", f"{sub_id}.java"], cwd=base_dir, capture_output=True, timeout=10)

        # Ejecutar
        result = subprocess.run(
            ["java", class_name],
            input=INPUT_EXAMPLE.encode(),
            capture_output=True,
            cwd=base_dir,
            timeout=5
        )
        return result.stdout.decode().strip()
    except subprocess.TimeoutExpired:
        return "TIMEOUT"
    except Exception as e:
        return f"ERROR: {e}"

def get_code_length(sub_id, version_id):
    file_path = os.path.join(VERSIONS_DIR, f"{sub_id}_{version_id}", f"{sub_id}.java")
    if os.path.exists(file_path):
        with open(file_path, "r", encoding="utf-8") as f:
            return len(f.read())
    return 0

def trace_diff(row):
    trace1 = execute_java(row['sub1'], row['problem'])
    trace2 = execute_java(row['sub2'], row['problem'])
    return abs(hash(trace1) - hash(trace2))

def trace_len_diff(row):
    trace1 = execute_java(row['sub1'], row['problem'])
    trace2 = execute_java(row['sub2'], row['problem'])
    return abs(len(trace1) - len(trace2))

def code_len_diff(row):
    len1 = get_code_length(row['sub1'], row['problem'])
    len2 = get_code_length(row['sub2'], row['problem'])
    return abs(len1 - len2)

# === CARGA Y PROCESAMIENTO DE DATOS ===
def load_and_process():
    print(f"Usando archivo de etiquetas: {LABELS_PATH}")
    df = pd.read_csv(LABELS_PATH)
    print(f"Procesando {len(df)} pares...")

    df['trace_diff'] = df.apply(trace_diff, axis=1)
    df['trace_len_diff'] = df.apply(trace_len_diff, axis=1)
    df['code_len_diff'] = df.apply(code_len_diff, axis=1)

    return df

# === ENTRENAMIENTO Y VISUALIZACIÓN ===
def train_and_evaluate(df):
    features = ['trace_diff', 'trace_len_diff', 'code_len_diff']
    X = df[features]
    y = df['verdict']

    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

    clf = RandomForestClassifier(n_estimators=100, random_state=42)
    clf.fit(X_train, y_train)
    y_pred = clf.predict(X_test)

    # Reporte
    print("\n=== Reporte de Clasificación ===")
    print(classification_report(y_test, y_pred))

    # Matriz de confusión
    cm = confusion_matrix(y_test, y_pred)
    disp = ConfusionMatrixDisplay(confusion_matrix=cm, display_labels=clf.classes_)
    disp.plot(cmap="Blues")
    plt.title("Matriz de Confusión")
    plt.show()

    # Curva de aprendizaje
    train_sizes, train_scores, test_scores = learning_curve(
        clf, X, y, cv=5, scoring='accuracy', train_sizes=[0.1, 0.3, 0.5, 0.7, 1.0], n_jobs=-1
    )
    train_scores_mean = train_scores.mean(axis=1)
    test_scores_mean = test_scores.mean(axis=1)

    plt.figure()
    plt.plot(train_sizes, train_scores_mean, 'o-', label="Entrenamiento")
    plt.plot(train_sizes, test_scores_mean, 'o-', label="Validación")
    plt.title("Curva de Aprendizaje")
    plt.xlabel("Tamaño del conjunto de entrenamiento")
    plt.ylabel("Precisión")
    plt.legend()
    plt.grid()
    plt.show()

# === MAIN ===
if __name__ == "__main__":
    df = load_and_process()
    print(df['verdict'].value_counts())  # Balanceo de clases
    train_and_evaluate(df)
