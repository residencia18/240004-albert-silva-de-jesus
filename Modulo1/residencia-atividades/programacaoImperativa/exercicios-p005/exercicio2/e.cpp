/*Exercício 2: Operações com char1s
● Escreva um programa que:
e. Atribua à variável ch2 o caractere 81, identifique e imprima na tela, utilizando cout, o caractere em formato numérico decimal, octal, hexadecimal e como caractere;*/

#include <iostream>
#include <cctype>

using namespace std;

int main()
{

    char ch1, ch2, ch3;

    ch2 = 81;

    cout << dec << (int)ch2 << " - " << oct << (int)ch2 << " - " << hex << (int)ch2 << " - " << ch2 << endl;

    return 0;
}