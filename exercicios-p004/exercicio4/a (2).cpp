/*Exercício 4: Manipulação de variáveis de ponto flutuante, explorando os limites.
● Durante a aula foram apresentados o tipo de dados double e suas variações, que permitem representar um subconjunto dos números reais.
Sobre estes tipos de dados crie uma aplicação que:

a. Sobre o tipo float identifique qual o menor e o maior valor que pode ser representado por uma variável deste tipo. Mostre esta informação na tela.*/

#include <iostream>
#include <limits>

using namespace std;

int main()
{

    // float maior = 3.402823466e+38;
    // float menor = 1.175494351e-38;

    float maior = numeric_limits<float>::max();
    float menor = numeric_limits<float>::min();

    cout << "Maior valor representado em float: " << maior;
    cout << "\nMenor valor representado em float: " << menor << "\n";

}