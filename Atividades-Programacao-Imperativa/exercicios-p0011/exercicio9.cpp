/*Exercício 9:
Faça uma função para calcular o valor de S, dado por:
Protótipo da função: float calc_serie(int N);*/

#include <iostream>
#include <cmath>
using namespace std;

float calc_serie(int N);

int main()
{
    float s;
    cout << "\nDigite o valor de N: ";
    cin >> s;

    cout << "\nO valor de S é: " << calc_serie(s) << endl;
}

float calc_serie(int N)
{
    float S = 0;
    for (int i = 1; i <= N; i++)
    {
        S += (i / pow(2, i));
    }
    return S;
}
