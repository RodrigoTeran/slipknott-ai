#include <iostream>
#include <vector>

using namespace std;

double calcularPromedio(const vector<int>& numeros) {
    if (numeros.empty()) return 0.0;
    
    double suma = 0.0;
    for (int num : numeros) {
        suma += num;
    }
    return suma / numeros.size();
}

int encontrarMaximo(const vector<int>& numeros) {
    if (numeros.empty()) return -1;
    
    int maximo = numeros[0];
    for (size_t i = 1; i < numeros.size(); ++i) {
        if (numeros[i] > maximo) {
            maximo = numeros[i];
        }
    }
    return maximo;
}

int main() {
    vector<int> datos = {12, 45, 23, 67, 8, 34};
    
    cout << "Promedio: " << calcularPromedio(datos) << endl;
    cout << "Valor máximo: " << encontrarMaximo(datos) << endl;
    
    return 0;
}