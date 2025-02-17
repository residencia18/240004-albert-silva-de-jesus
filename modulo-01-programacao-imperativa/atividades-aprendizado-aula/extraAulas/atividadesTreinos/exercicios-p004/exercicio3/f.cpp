/*f. Atribua a ui o maior valor que pode ser armazenado num unsigned int (identifique qual o menor e o maior valor que pode ser representado);*/

#include <iostream>
#include <limits>

using namespace std;

/*Atribua a ui o maior valor que pode ser armazenado num
unsigned int (identifique qual o menor e o maior valor que pode
ser representado);*/

int main(){

    //maior valor que pode ser armazenado num unsigned int = 4294967295
    unsigned int ui = numeric_limits<unsigned int>::max();

    //menor valor que pode ser armazenado num unsigned int = 0
    unsigned int menorUnsignerInt = numeric_limits<unsigned int>::min();

    cout << "ui: " << ui << endl;
    cout << "menorUnsignerInt: " << menorUnsignerInt << endl;
    
}