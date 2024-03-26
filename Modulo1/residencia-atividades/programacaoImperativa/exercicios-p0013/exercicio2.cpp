/*Exercício 2:
Crie um tipo estruturado (struct) empregado para armazenar dados (nome, sobrenome, ano de nascimento, RG, ano de admissão, salário) de empregados de
uma empresa. Defina um vetor de empregados para armazenar até 50 empregados. Faça uma função chamada “Reajusta_dez_porcento( )” que receba por parâmetro o vetor de empregados e a quantidade de elementos no vetor e atualize o salário de cada empregado em 10%. Crie uma função main para testar a função.*/

#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

struct empregado
{
    string nome;
    string sobrenome;
    int anoNascimento;
    int RG;
    int anoAdmissao;
    float salario;
};

void Reajusta_dez_porcento(empregado empregados[], int n)
{
    for (int i = 0; i < n; i++)
    {
        empregados[i].salario = empregados[i].salario * 1.1;
    }
}

int main()
{
    empregado empregados[50];
    int n;

    cout << "Digite a quantidade de empregados: ";
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cout << "Digite o nome do empregado " << i + 1 << ": ";
        cin >> empregados[i].nome;

        cout << "Digite o sobrenome do empregado " << i + 1 << ": ";
        cin >> empregados[i].sobrenome;

        cout << "Digite o ano de nascimento do empregado " << i + 1 << ": ";
        cin >> empregados[i].anoNascimento;

        cout << "Digite o RG do empregado " << i + 1 << ": ";
        cin >> empregados[i].RG;

        cout << "Digite o ano de admissao do empregado " << i + 1 << ": ";
        cin >> empregados[i].anoAdmissao;

        cout << "Digite o salario do empregado " << i + 1 << ": ";
        cin >> empregados[i].salario;
    }
    Reajusta_dez_porcento(empregados, n);

    cout << "Empregados reajustados: " << endl;

    for (int i = 0; i < n; i++)
    {
        cout << "Nome: " << empregados[i].nome << endl;
        cout << "Sobrenome: " << empregados[i].sobrenome << endl;
        cout << "Ano de nascimento: " << empregados[i].anoNascimento << endl;
        cout << "RG: " << empregados[i].RG << endl;
        cout << "Ano de admissao: " << empregados[i].anoAdmissao << endl;
        cout << "Salario: " << fixed << setprecision(2) << empregados[i].salario << endl;
    }
}
