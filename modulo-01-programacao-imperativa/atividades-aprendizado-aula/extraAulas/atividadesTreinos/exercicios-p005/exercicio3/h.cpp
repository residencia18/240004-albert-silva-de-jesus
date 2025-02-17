/*Exercício 3: Operações com inteiros
 Escreva um programa, usando quando necessário o operador (?), que:

h. Se a divisão anterior for possível, determinar se a é divisível de forma exata por b, mostrar o resultado na tela;*/

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

        ((b != 0) && (a % b == 0)) ? cout << "\nDivisão de forma exata, resto = " << (a % b) << "\n" : cout << "\nDivisão não é possível, resto = " << (a % b) << "\n";
}