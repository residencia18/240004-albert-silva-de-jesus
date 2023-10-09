#ifndef CONTROLERLOCADORA_H
#define CONTROLERLOCADORA_H
#include <iostream>
#include "Funcionario.h"
#include "Cliente.h"
#include "Veiculo.h"
#include "Aluguel.h"
#include "Persistencia.h"
#include <string>
#include <ctime>
#include <vector>

using namespace std;

#pragma once

class ControlerLocadora
{
public:

    ControlerLocadora() {}

    ~ControlerLocadora() {}

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
            cout << "\n\t[1] - CLIENTE:";
            cout << "\n\t[2] - FUNCIONARIO:";
            cout << "\n\t[3] - VEICULO:";
            cout << "\n\t[4] - ALUGAR VEÍCULO:";
            cout << "\n\t[0] - SAIR";
            cout << "\n\tENTRADA ->  ";
            cin >> opcao;
            cin.get();

            if (opcao > 3 || opcao < 0)
            {
                limpaTela();
                cout << "\n\n\tOps, escolha invalida!";
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
                cout << "\n\n\tOps, escolha invalida!...";
                pause();
            }

        } while (opcao > 5 || opcao < 0);

        return opcao;
    }

    void LocadoraDeVeiculos(Cliente &cliente, Funcionario &funcionario, Veiculo &veiculo, Aluguel &aluguel)
    {
        int escolha = 0;
        int op = 0;
        
        Persistencia::recuperarCliente(cliente);
        Persistencia::recuperarFuncionario(funcionario);
        Persistencia::recuperarVeiculo(veiculo);
        Persistencia::recuperarAluguel(aluguel);

        do
        {
            switch (op = menuPrincipal())
            {

            case 1:

                do
                {
                    escolha = menuEscolha();
                    if (escolha == 1)
                    {
                        Persistencia::salvarCliente(cliente);
                    }
                    if (escolha == 2)
                    {
                        Persistencia::excluirCliente(cliente.excluir(cliente));
                    }
                    if (escolha == 3)
                    {
                        Persistencia::editarCliente(cliente);
                    }
                    if (escolha == 4)
                    {
                        cliente.listar();
                    }
                    if (escolha == 5)
                    {
                        cliente.localizar();
                    }
                    if (escolha > 5 && escolha < 0)
                    {
                        limpaTela();
                        cout << "\n\tOps, opção invalida!";
                        pause();
                    }

                } while (escolha != 0);

                break;

            case 2:

                do
                {
                    escolha = menuEscolha();
                    if (escolha == 1)
                    {
                        Persistencia::salvarFuncionario(funcionario);
                    }

                    if (escolha == 2)
                    {
                        Persistencia::excluirFuncionario(funcionario.excluir(funcionario));
                    }

                    if (escolha == 3)
                    {
                        Persistencia::editarFuncionario(funcionario);
                    }

                    if (escolha == 4)
                    {
                        funcionario.listar();
                    }

                    if (escolha == 5)
                    {
                        funcionario.localizar();
                    }

                    if (escolha > 5 && escolha < 0)
                    {
                        limpaTela();
                        cout << "\n\tOps, opção invalida!";
                        pause();
                    }
                } while (escolha != 0);

                break;

            case 3:

                do
                {
                    escolha = menuEscolha();
                    if (escolha == 1)
                    {
                        Persistencia::salvarVeiculo(veiculo);
                    }

                    if (escolha == 2)
                    {
                        Persistencia::excluirVeiculo(veiculo.excluir(veiculo));
                    }

                    if (escolha == 3)
                    {
                        Persistencia::editarVeiculo(veiculo);
                    }

                    if (escolha == 4)
                    {
                        veiculo.listar();
                    }

                    if (escolha == 5)
                    {
                        veiculo.localizar();
                    }

                    if (escolha > 5 && escolha < 0)
                    {
                        limpaTela();
                        cout << "\n\tOps, opção invalida!";
                        pause();
                    }

                } while (escolha != 0);

                break;

            case 0:

                cout << "\n\tPrograma encerrado com sucesso!..." << endl;
                op = 0;
                exit(0);

                break;

            default:
                cout << "\tOps, Opção invalida!";
            }
        } while (op != 0);
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