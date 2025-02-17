/*Exercício 3: Operações com caracteres
● Escreva um programa que
c. Atribua à variável ch3 o caractere que antecede ao caractere ch1, imprima na tela, utilizando cout, o caractere em formato numérico decimal, octal, hexadecimal e como caractere; (caso ch3 não seja um caractere imprimível, substitua ele pelo caractere '_')*/

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

    (((int)ch1-1) <= 255 && ((int)ch1-1) >=0) ? (ch3 = (int)ch1-1) : (ch3='_');

    cout << dec << (int)ch3 << " - " <<  oct << (int)ch3 << " - " <<  hex << (int)ch3 << " - " << ch3 << endl;

}