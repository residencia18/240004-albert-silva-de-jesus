/*Exercício 9:
Escreva um programa em C++ que leia um número inteiro e determine se ele é um número perfeito. Um número perfeito é aquele cuja soma dos seus divisores, excluindo ele mesmo, é igual ao próprio número.*/

#include <iostream>
using namespace std;

int main()
{
    int numero, soma = 0;

    cout << "Digite um numero inteiro: ";
    cin >> numero;

    for (int i = 1; i < numero; i++)
    {
        if (numero % i == 0)
        {
            soma += i;
        }
    }

    if (soma == numero)
    {
        cout << "O numero " << numero << " é perfeito." << endl;
    }
    else
    {
        cout << "O numero " << numero << " nao eh perfeito." << endl;
    }
}