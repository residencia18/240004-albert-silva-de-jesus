/*b. Crie uma variável uli, de tipo unsigned long int, atribua a ela o maior valor que pode ser armazenado neste tipo de dado
(identifique qual o menor e o maior valor que pode ser representado);*/

#include <iostream>
#include <limits>

using namespace std;

int main(){

    unsigned long int uli = std::numeric_limits<unsigned long int>::max();
    unsigned long int menorUnsignedLong = std::numeric_limits<unsigned long int>::min();

    std::cout << "Maior valor de unsigned long int: " << uli << std::endl;
    std::cout << "Menor valor de unsigned long int: " << menorUnsignedLong << std::endl;


    return 0;
}