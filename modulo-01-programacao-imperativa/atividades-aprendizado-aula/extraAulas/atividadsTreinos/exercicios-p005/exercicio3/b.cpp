/*Exercício 3: Operações com inteiros
 Escreva um programa, usando quando necessário o operador (?), que:

c. Atribua à variável c a somas das variáveis a e b, imprima o resultado na tela em formato hexadecimal;*/

#include <iostream>
using namespace std;

int main()
{

        int a, b, c;

        cout << "Digite o 1º número: ";
        cin >> a;

        cout << "Digite o 2º número: ";
        cin >> b;

        c = a + b;

        cout << "O resultado da soma é: " << hex << c << endl;

        return 0;
}