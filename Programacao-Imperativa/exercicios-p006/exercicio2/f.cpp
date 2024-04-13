/*Exercício 2: Operações com inteiros
● Escreva um programa que:
f. Comente no código o por que dos resultados destas expressões serem diferentes. Demonstre implementando outra variação desta
expressão que gere resultado diferente;*/

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

    // c = = 4*(a + b)/(3 - 5); e  c = 4*a + b/3 - 5; são diferentes pela ordem de preferência
    // outra variação 4*(a+b)/3 -5 é outra variação

    cout << "c = " << c << endl;
}