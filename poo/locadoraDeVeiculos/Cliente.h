#ifndef CLIENTE_H
#define CLIENTE_H
#include <iostream>
#include "Usuario.h"
#include "Aluguel.h"

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
        for (auto it = clientes.begin(); it != clientes.end(); it++)
        {

            cout << "\n\tNome: " << it->getNome();
            cout << "\n\tCPF: " << it->getCPF();
            cout << "\n\tCNH: " << it->getHabilitacao();
            cout << "\n\tEndereço: " << it->getEndereco();
            cout << "\n\tTelefone: " << it->getTelefone();
        }
    }

private:
};

#endif