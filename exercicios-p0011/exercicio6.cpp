/*Exercício 6:
Faça uma função que receba dois vetores de números inteiros e os seus respectivos tamanhos por parâmetro e retorne um vetor com os valores dos dois
vetores intercalados. Depois faça o programa principal para testar a sua função. Protótipo da função: int* intercala(int *vet1, int tam1, int *vet2, int tam2);*/

#include <iostream>
#include <ctime>

using namespace std;

void preencheVetor(int vet1[], int tam1, int vet2[], int tam2);

int *intercala(int *vet1, int tam1, int *vet2, int tam2);

int main()
{
    srand(time(nullptr));

    int tam1 = 0, tam2 = 0;

    cout << "Digite o tamanho do primeiro vetor: ";
    cin >> tam1;

    cout << "Digite o tamanho do segundo vetor: ";
    cin >> tam2;

    int vet1[tam1], vet2[tam2];

    preencheVetor(vet1, tam1, vet2, tam2);

    int *vet3 = intercala(vet1, tam1, vet2, tam2);

    for (int i = 0; i < tam1 + tam2; i++)
    {
        cout << vet3[i] << " ";
    }
}

void preencheVetor(int vet1[], int tam1, int vet2[], int tam2)
{
    for (int i = 0; i < tam1; i++)
    {
        vet1[i] = rand() % 100;
    }

    for (int i = 0; i < tam2; i++)
    {
        vet2[i] = rand() % 100;
    }

    for (int i = 0; i < tam1; i++)
    {
        cout << vet1[i] << " ";
    }
    cout << endl;

    for (int i = 0; i < tam2; i++)
    {
        cout << vet2[i] << " ";
    }
    cout << endl;
}

int *intercala(int *vet1, int tam1, int *vet2, int tam2)
{
    int *intercalado = new int[tam1 + tam2];
    int pos1 = 0, pos2 = 0;

    for (int i = 0; i < (tam1 + tam2); i++)
    {
        if (pos1 < tam1 && pos2 < tam2)
        {
            if (i % 2 == 0)
            {
                intercalado[i] = vet1[pos1];
                pos1++;
            }
            else
            {
                intercalado[i] = vet2[pos2];
                pos2++;
            }
        }
        else if (pos1 < tam1)
        {
            intercalado[i] = vet1[pos1];
            pos1++;
        }
        else if (pos2 < tam2)
        {
            intercalado[i] = vet2[pos2];
            pos2++;
        }
    }

    return intercalado;
}