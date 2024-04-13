#include <iostream>

using namespace std;

int main()
{
    string nome;

    cout << "Digite seu nome: ";
    getline(cin, nome);

    cout << "\nBom dia, "
         << nome
         << "!" << endl;

    return 0;
}