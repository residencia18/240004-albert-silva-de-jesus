/*Exercício 4: Operações com valores de ponto flutuante.
● Escreva um programa que
b. Peça ao usuário para digitar dois números de ponto flutuante, obtenha-os da entrada padrão, usando scanf, e atribua os valores digitados às variáveis x e y respectivamente;*/

#include <iostream>

using namespace std;

int main()
{

    double x, y, z;

    printf("Entre com o valor de x :");
    scanf("%lf", &x);

    printf("Entre com o valor de y :");
    scanf("%lf", &y);

    printf("%f, %f", x, y);
}