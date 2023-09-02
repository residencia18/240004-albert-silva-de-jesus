/* Exercício 2: Manipulação de variáveis de tipo caractere e explorando o uso de cout.
● Os caracteres numéricos aparecem na tabela ASCII, e em outras, numa sequência que começa pelo caractere ‘0’ até o caractere ‘9’. 
As variáveis de tipo caractere podem ser tratadas também como valores numéricos. Com base nestas afirmações desenvolva um programa em C++ que:
a. Imprima na tela, utilizando cout, cada um dos caracteres numéricos e seu correspondente código numérico. Como modificar o comportamento do cout para imprimir um objeto de tipo char como caractere e como número?
i. Exemplo: 
           ‘0’ - 48
           ‘1’ - 49
           …
           ‘9’ - 57 */
          
#include <iostream>
using namespace std;

int main(){

    char num1;

    cout << " '" << (num1 = '0') << "' "  "- " << int(num1 = '0') << endl;
    cout << " '" << (num1 = '1') << "' "  "- " << int(num1 = '1') << endl;
    cout << " '" << (num1 = '2') << "' "  "- " << int(num1 = '2') << endl;
    cout << " '" << (num1 = '3') << "' "  "- " << int(num1 = '3') << endl;
    cout << " '" << (num1 = '4') << "' "  "- " << int(num1 = '4') << endl;
    cout << " '" << (num1 = '5') << "' "  "- " << int(num1 = '5') << endl;
    cout << " '" << (num1 = '6') << "' "  "- " << int(num1 = '6') << endl;
    cout << " '" << (num1 = '7') << "' "  "- " << int(num1 = '7') << endl;
    cout << " '" << (num1 = '8') << "' "  "- " << int(num1 = '8') << endl;
    cout << " '" << (num1 = '9') << "' "  "- " << int(num1 = '9') << endl;

}