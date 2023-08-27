/*Exercício 3: Manipulação de variáveis de tipo inteiro, explorando os limites.
● Durante a aula foi apresentado o tipo de dado int e suas variações, que permitem representar um subconjunto dos números inteiros. Sobre estes
tipos de dados crie uma aplicação que: 

a. Sobre o tipo int identifique qual o menor e o maior valor que pode ser representado por uma variável deste tipo. Mostre esta informação na tela.*/

#include <iostream> 
#include <limits>
using namespace std;

int main()
{

    // cout << "\nMenor valor: short int ocupa " << sizeof(short int) << " bytes na memória." << endl;
    // cout << "\nMaior valor: long long int ocupa " << sizeof(long long int) << " bytes na memória.\n";

    int intMaior = std::numeric_limits<int>::max();
    int intMenor = std::numeric_limits<int>::min();

    std::cout << "Maior valor de unsigned long int: " << intMaior << std::endl;
    std::cout << "Menor valor de unsigned long int: " << intMenor << std::endl;

    return 0;
}