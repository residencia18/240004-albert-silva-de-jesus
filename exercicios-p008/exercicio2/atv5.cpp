/*Exercício 2: Trabalhando com arrays
● A seguinte expressão em C++ gera um valor de ponto flutuante aleatório entre 10 e 40: 1 + 30.0*(rand()%100)/3000.0. Supondo que se deseja simular uma rede de estações meteorológicas, implemente uma aplicação que:

a. Armazene num array as temperaturas reportadas por 250 estações meteorológicas.

b. Determine a temperatura máxima e mínima reportadas;

c. Determine a temperatura média entre as 250 estações;

d. Um modelo de predição estima que, dentro de uma hora, as estações que estão marcando temperatura acima da média vão ficar 1 grau mais quente. Já as que estão marcando abaixo da média vão ficar 2 graus mais frias. Atualize o array com as temperaturas das estações, de acordo com a previsão do modelo.*/

#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int main()
{
    srand(time(NULL));
    float temperatura[250];
    float soma = 0;
    float media = 0;
    float max = 0;
    float min = 0;

    for (int i = 0; i < 250; i++)
    {
        temperatura[i] = 1 + 30.0 * (rand() % 100) / 3000.0;
        soma += temperatura[i];
        if (i == 0)
        {
            max = temperatura[i];
            min = temperatura[i];
        }
        else
        {
            if (temperatura[i] > max)
            {
                max = temperatura[i];
            }
            if (temperatura[i] < min)
            {
                min = temperatura[i];
            }
        }
    }
    media = soma / 250;
    cout << "\n**********TEMPERATURAS*********\n"
         << endl;
    cout << "Temperatura maxima: " << max << endl;
    cout << "Temperatura minima: " << min << endl;
    cout << "Temperatura media: " << media << endl;

    for (int i = 0; i < 250; i++)
    {
        if (temperatura[i] > media)
        {
            temperatura[i] += 1;
        }
        else
        {
            temperatura[i] -= 2;
        }
    }
    cout << "\n*****TEMPERATURAS ATUALIZADAS****\n"
         << endl;
    for (int i = 0; i < 250; i++)
    {
        cout << "Temperatura = " << temperatura[i] << endl;
    }
    return 0;
}