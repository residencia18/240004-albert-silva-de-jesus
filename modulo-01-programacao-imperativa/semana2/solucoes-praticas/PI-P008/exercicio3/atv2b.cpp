/*Exercício 3: Manipulação de strings tipo C
● Implemente uma aplicação em C que:
b. Modifique o exemplo anterior de forma a verificar se a data fornecida é uma data válida (Ex. 31/02/1990 e 24/15/2002 não são datas válidas);*/

#include <iostream>
#include <cstring>
#include <cstdlib>
#include <ctime>

using namespace std;

int main(void)
{
    char data[11];
    int dia, mes, ano;

    cout << "\nDigite uma data no formato dd/mm/aaaa: ";
    cin >> data;

    dia = atoi(strtok(data, "/"));
    mes = atoi(strtok(NULL, "/"));
    ano = atoi(strtok(NULL, "/"));

    if (dia > 31 || dia < 1 || mes > 12 || mes < 1 || ano < 1)
    {
        cout << "\nData invalida!" << endl;
        return 0;
    }

    if (mes == 2)
    {
        if (dia > 29)
        {
            cout << "\nData invalida!" << endl;
            return 0;
        }
        else if (dia == 29)
        {
            if (ano % 4 != 0)
            {
                cout << "\nData invalida!" << endl;
                return 0;
            }
            else if (ano % 100 == 0 && ano % 400 != 0)
            {
                cout << "\nData invalida!" << endl;
                return 0;
            }
        }
    }

    if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
    {
        if (dia > 30)
        {
            cout << "\nData invalida!" << endl;
            return 0;
        }
    }

    cout << "\nUtilizando variáveis inteiras, formato (Ex. 5/12/2022) " << endl;
    cout << "Dia: " << dia << endl;
    cout << "Mes: " << mes << endl;
    cout << "Ano: " << ano << endl;

    cout << "\nUtilizando acesso direto aos caracteres da string, formato (Ex. 05/02/23) " << endl;
    cout << "Dia: " << data[0] << data[1] << endl;
    cout << "Mes: " << data[3] << data[4] << endl;
    cout << "Ano: " << data[6] << data[7] << data[8] << data[9] << endl;

    cout << "\nUtilizando acesso direto aos caracteres da string, formato (Ex.07/5/2024) " << endl;
    cout << "Dia: " << data[0] << data[1] << endl;
    cout << "Mes: " << data[4] << endl;
    cout << "Ano: " << data[6] << data[7] << data[8] << data[9] << endl;
}
