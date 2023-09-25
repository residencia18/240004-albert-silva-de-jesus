/*Exercício 3: Operações com caracteres
● Escreva um programa que
e. Atribua à variável ch3 o valor 'A' se o caractere ch1 for uma letra maiúscula e o valor ' '(caractere espaço vazio) caso contrário. Use o
operador condicional (?) com esta finalidade. Imprima o valor de ch3 na tela;*/

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

    ch3 = (isupper(ch1)) ? 'A' : ' ';

    printf("%c\n", ch3);
}