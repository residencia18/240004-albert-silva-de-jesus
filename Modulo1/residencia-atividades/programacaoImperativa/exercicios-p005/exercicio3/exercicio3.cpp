/*Exercício 3: Operações com inteiros
 Escreva um programa, usando quando necessário o operador (?), que:

a. Declare três variáveis de tipo int, vamos chamar de a, b e c mas
você pode escolher outro identificador se achar mais apropriado;

b. Peça ao usuário para digitar dois números inteiros, obtenha-os da
entrada padrão, usando cin, e atribua os valores digitados às
variáveis a e b respectivamente;

c. Atribua à variável c a somas das variáveis a e b, imprima o resultado
na tela em formato hexadecimal;

d. Atribua à variável c o produto das variáveis a e b, imprima o
resultado na tela em formato octal;

e. Atribua à variável c o módulo (valor absoluto) da diferença entre as
variáveis a e b, imprima o resultado na tela; (valor absoluto: se c < 0
retorna -c, caso contrário retorna c)

f. Atividade avançada: Verifique se o C++ fornece algum tipo de recurso
na sua biblioteca padrão para obter este tipo de resposta de forma
direta;

g. Atribua à variável c o quociente entre variáveis a e b, imprima o
resultado na tela; (se b for igual a zero a divisão não é possível e um
aviso deve ser apresentado ao usuário);

h. Se a divisão anterior for possível, determinar se a é divisível de forma
exata por b, mostrar o resultado na tela;*/

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

    c = a + b;
    char x = c;
    cout << dec << "\ndec - " << int(c) << oct << ", oct - 0" << int(x) << hex << ", hex - " << int(x) << " Caractere " << c << "\n";

    c = a - b;
    (c < 0) ? cout << "\nValor negativo: " << float(c) << "\n" : cout << "\nValor absoluto: " << float(c) << "\n";

    // Pode usar a função abs() da biblioteca padrão <cmath>. Função abs() é usada para calcular o valor absoluto da diferença entre a e b
    cout << "\nFunção ABS da Biblioteca <cmath>, resultado = " << abs(a - b) << "\n";

    c = (float)a / b;
    cout << "\nQuociente entre a e b: " << c << "\n";

    (b == 0) ? cout << "\nDivisão não é possível, pois b é igual a zero\n" : cout << "\nDivisão é possível, b = " << b << "\n";

    ((b != 0) && (a % b == 0)) ? cout << "\nDivisão de forma exata, resto = " << (a % b) << "\n" : cout << "\nDivisão não é possível, resto = " << (a % b) << "\n";
}