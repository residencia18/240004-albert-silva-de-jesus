/*Exercício 4: Manipulando arrays multidimensionais
● A seguinte expressão em C++ gera um valor inteiro aleatório entre 0 e 255:rand()%256. Utilizando esta expressão desenvolva uma aplicação que:
a. Simule a captura de uma imagem de 640 por 480 pixels, onde a intensidade de iluminação é representada como um valor inteiro entre 0 (preto ou sem iluminação) e 255 (branco ou totalmente iluminado). Pesquise mais sobre imagens em tons de cinza;*/

#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int main(void)
{
    srand(time(NULL));
    int imagem[640][480];

    for (int i = 0; i < 640; i++)
    {
        for (int j = 0; j < 480; j++)
        {
            imagem[i][j] = rand() % 256;
        }
    }

    for (int i = 0; i < 640; i++)
    {
        for (int j = 0; j < 480; j++)
        {
            cout << imagem[i][j] << " ";
        }
        cout << endl;
    }
    
}