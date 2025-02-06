/*Exercício 5: Operadores bit a bit
● Uma pesquisa monitora 8 genes de uma planta para avaliar como cada um deles influencia na resposta a uma determinada praga. Os pesquisadores optaram por representar a informação dos genes de cada planta com um inteiro sem sinal, onde cada bit da representação binária identifica se um gene está presente (1) ou não (0) naquela planta. Implemente um programa que:
    b. Utilizando os operadores bit a bit identifique quantos, dos genes estudados, estão presentes;*/

#include <iostream>

using namespace std;

int main()
{

    unsigned char gene;

    cout << "Entre com o caractere do gene : ";
    cin >> gene;
    gene = 10;
    int count = 0;

    count += (gene & 0x01);
    count += (gene & 0x02) >> 1;
    count += (gene & 0x04) >> 2;
    count += (gene & 0x08) >> 3;
    count += (gene & 0x10) >> 4;
    count += (gene & 0x20) >> 5;
    count += (gene & 0x40) >> 6;
    count += (gene & 0x80) >> 7;

    cout << "Quantidade de genes estudados : " << count << endl;

    return 0;
}