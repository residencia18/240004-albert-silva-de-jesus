/*Exercício 1: Instale e configure o Git
Exercício 3: 
Escreva um programa em C++ que leia um número inteiro e imprima todos os divisores desse número.*/

#include <iostream>
using namespace std;

int main(){

    int num = 0;

    cout << "Digite um número: ";
    cin >> num;

    for(int i = 1; i <= num; i++){

        if(num % i == 0){
            cout << i << ",";
        }
    }
    cout << endl;
}