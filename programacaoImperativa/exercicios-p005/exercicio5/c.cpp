/*Exercício 5: Operadores bit a bit
● Uma pesquisa monitora 8 genes de uma planta para avaliar como cada um deles influencia na resposta a uma determinada praga. Os pesquisadores optaram por representar a informação dos genes de cada planta com um inteiro sem sinal, onde cada bit da representação binária identifica se um gene está presente (1) ou não (0) naquela planta. Implemente um programa que:
    c. Solicite do usuário a informação sobre qual gene específico ele que informação (um valor inteiro entre 1 e 8) e retorne se este gene se encontra nesta planta.*/

#include <iostream>
#include <cmath>

using namespace std;

int main()
{

    unsigned char gene;
    int count = 0;
    int geneEspecifico;

    cout << "Entre com o caractere do gene : ";
    cin >> gene;

    count += (gene & 0x01);
    count += (gene & 0x02) >> 1;
    count += (gene & 0x04) >> 2;
    count += (gene & 0x08) >> 3;
    count += (gene & 0x10) >> 4;
    count += (gene & 0x20) >> 5;
    count += (gene & 0x40) >> 6;
    count += (gene & 0x80) >> 7;

    cout << "Qual gene especifico busca essa informação ?  ";
    cin >> geneEspecifico;

    cout << ((gene & (int)round(pow(2, (geneEspecifico - 1)))) >> (geneEspecifico - 1) ? "O gene se encontra nessa planta" : "O Gene não se encontra na planta") << endl;

    return 0;
}