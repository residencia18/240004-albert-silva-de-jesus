/*Exercício 12:
Escreva uma função que receba duas strings A e B por parâmetro e retorne uma terceira string C com os caracteres que aparecem tanto em A quanto em B. O tamanho das string A e B pode ser diferente.*/

#include <iostream>
#include <string>
using namespace std;

string caracteresComuns(string palavra1, string palavra2);

int main()
{
    string palavra1, palavra2;

    cout << "\nDigite uma palavra: ";
    getline(cin, palavra1);

    cout << "\nDigite outra palavra: ";
    getline(cin, palavra2);

    cout << "\nCaracteres comuns: " << caracteresComuns(palavra1, palavra2) << endl;
}

string caracteresComuns(string palavra1, string palavra2)
{
    string caracteresComuns = "";
    for (int i = 0; i < palavra1.length(); i++)
    {
        for (int j = 0; j < palavra2.length(); j++)
        {
            if (palavra1[i] == palavra2[j])
            {
                caracteresComuns += palavra1[i];
            }
        }
    }
    return caracteresComuns;
}