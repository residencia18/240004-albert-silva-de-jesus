/*Exercício 4: Operações com valores de ponto flutuante
● Escreva um programa que:
e. Atribua à variável z o produto entre as variáveis x e y, imprima o resultado na tela em notação científica;*/

#include <iostream>
#include <cmath>
using namespace std;

int main()
{

    double x, y, z;

    cout << "Digite um numero de ponto flutuante: ";
    cin >> x;

    cout << "Digite outro numero de ponto flutuante: ";
    cin >> y;

    z = x * y;
    cout << "O produto entre os numeros digitados em notacao cientifica: " << z << endl;
}