# Slipknott-ai

## Detector de Plagio en Código Fuente

Este proyecto utiliza una red neuronal para detectar similitud potencialmente plagiada entre pares de archivos de código en varios lenguajes (Python, C++, Java, etc.).

## Cómo correr el entrenamiento

Ejecuta el script principal para entrenar y evaluar el modelo:

```bash
python modelo_entrenamiento.py
```

## Cómo hacer una predicción

Después de entrenar, puedes comparar dos archivos nuevos ejecutando:

```bash
python test_plagio.py
```

Se te pedirá elegir dos archivos de la carpeta `codigos_de_prueba/`. El modelo mostrará la probabilidad de que haya plagio entre ellos.
