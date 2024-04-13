/*Exercício 2: Operações com char1s
● Escreva um programa que:
f. Dado que o caractere char2 é uma letra maiúscula, atribua à variável ch3 o caractere que corresponde à mesma letra minúscula (não pode procurar na tabela ASCII) e Imprima ch3 na tela, utilizando cout, em formato numérico decimal, octal, hexadecimal e como caractere*/

#include <iostream>
#include <windows.h>
#include <cctype>
using namespace std;

int main()
{

    int x = 81;
    char char2 = x;

    cout << dec << "\ndec - " << int(char2) << oct << ", oct - 0" << int(char2) << hex << ", hex - " << int(char2) << " Caractere " << char2 << "\n";

    char2 = static_cast<char>(tolower(static_cast<char>(char2)));
    cout << "\nASCII de char2 transformada para minúsculo = ( " << char2 << " )\n";

    /*Outra forma de saber o caractere da tabela ASCII
     int valorAscii = 81;
     char caractere = static_cast<char>(valorAscii);
     cout << "O caractere correspondente ao valor ASCII " << valorAscii << " é: " << caractere << endl;*/
}