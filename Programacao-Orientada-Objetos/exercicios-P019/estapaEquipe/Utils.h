#ifndef UTILS_H
#define UTILS_H
#include <iostream>
#include "Conjunto.h"
#include <ctime>

using namespace std;

#pragma once

class Utils
{
public:
    Utils() {}

    ~Utils() {}

    void limpaBuffer()
    {
        cin.get();
    }

    void limpaTela()
    {
#ifdef _WIN32
        system("cls");
#else
        system("clear");
#endif
    }

    void pause()
    {
        cout << "\n\tDigite enter para continuar!...\n";
        cin.get();
        limpaTela();
    }

    int menu()
    {

        limpaTela();
        int opcao = 0;

        do
        {
            mostraDataAtual();
            cout << "\t=========MENU=========";
            cout << "\n\t[1] - A = B:";
            cout << "\n\t[2] - A = B + C:";
            cout << "\n\t[3] - A = B * C:";
            cout << "\n\t[4] - A = B - C:";
            cout << "\n\t[5] - A = B <> C:";
            cout << "\n\t[6] - A == B:";
            cout << "\n\t[7] - LISTAR B E C:";
            cout << "\n\t[0] - SAIR";
            cout << "\n\tENTRADA ->  ";
            cin >> opcao;
            limpaBuffer();

            if (opcao > 7 || opcao < 0)
            {
                limpaTela();
                cout << "Ops, escolha invalida!...\n";
                pause();
            }

        } while (opcao > 7 || opcao < 0);

        return opcao;
    }

    tm *getTempo()
    {
        time_t t;
        time(&t);
        struct tm *data;
        data = localtime(&t);
        return data;
    }

    void mostraDataAtual()
    {
        // int diaSemana = getTempo()->tm_wday;

        printf("\n\tDATA ATUAL: %02d/%02d/%4d, %s\n ", getTempo()->tm_mday, getTempo()->tm_mon + 1, getTempo()->tm_year + 1900, diaDaSemana().c_str());
        printf("\tHORA ATUAL: %02d:%02d:%02d\n", getTempo()->tm_hour, getTempo()->tm_min, getTempo()->tm_sec);

        if (bissexto())
        {
            printf("\tANO BISSEXTO, FALTA %i PARA TERMINAR O ANO!...\n", 366 - getTempo()->tm_yday);
        }
        else
        {
            printf("\tANO NÃO BISSEXTO, FALTA %i PARA TERMINAR O ANO!...\n", 365 - getTempo()->tm_yday);
        }
        if (getTempo()->tm_hour >= 0 && getTempo()->tm_hour < 12)
        {
            printf("\tBOM DIA!...\n");
        }
        else if (getTempo()->tm_hour >= 12 && getTempo()->tm_hour < 18)
        {
            printf("\tBOA TARDE!...\n");
        }
        else
        {
            printf("\tBOA NOITE!...\n");
        }

        printf("\n");
    }

    string diaDaSemana()
    {

        switch (getTempo()->tm_wday)
        {
        case 0:
            return "DOMINGO";
        case 1:
            return "SEGUNDA-FEIRA";
        case 2:
            return "TERÇA-FEIRA";
        case 3:
            return "QUARTA-FEIRA";
        case 4:
            return "QUINTA-FEIRA";
        case 5:
            return "SEXTA-FEIRA";
        case 6:
            return "SABADO";
        }
        return "ERRO";
    }

    bool bissexto()
    {
        // getTempo()->tm_year + 1900 siguinifica o ano atual
        if (getTempo()->tm_year + 1900 % 4 == 0 && getTempo()->tm_year + 1900 % 100 != 0)
        {
            return true;
        }
        else
        {
            if (getTempo()->tm_year + 1900 % 400 == 0)
            {
                return true;
            }
        }
        return false;
    }

private:
};

#endif