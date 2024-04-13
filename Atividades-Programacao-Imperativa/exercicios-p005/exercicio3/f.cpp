/*Exercício 3: Operações com inteiros
 Escreva um programa, usando quando necessário o operador (?), que:

f. Atividade avançada: Verifique se o C++ fornece algum tipo de recurso na sua biblioteca padrão para obter este tipo de resposta de forma direta;*/

#include <iostream>
#include <cmath>
using namespace std;

int main()
{

    int a, b, c;

    c = a - b;

    // Pode usar a função abs() da biblioteca padrão <cmath>. Função abs() é usada para calcular o valor absoluto da diferença entre a e b
    cout << "\nFunção ABS da Biblioteca <cmath>, resultado = " << abs(a - b) << "\n";
}