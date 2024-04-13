/*Exercício 4: Operações com valores de ponto flutuante
● Escreva um programa que:
d. Atividade avançada: Atribua à variável z o valor da distância euclidiana do ponto (x, y) ao centro de coordenadas; (distância euclidiana se calcula como a raiz quadrada da soma dos quadrados,(pesquise na biblioteca padrão como determinar a raiz quadrada de um número)*/

#include <iostream>
#include <cmath>
using namespace std;

int main()
{

    double x, y, z;

    cout << "Digite um numero de ponto flutuante: ";
    cin >> x;

    cout << "Digite outro numero de ponto flutuante: ";
    cin >> y;

    z = sqrt(pow(x, 2) + pow(y, 2));
    cout << "A distancia euclidiana do ponto (" << x << ", " << y << ") ao centro de coordenadas é " << z << endl;
}