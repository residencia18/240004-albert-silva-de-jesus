/*d. Atribua a li o maior valor que pode ser armazenado num long int (identifique qual o menor e o maior valor que pode ser representado);*/

#include <iostream>
#include <limits>

using namespace std;

int main(){

    long int li = std::numeric_limits<long int>::max();
    long int menorLongInt = std::numeric_limits<long int>::min();

    std::cout <<" Maior valor de long int: " << li << std::endl;
    std::cout <<" Menor valor de long int: " << menorLongInt << std::endl;

    return 0;
}