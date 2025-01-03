/*Exercício 5: Variáveis de tipo Bool
● As variáveis de tipo bool podem assumir valores true ou false. Elas serão amplamente utilizadas nos próximos tópicos. Entretanto, outros tipos
de dados podem ser utilizados no lugar de valores bool e seus valores são convertidos em true ou false.

a. Faça uma aplicação que mostre como os diversos tipos que foram estudados até aqui são convertidos em true ou false.*/

#include <iostream>
#include <stdbool.h>
#include <string.h>

using namespace std;

int main(){

    bool isNumber = true;  
    bool isPositive = true;
    bool condition;  

    condition = (isNumber && isPositive);
    cout << "condition = " << condition;
    
    isNumber = false;
    condition = (isNumber && isPositive);
    cout << "\ncondition = " << condition;

    cout << "\ntrue = " << (4 % 2 == 0) ? (true) : (false);
    (4 % 2 == 1) ?  cout << "\n(4 % 2 == 1) verdadeiro:" : cout << "\n(4 % 2 == 1) falso:" << endl;

    string nome = "João";
    string nome2 = "João";
    cout <<"nome == nome2 = "<< (nome == nome2) ? "true" : "false";
}