/*Exercício 3: Manipulação de strings tipo C
● Implemente uma aplicação em C que:
c. Modifique a aplicação de forma que, se for uma data válida, imprima a data por extenso (Ex. para 5/12/2022 imprimir 5 de dezembro de 2022)*/

#include <iostream>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

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

    cout << "\nData valida!" << endl;
    cout << "\nData por extenso: " << dia << " de ";

    switch (mes)
    {
    case 1:
        cout << "janeiro";
        break;
    case 2:
        cout << "fevereiro";
        break;
    case 3:
        cout << "março";
        break;
    case 4:
        cout << "abril";
        break;
    case 5:
        cout << "maio";
        break;
    case 6:
        cout << "junho";
        break;
    case 7:
        cout << "julho";
        break;
    case 8:
        cout << "agosto";
        break;
    case 9:
        cout << "setembro";
        break;
    case 10:
        cout << "outubro";
        break;
    case 11:
        cout << "novembro";
        break;
    case 12:
        cout << "dezembro";
        break;
    }

    cout << " de " << ano << endl;
}