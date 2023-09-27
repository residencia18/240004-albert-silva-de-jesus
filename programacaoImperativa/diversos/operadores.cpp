#include <iostream>

using namespace std;

int main()
{

    float pi = 3 + 0.1415;
    int teste = pi;
    cout << teste << endl;

    teste = pi;
    pi = teste;

    char x = 'a';
    int y = x;
    cout << y << endl;

    int z = 97;
    char f = z;
    cout << f << endl;

    // int k = 99;
    char c = 97.14;
    cout << c << endl;

    int v = (3 < 4) ? true : false;
    cout << v << endl;

    int tipo = 5;
    tipo = float(tipo) / 2;
    cout << tipo << endl;
}