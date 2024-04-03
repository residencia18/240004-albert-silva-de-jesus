/*Exercício 4: Manipulando arrays multidimensionais
● A seguinte expressão em C++ gera um valor inteiro aleatório entre 0 e 255:rand()%256. Utilizando esta expressão desenvolva uma aplicação que:
a. Simule a captura de uma imagem de 640 por 480 pixels, onde a intensidade de iluminação é representada como um valor inteiro entre 0 (preto ou sem iluminação) e 255 (branco ou totalmente iluminado). Pesquise mais sobre imagens em tons de cinza;
b. Um histograma permite analisar a distribuição de frequências de cada intensidade em uma imagem. Pesquise mais sobre histogramas e implemente o código para construir o histograma da imagem que foi gerada;*/

#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int main(void)
{
    srand(time(NULL));
    int imagem[640][480];
    int histograma[256];

    for (int i = 0; i < 256; i++)
    {
        histograma[i] = 0;
    }
    for (int i = 0; i < 640; i++)
    {
        for (int j = 0; j < 480; j++)
        {
            imagem[i][j] = rand() % 256;
            histograma[imagem[i][j]]++;
        }
    }
    for (int i = 0; i < 256; i++)
    {
        cout << "Intensidade " << i << ": " << histograma[i] << endl;
    }
}