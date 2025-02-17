/*Escreva um programa em C++ que leia um número inteiro e imprima a sequência de Fibonacci (Referência abaixo) até o número fornecido pelo usuário.*/

#include <iostream>
using namespace std;

int main()
{
    int numero, primeiro = 0, segundo = 1, proximo;

    cout << "Digite um numero inteiro: ";
    cin >> numero;

    cout << "Sequencia de Fibonacci: " << endl;

    for (int i = 0; i <= numero; i++)
    {
        if (i <= 1)
        {
            proximo = i;
        }
        else
        {
            proximo = primeiro + segundo;
            primeiro = segundo;
            segundo = proximo;
        }
        cout << proximo << " ";
    }
    cout << endl;
}