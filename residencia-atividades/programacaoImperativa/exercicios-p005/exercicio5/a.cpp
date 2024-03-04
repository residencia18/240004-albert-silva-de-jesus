/*Exercício 5: Operadores bit a bit
● Uma pesquisa monitora 8 genes de uma planta para avaliar como cada um deles influencia na resposta a uma determinada praga. Os pesquisadores optaram por representar a informação dos genes de cada planta com um inteiro sem sinal, onde cada bit da representação binária identifica se um gene está presente (1) ou não (0) naquela planta. Implemente um programa que:
    a. Leia a informação genética de uma planta na forma de um caractere sem sinal (unsigned char);*/

#include <iostream>

using namespace std;

int main()
{

    unsigned char gene;

    cout << "Entre com o caractere do gene";
    cin >> gene;

    return 0;
}