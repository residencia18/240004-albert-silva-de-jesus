#include <iostream>
#include <cstring>

using namespace std;

int main()
{

    string nome;
    string sobrenome;

    cout << "Digite um nome: ";
    getline(cin, nome);

    cout << "Digite o sobrenome: ";
    getline(cin, sobrenome);

    int ultimoElemento = nome.length() - 1;

    if (nome.at(ultimoElemento) == ' ')
    {
        nome.append(sobrenome);
    }
    else
    {
        nome.append(" " + sobrenome);
    }

    cout << nome << endl;
}