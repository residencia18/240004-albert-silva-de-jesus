/*Exercício 3: Operações com inteiros
 Escreva um programa, usando quando necessário o operador (?), que:

g. Atribua à variável c o quociente entre variáveis a e b, imprima o resultado na tela; (se b for igual a zero a divisão não é possível e um
aviso deve ser apresentado ao usuário);*/

#include <iostream>
#include <cmath>
using namespace std;

int main()
{

    int a, b, c;

    cout << "Digite o 1º número: ";
    cin >> a;

    cout << "Digite o 2º número: ";
    cin >> b;

    c = (float)a / b;
    cout << "\nQuociente entre a e b: " << c << "\n";

    (b == 0) ? cout << "\nDivisão não é possível, pois b é igual a zero\n" : cout << "\nDivisão é possível, b = " << b << "\n";
}