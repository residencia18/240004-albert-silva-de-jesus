/*Parte Individual:
Exercício 1: Reutilização de Funções
• Escreva uma função em C++ que calcule o fatorial de um número inteiro.
• Crie um programa que utilize essa função para calcular e exibir o fatorial de
três números diferentes.
*/

#include <iostream>
using namespace std;

int fatorial(int n);

int main()
{
    int n1, n2, n3;

    cout << "\nDigite o primeiro numero: ";
    cin >> n1;

    cout << "\nDigite o segundo numero: ";
    cin >> n2;

    cout << "\nDigite o terceiro numero: ";
    cin >> n3;

    cout << "\nFatorial de " << n1 << ": " << fatorial(n1) << endl;
    cout << "\nFatorial de " << n2 << ": " << fatorial(n2) << endl;
    cout << "\nFatorial de " << n3 << ": " << fatorial(n3) << endl;
}

int fatorial(int n)
{
    int fat = 1;
    for (int i = 1; i <= n; i++)
    {
        fat *= i;
    }
    return fat;
}