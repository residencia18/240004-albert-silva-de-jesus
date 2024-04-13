/*Exercício 3: Operações com inteiros
 Escreva um programa, usando quando necessário o operador (?), que:

e. Atribua à variável c o módulo (valor absoluto) da diferença entre as variáveis a e b, imprima o resultado na tela; (valor absoluto: se c < 0
retorna -c, caso contrário retorna c)*/

#include <iostream>
#include <cmath>
using namespace std;

int main()
{

    int a, b, c;

    c = a - b;
    (c < 0) ? cout << "\nValor negativo: " << float(c) << "\n" : cout << "\nValor absoluto: " << float(c) << "\n";
}