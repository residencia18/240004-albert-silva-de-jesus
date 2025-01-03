/*Exercício 7: 
Exercício 6: 
Escreva um programa em C++ que gere e imprima o seguinte padrão de caracteres alfanuméricos, onde o número fornecido pelo usuário é a altura do padrão:
A
BC
DEF
GHIJ
KLMNO*/

#include <iostream>
using namespace std;

int main()
{
    int altura;
    char letra = 'A';

    cout << "Digite a altura do padrao: ";
    cin >> altura;

    for (int i = 0; i < altura; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            cout << letra;
            letra++;
        }
        cout << endl;
    }
}