/*Exercício 1: Instale e configure o Git
Exercício 2:
Escreva um programa em C++ que leia um número inteiro e verifique se ele é um palíndromo. Um número é palíndromo se ele permanece o mesmo quando seus
dígitos são invertidos.*/

#include <iostream>
#include <string>
using namespace std;

int main()
{
    int numero, numeroInvertido = 0, resto, numeroOriginal;

    cout << "Digite um numero inteiro: ";
    cin >> numero;

    numeroOriginal = numero;
    while (numero != 0)
    {
        resto = numero % 10;
        numeroInvertido = numeroInvertido * 10 + resto;
        numero /= 10;
    }
    if (numeroOriginal == numeroInvertido)
        cout << numeroOriginal << " eh um numero palindromo";
    else
        cout << numeroOriginal << " nao eh um numero palindromo";
}