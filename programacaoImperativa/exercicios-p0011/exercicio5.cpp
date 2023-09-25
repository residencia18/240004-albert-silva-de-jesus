/*Exercício 5:
Faça uma função “insere_meio(int vet[ ], int tam)” que insere um elemento no meio de um vetor de números inteiros. Depois faça o programa principal para testar a sua função.

Por exemplo:
Sendo o vetor = {1,2,3,4,5,6} e qtde = 6, ao usar insere_meio(vetor, qtde, 100), será retornado o novo valor de qtde, que passou a ser 7, e o vetor, ao término da função, passará a ficar da seguinte forma: vetor= {1,2,3,100,4,5,6}.Protótipo da função: int insere_meio( int *vetor, int qtde, int elemento); */

#include <iostream>
using namespace std;

int insere_meio(int *vetor, int qtde, int elemento);

int main()
{
    int vetor[6] = {1, 2, 3, 4, 5, 6};
    int qtde = 6;
    int elemento = 100;

    insere_meio(vetor, qtde, elemento);
}

int insere_meio(int *vetor, int qtde, int elemento)
{
    int meio = qtde / 2;
    int aux = 0;

    for (int i = qtde; i > meio; i--)
    {
        vetor[i] = vetor[i - 1];
    }

    vetor[meio] = elemento;

    for (int i = 0; i < qtde + 1; i++)
    {
        cout << vetor[i] << " ";
    }
    cout << endl;

    return 0;
}