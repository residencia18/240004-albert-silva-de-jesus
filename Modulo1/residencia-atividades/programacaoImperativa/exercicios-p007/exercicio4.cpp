/*Exercício 1: Instale e configure o Git
Exercício 4:
Escreva um programa em C++ que imprima todos os números primos de 1 a 100.*/

#include <iostream>
using namespace std;

int main()
{

    bool ePrimo = true;
    int divisivel = 0;
    int cont = 0, num = 1;
    int primos[100];

    for (int i = 0; i < 97; i++)
    {
        while (ePrimo)
        {
            for (int y = 1; y <= num; y++)
            {

                if (num % y == 0)
                {
                    divisivel++;
                }
            }
            if (divisivel == 2 || num == 1 )
            {
                ePrimo = false;
                divisivel = 0;
                primos[cont] = num;
            }
            else
            {
                divisivel = 0;
                num++;
            }
        }
        if (num == 97)
        {
            i = 97;
        }
        cont++;
        num++;
        ePrimo = true;
    }
    for (int x = 0; x < cont; x++)
    {
        cout << "," << primos[x];
    }
}