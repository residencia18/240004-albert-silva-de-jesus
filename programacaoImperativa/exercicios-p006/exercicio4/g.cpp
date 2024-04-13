/*Exercício 4: Operações com valores de ponto flutuante.
● Escreva um programa que
g. Atribua à variável z o menor valor entre as variáveis x e y, imprima o resultado na tela;*/

#include <iostream>
using namespace std;

int main()
{
    float x, y, z;

    cout << "Digite o valor de x: ";
    cin >> x;

    cout << "Digite o valor de y: ";
    cin >> y;

    if (x < y)
    {
        z = x;
    }
    else
    {
        z = y;
    }

    cout << "O valor de z é: " << z << endl;
}