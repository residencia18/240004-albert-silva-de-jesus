#include <iostream>
#include <cstring>
#include <vector>

using namespace std;

int main()
{

    vector<string> alunos;
    string nome;
    int x = 0;

    for (int i = 0; i < 5; i++)
    {
        cout << "Digite o " << i + 1 << "º nome: " << endl;
        getline(cin, nome);
        alunos.push_back(nome);
    }

    for (int i = 0; i < 5; i++)
    {
        cout << " nome = " << alunos.at(i) << endl;
    }

    cout << "Digite o número do aluno: ";
    cin >> x;

    for (int i = 0; i < 5; i++)
    {
        if (x == i)
        {
            cout << alunos.at(i);
        }
    }
    cout << endl;

    // for(string nome : alunos) cout << nome << endl;

    // for(auto it = alunos.begin(); it != alunos.end(); it++){
    //     cout << *it << " ";
    // }
}