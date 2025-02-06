/*Exercício 2: Operações com char1s
● Escreva um programa que:
c. Verifique, utilizando o operador condicional (?) se trata de:
    i. uma letra maiúscula;
    ii. uma letra minúscula;
    iii. um dígito;
    iv. outro tipo de char1;*/

#include <iostream>
using namespace std;

int main(){

    char char1, char2, char3;

    cout << "\nDigite um caractere: ";
    cin >> char1;

    char1 = (char1 >= 'A' && char1 <= 'Z') ? 'M' : 
            (char1 >= 'a' && char1 <= 'z') ? 'm' : 
            (char1 >= '0' && char1 <= '9') ? 'd' : 'o';

    cout << "\nUtilizando o operador Ternario:\n";
    cout << "É " << 
        ((char1 == 'M') ? "uma letra maiúscula.\n" : 
        (char1 == 'm') ? "uma letra minúscula.\n" : 
        (char1 == 'd') ? "um dígito.\n" : "outro tipo de caractere.\n") << endl;
}