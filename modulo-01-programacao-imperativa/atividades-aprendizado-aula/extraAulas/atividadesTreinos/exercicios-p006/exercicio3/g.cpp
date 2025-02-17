/*Exercício 3: Operações com caracteres
● Escreva um programa que
g. Atribua à variável ch3 o valor '1' se o caractere ch1 ou o caractere ch2 forem um dígito e o valor ' '(caractere espaço vazio) caso contrário. Use o operador condicional (?) com esta finalidade. Imprima o valor de ch3 na tela;*/

#include <iostream>
#include <cctype>
using namespace std;

int main(){

    char ch1, ch2, ch3;

    cout << "Entre com um caractere : ";
    cin >> ch1;

    cout << "Entre com outro caractere : ";
    cin >> ch2;

    (isdigit(ch2) || isdigit(ch1)) ? (ch3='1') : (ch3 = ' ');

    printf("%d - %o - %x \n", ch3, ch3 , ch3);
}