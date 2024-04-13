/*Exercício 4: Operações com valores de ponto flutuante.
● Escreva um programa que
c. Atribua à variável z a somas das variáveis a e b, imprima o resultado na tela;*/

#include <iostream>
using namespace std;

int main()
{
    float a, b, z;

    cout << "Digite o valor de a: ";
    cin >> a;

    cout << "Digite o valor de b: ";
    cin >> b;

    z = a + b;

    cout << "O valor de z é: " << z << endl;
}