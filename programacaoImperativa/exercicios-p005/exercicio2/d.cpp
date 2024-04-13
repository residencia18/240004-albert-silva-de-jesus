/*Exercício 2: Operações com char1s
● Escreva um programa que:
d. Atividade avançada: Verifique se o C++ fornece algum tipo de recurso na sua biblioteca padrão para obter este tipo de resposta de forma direta;*/

#include <iostream>
#include <cctype>
using namespace std;

int main(){

    char char1;

    cout << "\nDigite um caractere: ";
    cin >> char1;

    /* Funções da biblioteca da <cctype> Essas funções são mais eficientes e seguras para verificar o tipo de caractere, 
    pois levam em consideração a localização específica da máquina e a configuração local. Isso pode ser especialmente importante ao lidar 
    com caracteres de    outros idiomas além do inglês.*/
    cout << "Utilizando a biblioteca <cctype>\n";
    cout << "É" << 
        ((isupper(char1)) ?  " letra maiúscula\n" : 
        (islower(char1)) ? " letra minuscula\n" : 
        (isdigit(char1)) ? " um Digito\n" : " Outro tipo de caractere\n");
}