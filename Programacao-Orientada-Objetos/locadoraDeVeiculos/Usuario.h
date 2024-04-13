#ifndef USUARIO_H
#define USUARIO_H
#include <iostream>
using namespace std;

#pragma once

class Usuario
{
private:
    string nome;
    string cpf;
    string endereco;
    string telefone;

public:
    Usuario() {}

    ~Usuario() {}

    Usuario(string nome, string cpf, string endereco, string telefone)
    {
        this->nome = nome;
        this->cpf = cpf;
        this->endereco = endereco;
        this->telefone = telefone;
    }

    void setCPF(string cpf)
    {
        this->cpf = cpf;
    }

    string getCPF()
    {
        return this->cpf;
    }

    void setNome(string nome)
    {
        this->nome = nome;
    }

    string getNome()
    {
        return this->nome;
    }

    void setEndereco(string endereco)
    {
        this->endereco = endereco;
    }

    string getEndereco()
    {
        return this->endereco;
    }

    void setTelefone(string telefone)
    {
        this->telefone = telefone;
    }

    string getTelefone()
    {
        return this->telefone;
    }

    void imprime()
    {
        cout << "CPF: " << this->cpf << endl;
        cout << "Nome: " << this->nome << endl;
        cout << "Endereco: " << this->endereco << endl;
        cout << "Telefone: " << this->telefone << endl;
    }
};

#endif