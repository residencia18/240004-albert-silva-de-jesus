/*Exercício 1: Instale e configure o Git
Exercício 5: 
Escreva um programa em C++ que simule um jogo de adivinhação. O programa deve gerar um número aleatório entre 1 e 100, e o usuário deve tentar adivinhar esse número. O jogo deve informar se o palpite está alto, baixo ou correto, e continuar até que o usuário acerte o número.*/

#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

int main()
{
    srand(time(NULL));
    int num = rand() % 100 + 1;
    int palpite;
    bool acertou = false;
    while (!acertou)
    {
        cout << "Digite um palpite: ";
        cin >> palpite;
        if (palpite == num)
        {
            cout << "Parabéns, você acertou!";
            acertou = true;
        }
        else if (palpite > num)
        {
            cout << "Seu palpite está alto, tente novamente." << endl;
        }
        else
        {
            cout << "Seu palpite está baixo, tente novamente." << endl;
        }
    }
}