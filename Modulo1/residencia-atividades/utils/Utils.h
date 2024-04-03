#ifndef UTILS_H
#define UTILS_H
#include <iostream>
#include "Estoque.h"
#include <string>
#include <ctime>
#include <vector>

using namespace std;

#pragma once

class Utils
{
public:
    Estoque estoque;

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

    int menuPrincipal()
    {
        int opcao = 0;

        do
        {
            limpaTela();
            mostraDataAtual();
            cout << "\t======MENU PRINCIPAL======";
            cout << "\n\t[1] - PRODUTO:";
            cout << "\n\t[2] - ESTOQUE:";
            cout << "\n\t[3] - COMPRAR PRODUTO:";
            cout << "\n\t[0] - SAIR";
            cout << "\n\tENTRADA ->  ";
            cin >> opcao;
            cin.get();

            if (opcao > 3 || opcao < 0)
            {
                limpaTela();
                cout << "Ops, escolha invalida!...\n";
                pause();
            }

        } while (opcao > 3 || opcao < 0);

        return opcao;
    }

    int menuEscolha()
    {
        limpaTela();
        int opcao = 0;

        do
        {
            mostraDataAtual();
            cout << "\t===========MENU===========";
            cout << "\n\t[1] - INCLUIR:";
            cout << "\n\t[2] - EXCLUIR:";
            cout << "\n\t[3] - ALTERAR:";
            cout << "\n\t[4] - LISTAR:";
            cout << "\n\t[5] - LOCALIZAR:";
            cout << "\n\t[0] - SAIR";
            cout << "\n\tENTRADA ->  ";
            cin >> opcao;
            cin.get();

            if (opcao > 5 || opcao < 0)
            {
                limpaTela();
                cout << "Ops, escolha invalida!...\n";
                pause();
            }

        } while (opcao > 5 || opcao < 0);

        return opcao;
    }

    void gestaoDeVendas(Utils utils, vector<Estoque> &listEstoque)
    {
        int escolha = 0;
        int cliente = 0;

        do
        {
            switch (cliente = utils.menuPrincipal())
            {

            case 1:

                do
                {
                    escolha = utils.menuEscolha();
                    if (escolha == 1)
                    {
                    }
                    if (escolha == 2)
                    {
                        if (listEstoque.empty())
                        {
                            cout << "\n\tNão há clientes cadastrados!...\n";
                            utils.pause();
                        }
                        else
                        {
                        }
                    }
                    if (escolha == 3)
                    {
                        if (listEstoque.empty())
                        {
                            cout << "\n\tNão há clientes cadastrados!...\n";
                            utils.pause();
                        }
                        else
                        {
                        }
                    }
                    if (escolha == 4)
                    {
                        if (listEstoque.empty())
                        {
                            cout << "\n\tNão há clientes cadastrados!...\n";
                            utils.pause();
                        }
                        else
                        {
                        }
                    }
                    if (escolha == 5)
                    {
                        if (listEstoque.empty())
                        {
                            cout << "\n\tNão há clientes cadastrados!...\n";
                            utils.pause();
                        }
                        else
                        {
                        }
                    }
                    if (escolha > 5 && escolha < 0)
                    {
                        utils.limpaTela();
                        cout << "\n\tOps, opção invalida!";
                        utils.pause();
                    }

                } while (escolha != 0);

                break;

            case 2:

                do
                {
                    escolha = utils.menuEscolha();
                    if (escolha == 1)
                    {
                    }

                } while (escolha != 0);

                break;

            case 3:

                break;

            case 0:

                cout << "\n\tPrograma encerrado com sucesso!..." << endl;
                cliente = 0;
                exit(0);

            default:
                cout << "\tOps, Opção invalida!";
            }
        } while (cliente != 0);
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