#include <iostream>
#include "conta.h"

using namespace std;

int main()
{
    conta c1;
    c1.setSaldo(1000);
    cout << "Saldo: " << c1.getSaldo() << endl;
    c1.depositar(100);
    cout << "Saldo: " << c1.getSaldo() << endl;
    return 0;
}