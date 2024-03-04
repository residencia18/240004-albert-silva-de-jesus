/*Exercício 3: Manipulação de strings tipo C
● Implemente uma aplicação em C que:
a. Leia do teclado uma string no formato dd/mm/aaaa, ao alguma variação desse formato (Ex. 5/12/2022, 05/02/23, 07/5/2024), e imprima na tela por separado dia, mês e ano.
b. Modifique o exemplo anterior de forma a verificar se a data fornecida é uma data válida (Ex. 31/02/1990 e 24/15/2002 não são datas válidas);
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

    if (mes == 1)
    {
        cout << "\nData valida: " << dia << " de janeiro de " << ano << endl;
    }
    else if (mes == 2)
    {
        cout << "\nData valida: " << dia << " de fevereiro de " << ano << endl;
    }
    else if (mes == 3)
    {
        cout << "\nData valida: " << dia << " de março de " << ano << endl;
    }
    else if (mes == 4)
    {
        cout << "\nData valida: " << dia << " de abril de " << ano << endl;
    }
    else if (mes == 5)
    {
        cout << "\nData valida: " << dia << " de maio de " << ano << endl;
    }
    else if (mes == 6)
    {
        cout << "\nData valida: " << dia << " de junho de " << ano << endl;
    }
    else if (mes == 7)
    {
        cout << "\nData valida: " << dia << " de julho de " << ano << endl;
    }
    else if (mes == 8)
    {
        cout << "\nData valida: " << dia << " de agosto de " << ano << endl;
    }
    else if (mes == 9)
    {
        cout << "\nData valida: " << dia << " de setembro de " << ano << endl;
    }
    else if (mes == 10)
    {
        cout << "\nData valida: " << dia << " de outubro de " << ano << endl;
    }
    else if (mes == 11)
    {
        cout << "\nData valida: " << dia << " de novembro de " << ano << endl;
    }
    else if (mes == 12)
    {
        cout << "\nData valida: " << dia << " de dezembro de " << ano << endl;
    }
}