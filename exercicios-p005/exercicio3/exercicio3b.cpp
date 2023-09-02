/*Escreva um programa que:
a. Peça ao usuário para fornecer um número inteiro, obtenha-o da entrada padrão, usando cin, e armazene numa variável de tipo int;

b. Determine se o valor fornecido pode ser representado, sem perda de informação, como um short int. Imprima na tela o valor
fornecido, seguido das palavras “e maior que um short int” ou “este valor pertence ao intervalo dos short int”. Use apenas o operador
condicional (?).*/

#include <iostream>
using namespace std;

int main()
{
    int num;
    cout << "Digite um numero inteiro: ";
    cin >> num;
    cout << "O numero digitado " << num << " : " << (num > 32767 ? "maior que um short int" : "este valor pertence ao intervalo dos short int") << endl;
}
