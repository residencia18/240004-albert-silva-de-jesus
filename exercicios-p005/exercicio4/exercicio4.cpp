/*Exercício 4: Operações com valores de ponto flutuante
● Escreva um programa que:
a. Declare três variáveis de tipo double, vamos chamar de x, y e z mas você pode escolher outro identificador se achar mais apropriado;

b. Peça ao usuário para digitar dois números de ponto flutuante, obtenha-os da entrada padrão, usando cin, e atribua os valores digitados às variáveis x e y respectivamente;

c. Considerando que x e y são coordenadas num plano cartesiano, identifique em que lado da curva f(x) = 5x + 2 se encontra (esquerda, direita ou na curva). Imprima o resultado na tela;

d. Atividade avançada: Atribua à variável z o valor da distância euclidiana do ponto (x, y) ao centro de coordenadas; (distância euclidiana se calcula como a raiz quadrada da soma dos quadrados,(pesquise na biblioteca padrão como determinar a raiz quadrada de um número)

e. Atribua à variável z o produto entre as variáveis x e y, imprima o resultado na tela em notação científica;*/

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

    cout << "O ponto (" << x << ", " << y << ") esta a " << (5 * x + 2 > y ? "esquerda" : (5 * x + 2 < y ? "direita" : "na curva")) << " da curva f(x) = 5x + 2" << endl;

    z = sqrt(pow(x, 2) + pow(y, 2));
    cout << "A distancia euclidiana do ponto (" << x << ", " << y << ") ao centro de coordenadas é " << z << endl;

    z = x * y;
    cout << "O produto entre os numeros digitados em notacao cientifica: " << z << endl;
}