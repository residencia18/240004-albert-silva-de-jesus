/*Exercício 10:
Escreva um programa em C++ que leia um número inteiro e verifique se ele é um número armstrong. Um número armstrong (ou narcisista) é um número que é igual à soma de seus próprios dígitos elevados à quantidade de dígitos. Por exemplo, 153 é um número armstrong porque 1³ + 5³ + 3³ = 153.*/

#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    int numero, soma = 0, digitos = 0, numero2;

    cout << "Digite um numero inteiro: ";
    cin >> numero;

    numero2 = numero;

    while (numero2 > 0)
    {
        numero2 /= 10;
        digitos++;
    }

    numero2 = numero;

    while (numero2 > 0)
    {
        soma += pow(numero2 % 10, digitos);
        numero2 /= 10;
    }

    if (soma == numero)
    {
        cout << "O numero " << numero << " é armstrong." << endl;
    }
    else
    {
        cout << "O numero " << numero << " nao eh armstrong." << endl;
    }
}