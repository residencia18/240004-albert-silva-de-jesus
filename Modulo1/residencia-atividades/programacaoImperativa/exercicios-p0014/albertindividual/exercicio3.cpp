/*Exercício 3: Estruturas de Dados com Structs
• Crie uma struct chamada "Ponto" que represente as coordenadas (x, y) de um ponto no plano.
• Implemente uma função que calcule a distância entre dois pontos.
• Utilize a struct e a função para calcular e exibir a distância entre dois pontos dados.*/

#include <iostream>
#include <cmath>
using namespace std;

struct Ponto
{
    float x;
    float y;
};

float calculaDistancia(Ponto ponto1, Ponto ponto2);

int main()
{
    Ponto ponto1;
    Ponto ponto2;

    cout << "\nDigite o valor de x do primeiro ponto: ";
    cin >> ponto1.x;

    cout << "\nDigite o valor de y do primeiro ponto: ";
    cin >> ponto1.y;

    cout << "\nDigite o valor de x do segundo ponto: ";
    cin >> ponto2.x;

    cout << "\nDigite o valor de y do segundo ponto: ";
    cin >> ponto2.y;

    cout << "\nA distância entre os pontos é: " << calculaDistancia(ponto1, ponto2) << endl;
}

float calculaDistancia(Ponto ponto1, Ponto ponto2)
{
    float distancia = sqrt(pow(ponto2.x - ponto1.x, 2) + pow(ponto2.y - ponto1.y, 2));
    return distancia;
}

