/*Exercício 4: Operações com valores de ponto flutuante
● Escreva um programa que:
c. Considerando que x e y são coordenadas num plano cartesiano, identifique em que lado da curva f(x) = 5x + 2 se encontra (esquerda, direita ou na curva). Imprima o resultado na tela;*/

#include <iostream>
using namespace std;

int main()
{

    int x, y;

    cout << "Digite um numero de ponto flutuante: ";
    cin >> x;

    cout << "Digite outro numero de ponto flutuante: ";
    cin >> y;

    cout << "O ponto (" << x << ", " << y << ") esta a " << (5 * x + 2 > y ? "esquerda" : (5 * x + 2 < y ? "direita" : "na curva")) << " da curva f(x) = 5x + 2" << endl;
}