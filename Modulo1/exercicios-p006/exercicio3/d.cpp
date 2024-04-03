/*Exercício 3: Operações com caracteres
● Escreva um programa que
d. Atribua à variável ch3 o caractere que precede ao caractere ch2, imprima na tela, utilizando printf, o caractere em formato numérico
decimal, octal, hexadecimal e como caractere; (caso ch3 não seja um caractere imprimível, substitua ele pelo caractere '_')*/

#include <iostream>
#include <cctype>
using namespace std;

int main()
{

    char ch1, ch2, ch3;

    cout << "Entre com um caractere : ";
    cin >> ch1;

    cout << "Entre com outro caractere : ";
    cin >> ch2;

    (((int)ch2 - 1) <= 255 && ((int)ch2 - 1) >= 0) ? (ch3 = (int)ch2 - 1) : (ch3 = '_');

    printf("%d - %o - %x - %c\n", (int)ch3, (int)ch3, (int)ch3, ch3);
}