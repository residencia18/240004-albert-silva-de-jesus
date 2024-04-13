/*Exercício 2: Operações com inteiros
● Escreva um programa que:
e. Atribua à variável c o valor da expressão 4 * (𝑎 + 𝑏) / (3 − 5). Imprima o resultado na tela;*/

#include <iostream>
using namespace std;

int main()
{

    int a, b, c;

    cout << "Digite o valor de a: ";
    cin >> a;

    cout << "Digite o valor de b: ";
    cin >> b;

    c = 4 * (a + b) / (3 - 5);

    cout << "c = " << c << endl;
}