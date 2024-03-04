/*Exercício 2: Trabalhando com arrays
● A seguinte expressão em C++ gera um valor inteiro aleatório entre 1 e 20: 1 + rand()%20. Utilizando esta expressão desenvolva uma aplicação que:
a. Preencha um array com 100 elementos de tipo int, com valores aleatoriamente gerados entre 1 e 20;
b. Utilize um array de 20 posições para determinar quantas vezes se repete cada um dos possíveis valores gerados no array;
c. Determine qual ou quais os números que mais vezes aparecem no array;*/

#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

constexpr int Max = 100;

int main()
{
    srand(time(NULL));
    int array[Max] = {0};
    int contagem[Max] = {0};
    int num[Max] = {0};
    int cont = 0;

    for (int i = 0; i < Max; i++)
    {
        array[i] = 1 + rand() % 20;
    }

    cout << "\nValores gerados:\n";
    for (int i = 0; i < Max; i++)
    {
        cout << "Valor = " << array[i] << endl;
    }

    for (int i = 0; i < Max; ++i)
    {
        int valorAtual = array[i];
        int contador = 0;

        for (int j = 0; j < Max; ++j)
        {
            if (array[j] == valorAtual)
            {
                contador++;
            }
        }

        // Verifica se o valor já existe no array
        for (int j = 0; j < cont; j++)
        {
            if (valorAtual == num[j])
            {
                contador = 0;
            }
        }

        // Atualiza a contagem para o valor atual
        if (contador >= 2 && valorAtual != num[cont])
        {
            num[cont] = valorAtual;
            contagem[cont] = contador;
            cont++;
        }
    }

    cout << "\nValores que mais se repetem:\n";
    for (int i = 0; i < cont; i++)
    {
        cout << "Valor = " << num[i] << " - Repeticoes = " << contagem[i] << endl;
    }
}