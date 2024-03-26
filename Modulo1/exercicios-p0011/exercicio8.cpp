/*Exercício 8: Instalando Extensões
Faça uma função chamada conta_primos que receba um vetor de números inteiros e retorne a quantidade de números do vetor que são primos.
Lembrando que um número primo é aquele divisível apenas por 1 e por ele mesmo.

Protótipo da função:
int conta_primos (int *vet, int qtde);*/

#include <iostream>
#include <ctime>

using namespace std;

void preencheVetor(int vet[], int qtde);

int conta_primos (int *vet, int qtde);

int main(){

    srand(time(nullptr));

    int tam = 20;
    int vetor[tam];

    preencheVetor(vetor, tam);

    conta_primos (vetor, tam);

    cout << endl;
    for(int i = 0; i < tam; i++){
        cout << vetor[i] << ", ";
    }
    cout << endl;
   
   int quantidadeDePrimos = conta_primos (vetor, tam);
   cout << "\n" << "Quantidade de números primos no vetor = " << quantidadeDePrimos;
}

void preencheVetor(int vet[], int qtde){

    for(int i = 0; i < qtde; i++){
        vet[i] = rand() % 100;
    }

    cout << endl;
    for(int i = 0; i < qtde; i++){
        cout << vet[i] << ", ";
    }
    cout << endl;
}

int conta_primos (int *vet, int qtde){

    bool ePrimo;
    int divisivel = 0, quantNumerosPrimos = 0;

    for(int i = 0; i < qtde; i++){

        ePrimo = true;
        while(ePrimo){
            
            divisivel = 0;
            for(int y = 1; y <= vet[i]; y++){

                if(vet[i] % y == 0){
                    divisivel++;
                }
            }

            if(divisivel == 2){
                ePrimo = false;
                quantNumerosPrimos++;
            }else{
                vet[i] = 0;
                ePrimo = false;
            }
        }
    }
    return quantNumerosPrimos;
}