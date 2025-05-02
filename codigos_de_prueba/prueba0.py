def calcular_promedio(numeros):
    total = 0
    cantidad = 0
    for num in numeros:
        total += num
        cantidad += 1
    if cantidad == 0:
        return 0
    return total / cantidad

def encontrar_maximo(numeros):
    maximo = numeros[0]
    for num in numeros:
        if num > maximo:
            maximo = num
    return maximo

lista = [5, 8, 2, 10, 3]
print(f"Promedio: {calcular_promedio(lista)}")
print(f"Máximo: {encontrar_maximo(lista)}")