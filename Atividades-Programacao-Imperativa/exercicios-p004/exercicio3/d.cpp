/*d. Atribua a li o maior valor que pode ser armazenado num long int (identifique qual o menor e o maior valor que pode ser representado);*/

#include <iostream>
#include <limits>

using namespace std;

int main(){

    long int li = numeric_limits<long int>::max();
    long int menorLongInt = numeric_limits<long int>::min();

    cout <<" Maior valor de long int: " << li << endl;
    cout <<" Menor valor de long int: " << menorLongInt << endl;

}