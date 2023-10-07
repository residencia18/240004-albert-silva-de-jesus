#ifndef FUNCIONARIO_H
#define FUNCIONARIO_H
#include <iostream>
#include "Usuario.h"
#include "Aluguel.h"
#include <vector>
using namespace std;

#pragma once

class Funcionario : public Usuario
{
public:
    vector<Aluguel> listHistoricoAlugueis;

    vector<Funcionario> funcionarios;

    Funcionario() {}

    ~Funcionario() {}

    void setAluguel(Aluguel aluguel)
    {
        this->listHistoricoAlugueis.push_back(aluguel);
    }

    vector<Aluguel> getAluguel()
    {
        return this->listHistoricoAlugueis;
    }

    void setFuncionario(Funcionario funcionario)
    {
        this->funcionarios.push_back(funcionario);
    }

    vector<Funcionario> getFuncionario()
    {
        return this->funcionarios;
    }

    void cadastrar(Funcionario &funcionario)
    {
        limpaTela();
        cout << "\n\t==========CADASTRO DE FUNCIONARIO==========\n";
        cout << "\n\tInforme o nome do Funcionario: ";
        getline(cin, nome);

        cout << "\n\tInforme o cpf do Funcionario: ";
        getline(cin, cpf);

        cout << "\n\tInforme o Longradouro do Funcionario: ";
        getline(cin, endereco);

        cout << "\n\tInforme o telefone do Funcionario: ";
        getline(cin, telefone);

        setFuncionario(funcionario);
    }

    void listar()
    {

        limpaTela();
        cout << "\n\t==========LISTA DE FUNCIONARIOS==========\n";
        for (auto it = funcionarios.begin(); it != funcionarios.end(); it++)
        {

            cout << "\n\tNome: " << it->getNome();
            cout << "\n\tCPF: " << it->getCPF();
            cout << "\n\tEndereço: " << it->getEndereco();
            cout << "\n\tTelefone: " << it->getTelefone();
            cout << "\n\t====================================\n";
        }
        pause();
    }

    void editar()
    {
        string cpf;
        bool encontrou = true;

        do
        {
            limpaTela();
            cout << "\n\t==========EDITAR FUNCIONARIO==========\n";
            cout << "\n\tInforme o CPF do Funcionario: ";
            getline(cin, cpf);

            for (auto it = funcionarios.begin(); it != funcionarios.end(); it++)
            {
                if (cpf == it->getCPF())
                {
                    cout << "\n\tInforme o nome do Funcionario: ";
                    getline(cin, nome);

                    cout << "\n\tInforme o cpf do Funcionario: ";
                    getline(cin, cpf);

                    cout << "\n\tInforme o Longradouro do Funcionario: ";
                    getline(cin, endereco);

                    cout << "\n\tInforme o telefone do Funcionario: ";
                    getline(cin, telefone);

                    encontrou = true;
                    break;
                }
                else
                {
                    encontrou = false;
                }
            }
            if (!encontrou)
            {
                cout << "\n\tFuncionario não encontrado!...\n";
                pause();
            }
        } while (!encontrou);
    }

    string excluir(Funcionario &funcionario)
    {
        string cpf;
        bool encontrou = false;

        do
        {
            limpaTela();
            cout << "\n\t==========EXCLUIR FUNCIONARIO==========\n";
            cout << "\n\tInforme o CPF do Funcionario: ";
            getline(cin, cpf);

            for (auto it = funcionario.funcionarios.begin(); it != funcionario.funcionarios.end(); it++)
            {
                if (cpf == it->getCPF())
                {
                    cout << "\n\tFuncionario: " << it->getNome() << " excluido com sucesso!..." << endl;
                    pause();
                    funcionario.funcionarios.erase(it);
                    encontrou = true;
                    break;
                }
            }
            if (encontrou)
            {
                listar();
                return cpf;
            }
            else
            {
                cout << "\n\tFuncionario não encontrado!...\n";
                pause();
            }

        } while (encontrou);
        return cpf;
    }

    void localizar()
    {
        string cpf;
        bool encontrou = false;

        do
        {
            limpaTela();
            cout << "\n\t==========LOCALIZAR FUNCIONARIO==========\n";
            cout << "\n\tInforme o CPF do Funcionario: ";
            getline(cin, cpf);

            for (auto it = funcionarios.begin(); it != funcionarios.end(); it++)
            {
                if (cpf == it->getCPF())
                {
                    limpaTela();
                    cout << "\n\t==========FUNCIONARIO ENCONTRADO==========\n";
                    cout << "\n\tNome: " << it->getNome();
                    cout << "\n\tCPF: " << it->getCPF();
                    cout << "\n\tEndereço: " << it->getEndereco();
                    cout << "\n\tTelefone: " << it->getTelefone();
                    cout << "\n\t====================================\n";
                    pause();
                    encontrou = true;
                    break;
                }
            }
            if (!encontrou)
            {
                cout << "\n\tFuncionario não encontrado!...\n";
                pause();
            }

        } while (!encontrou);
    }

    string verificaFuncionario(string cpf)
    {
        bool existe = false;
        char opcao;
        Funcionario funcionario;

        do
        {
            limpaTela();
            cout << "\n\t==========VERIFICAR FUNCIONARIO==========\n";
            cout << "\n\tInforme o CPF do Funcionario: ";
            getline(cin, cpf);

            for (auto it = funcionarios.begin(); it != funcionarios.end(); it++)
            {
                if (cpf == it->getCPF())
                {
                    return cpf;
                }
            }
            if (!existe)
            {
                cout << "\n\tFuncionario não encontrado!..." << endl;
                cout << "\n\tDeseja cadastrar? (s/n): ";
                cin >> opcao;
                cin.get();

                if (opcao == 's' || opcao == 'S')
                {
                    cadastrar(funcionario);
                }
                else
                {
                    if (opcao == 'n' || opcao == 'N')
                    {
                        return cpf;
                    }
                }
            }

        } while (!existe || opcao != 'n' || opcao != 'N');

        return cpf;
    }

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

private:
};

#endif