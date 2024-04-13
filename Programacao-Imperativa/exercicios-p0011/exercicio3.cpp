/*Exercício 3:
Faça uma função que receba (por referência) 4 variáveis float e ordena (crescente) os valores destas variáveis. Depois faça o programa principal para testar a sua função. */

#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

void preencherRandom(float &num1, float &num2, float &num3, float &num4);

void ordenaCrescente(float &num1, float &num2, float &num3, float &num4);

int main()
{
    srand(time(nullptr));

    float a, b, c, d;

    preencherRandom(a, b, c, d);

    ordenaCrescente(a, b, c, d);
}

void preencherRandom(float &num1, float &num2, float &num3, float &num4){

    num1 = rand() % 1000;
    num2 = rand() % 1000;
    num3 = rand() % 1000;
    num4 = rand() % 1000;
}

void ordenaCrescente(float &num1, float &num2, float &num3, float &num4)
{
    float aux = 0;

    if (num1 < num2)
    {
        aux = num1;
        num1 = num2;
        num2 = aux;
    }

    if (num1 < num3)
    {
        aux = num1;
        num1 = num3;
        num2 = aux;
    }

    if (num1 < num4)
    {
        aux = num1;
        num1 = num4;
        num4 = aux;
    }

    if(num2 < num1){

        aux = num2;
        num2 = num1;
        num1 = aux;
    }

    if(num2 < num3){

        aux = num2;
        num2 = num3;
        num3 = aux;
    }

    if(num2 < num4){

        aux = num2;
        num2 = num4;
        num4 = aux;
    }

    if(num3 < num1){

        aux = num3;
        num3 = num1;
        num1 = aux;
    }

    if(num3 < num2){

        aux = num3;
        num3 = num2;
        num2 = aux;
    }

    if(num3 < num4){

        aux = num3;
        num3 = num4;
        num4 = aux;
    }

    if(num4 < num1){

        aux = num4;
        num4 = num1;
        num1 = aux;
    }

    if(num4 < num2){

        aux = num4;
        num4 = num2;
        num2 = aux;
    }

    if(num4 < num3){

        aux = num4;
        num4 = num3;
        num3 = aux;
    }

    cout << "\n" << num1 << ", " << num2 << ", " << num3 << ", " << num4 << endl;
    cout << endl;
}