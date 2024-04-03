/*Exercício 5: Operadores bit a bit
● Uma pesquisa monitora 8 genes de uma planta para avaliar como cada um deles influencia na resposta a uma determinada praga. Os pesquisadores optaram por representar a informação dos genes de cada planta com um inteiro sem sinal, onde cada bit da representação binária identifica se um gene está presente (1) ou não (0) naquela planta. Implemente um programa que:

    a. Leia a informação genética de uma planta na forma de um caractere sem sinal (unsigned char);
    b. Utilizando os operadores bit a bit identifique quantos, dos genes estudados, estão presentes;
    c. Solicite do usuário a informação sobre qual gene específico ele que informação (um valor inteiro entre 1 e 8) e retorne se este gene se encontra nesta planta.*/

#include <iostream>
using namespace std;

int main()
{
    unsigned char genes;
    int gene;

    cout << "Digite a informação genetica da planta: ";
    cin >> genes;

    cout << "A planta tem " << __builtin_popcount(genes) << " genes presentes" << endl;
    cout << "Digite o gene que deseja saber se esta presente: ";
    cin >> gene;

    if (genes & (1 << (gene - 1)))
    {
        cout << "O gene " << gene << " esta presente na planta" << endl;
    }
    else
    {
        cout << "O gene " << gene << " nao esta presente na planta" << endl;
    }
}
