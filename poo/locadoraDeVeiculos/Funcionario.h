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

    Funcionario(){}

    ~Funcionario(){}

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

    void cadastrar(Funcionario &funcionario){

        cout << "\n\tInforme o nome do Funcionario: ";
        getline(cin, nome);

        cout << "\n\tInforme o cpf do Funcionario: ";
        getline(cin, cpf);

        cout << "\n\tInforme o Longradouro do Funcionario: ";
        getline(cin, endereco);

        cout << "\n\tInforme o telefone do Usuário: ";
        getline(cin, telefone);

        setFuncionario(funcionario);
    }

    void listar(){

        for(auto it = funcionarios.begin(); it != funcionarios.end(); it++){

            cout << "\n\tNome: " << it->getNome();
            cout << "\n\tCPF: " << it->getCPF();
            cout << "\n\tEndereço: " << it->getEndereco();
            cout << "\n\tTelefone: " << it->getTelefone();
        }
    }

private:
};

#endif