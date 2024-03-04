/*Exercício 4:
Escreva uma função calcula que:
a. receba como parâmetros duas variáveis inteiras, X e Y;
b. retorne em X a soma de X e Y;
c. retorne em Y a subtração de X e Y.*/

#include <iostream>

using namespace std;

void calcula(int &x, int &y);

int main()
{
    int a = 1979, b = 2023;

    calcula(a, b);

    cout << "a = " << a << endl;
    cout << "b = " << b << endl;
}

void calcula(int &x, int &y)
{
    x = x + y;
    y = x - y;
}