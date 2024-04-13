#ifndef ALUNO_H
#define ALUNO_H
#include <iostream>

using namespace std;

#pragma once

class Aluno
{
private:
    string nome;
    int identificacao;

public:
    Aluno(string nome, int identificacao)
    {
        this->nome = nome;
        this->identificacao = identificacao;
    }

    Aluno() {}

    ~Aluno() {}

    string getNome()
    {
        return this->nome;
    }

    void setNome(string nome)
    {
        this->nome = nome;
    }

    int getIdentificacao()
    {
        return this->identificacao;
    }

    void setIdentificacao(int identificacao)
    {
        this->identificacao = identificacao;
    }

    void exibirDetalhes()
    {
        cout << "\n\tNome do Aluno: " << this->nome;
        cout << "\n\tIdentificação: " << this->identificacao << endl;
    }
};

#endif