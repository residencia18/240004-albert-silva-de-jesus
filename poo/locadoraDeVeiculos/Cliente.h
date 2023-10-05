#ifndef CLIENTE_H
#define CLIENTE_H
#include <iostream>
#include "Usuario.h"
#include "Aluguel.h"
#include "Utils.h"
#include <vector>

using namespace std;

#pragma once

class Cliente : public Usuario
{
public:
    string habilitacao;
    vector<Aluguel> listHistoricoAlugueis;
    vector<Cliente> clientes;

    Cliente() {}

    ~Cliente() {}

    void setHabilitacao(string habilitacao)
    {
        this->habilitacao = habilitacao;
    }

    string getHabilitacao()
    {
        return this->habilitacao;
    }

    void setAluguel(Aluguel aluguel)
    {
        this->listHistoricoAlugueis.push_back(aluguel);
    }

    vector<Aluguel> getAluguel()
    {
        return this->listHistoricoAlugueis;
    }

    void setCliente(Cliente cliente)
    {
        this->clientes.push_back(cliente);
    }

    vector<Cliente> getCliente()
    {
        return this->clientes;
    }

    void cadastrar(Cliente &cliente)
    {
        limpaTela();
        cout << "\n\t==========CADASTRO DE CLIENTE==========\n";
        cout << "\n\tInforme o nome do Cliente: ";
        getline(cin, nome);

        cout << "\n\tInforme o CPF: ";
        getline(cin, cpf);

        cout << "\n\tInforme o número da habilitação: ";
        getline(cin, this->habilitacao);

        cout << "\n\tInforme o endereço: ";
        getline(cin, endereco);

        cout << "\n\tInforme o telefone: ";
        getline(cin, telefone);

        setCliente(cliente);
    }

    void listar()
    {
        limpaTela();
        cout << "\n\t==========LISTA DE CLIENTES==========\n";
        for (auto it = clientes.begin(); it != clientes.end(); it++)
        {

            cout << "\n\tNome: " << it->getNome();
            cout << "\n\tCPF: " << it->getCPF();
            cout << "\n\tCNH: " << it->getHabilitacao();
            cout << "\n\tEndereço: " << it->getEndereco();
            cout << "\n\tTelefone: " << it->getTelefone();
            cout << "\n\t====================================\n";
        }
        pause();
    }

    void editar()
    {

        string cpf;
        bool encontrou = false;

        do
        {
            limpaTela();
            cout << "\n\tInforme o cpf do cliente, para edição: ";
            getline(cin, cpf);

            for (auto it = clientes.begin(); it != clientes.end(); it++)
            {
                if (it->cpf == cpf)
                {
                    cout << "\n\tInforme o nome do Cliente: ";
                    getline(cin, it->nome);

                    cout << "\n\tInforme o CPF: ";
                    getline(cin, it->cpf);

                    cout << "\n\tInforme o número da habilitação: ";
                    getline(cin, it->habilitacao);

                    cout << "\n\tInforme o endereço: ";
                    getline(cin, it->endereco);

                    cout << "\n\tInforme o telefone: ";
                    getline(cin, it->telefone);

                    encontrou = true;
                    break;
                }
            }

            if (!encontrou)
            {
                limpaTela();
                cout << "\n\tOps, cliente não encontrado!..." << endl;
                pause();
            }
            else
            {
                limpaTela();
                cout << "\n\tCliente editado com sucesso!..." << endl;
                pause();
                listar();
            }

        } while (!encontrou);
    }

    void excluir()
    {
        string cpf;
        bool encontrou = true;

        do
        {
            limpaTela();
            cout << "\n\tInforme o cpf do cliente, para exclusão: ";
            getline(cin, cpf);

            for (auto it = clientes.begin(); it != clientes.end(); it++)
            {
                if (it->cpf == cpf)
                {
                    cout << "\n\tCliente: " << it->nome << " excluido com sucesso!..." << endl;
                    pause();
                    clientes.erase(it);
                    encontrou = false;
                    break;
                }
            }

            if (encontrou)
            {
                limpaTela();
                cout << "\n\tOps, cliente não encontrado!..." << endl;
                pause();
            }
            else
            {
                listar();
            }

        } while (encontrou);
    }

    void localizar()
    {
        string cpf;
        bool encontrou = true;

        do
        {
            limpaTela();
            cout << "\n\t==========LOCALIZAR CLIENTE==========\n";
            cout << "\n\tInforme o cpf do cliente, para localizar: ";
            getline(cin, cpf);

            for (auto it = clientes.begin(); it != clientes.end(); it++)
            {
                if (it->cpf == cpf)
                {
                    limpaTela();
                    cout << "\n\t==========CLIENTE ENCONTRADO==========\n";
                    cout << "\n\tNome: " << it->getNome();
                    cout << "\n\tCPF: " << it->getCPF();
                    cout << "\n\tCNH: " << it->getHabilitacao();
                    cout << "\n\tEndereço: " << it->getEndereco();
                    cout << "\n\tTelefone: " << it->getTelefone();
                    cout << "\n\t======================================\n";
                    pause();
                    encontrou = false;
                    break;
                }
            }

            if (encontrou)
            {
                limpaTela();
                cout << "\n\tOps, cliente não encontrado!..." << endl;
                pause();
            }

        } while (encontrou);
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