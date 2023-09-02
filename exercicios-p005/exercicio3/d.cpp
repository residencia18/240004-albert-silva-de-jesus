/*Exercício 3: Operações com inteiros
 Escreva um programa, usando quando necessário o operador (?), que:

d. Atribua à variável c o produto das variáveis a e b, imprima o
resultado na tela em formato octal;*/

#include <iostream>
using namespace std;

int main()
{
    int a, b, c;

    cout << "Digite o 1º número: ";
    cin >> a;

    cout << "Digite o 2º número: ";
    cin >> b;

    c = a * b;

    cout << "Produto dos números em octal: " << oct << c << endl;
}