
/*Exercício 2: Trabalhando com arrays
● A seguinte expressão em C++ gera um valor inteiro aleatório entre 1 e 20: 1 + rand()%20. Utilizando esta expressão desenvolva uma aplicação que:
a. Preencha um array com 100 elementos de tipo int, com valores aleatoriamente gerados entre 1 e 20;*/

#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;
constexpr int Max = 100;

int main()
{

    srand(time(nullptr));

    int vect[Max];

    for (int i = 0; i < Max; i++)
    {
        vect[i] = rand() % 20;
    }

    for (int y = 0; y < Max; y++)
    {
        printf("\n%dº elemento", y + 1, vect[y]);
    }
}