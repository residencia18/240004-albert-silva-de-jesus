/*Exercício 3: Operações com caracteres
● Escreva um programa que
f. Atribua à variável ch3 o valor 'a' se o caractere ch2 for uma letra minúscula e o valor ' '(caractere espaço vazio) caso contrário. Use o
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

    (islower(ch2)) ? (ch3='a') : (ch3 = ' ');

    printf("%d - %o - %x \n", ch3, ch3 , ch3);

}