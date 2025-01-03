/*Exercício 2: Trabalhando com arrays
● A seguinte expressão em C++ gera um valor inteiro aleatório entre 1 e 20: 1 + rand()%20. Utilizando esta expressão desenvolva uma aplicação que:
b. Utilize um array de 20 posições para determinar quantas vezes se repete cada um dos possíveis valores gerados no array;*/

#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;
constexpr int Max = 20;

int main()
{

    srand(time(nullptr));

    // Array para rastrear a contagem de ocorrências de cada valor
    int contagem[Max] = {0}; // Inicializa todas as contagens como zero
    int vect[Max] = {0};
    int copia[Max];
    int contador = 0, valorAtual, x = 0;

    for (int i = 0; i < Max; i++)
    {
        vect[i] = rand() % 20;
    }
    
    cout << "\nValores gerados:\n";
    for (int i = 0; i < Max; i++)
    {
        cout << "Valor: " << vect[i] << endl;
    }

    // Contagem de ocorrências
    for (int i = 0; i < Max; ++i)
    {
        valorAtual = vect[i];
        contador = 0;

        for (int j = 0; j < Max; ++j)
        {
            if (vect[j] == valorAtual)
            {
                contador++;
            }
        }

        // Verifica se o valor já existe no array
        for (int j = 0; j < x; j++)
        {
            if (valorAtual == copia[j])
            {
                contador = 0;
            }
        }
        // Atualiza a contagem para o valor atual
        if (contador > 1 && valorAtual != copia[x - 1])
        {
            contagem[x] = contador;
            copia[x] = valorAtual;
            x++;
        }
    }

    cout << "\n"
         << endl;

    for (int i = 0; i < x; i++)
    {
        cout << "Valor: " << copia[i] << ": se repeti: " << contagem[i] << endl;
    }
}
