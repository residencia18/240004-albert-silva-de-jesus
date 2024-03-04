#ifndef CIDADE_H
#define CIDADE_H
#include <iostream>
#include "Estado.h"
using namespace std;

#pragma once

class Cidade
{
    
private:

public:

    string nome;
    Estado *estado;

    Cidade() {}

    ~Cidade() {}

    string getNome()
    {
        return this->nome;
    }

    void setNome(string nome)
    {
        this->nome = nome;
    }

    void lerCidade(vector<Estado> estados)
    {

        cout << "Informe a cidade: ";
        getline(cin, this->nome);

        cout << "\n\tInforme o Estado: ";
        getline(cin, estado->nome);

        cout << "\n\tInforme a sigla: ";
        getline(cin, estado->sigla);
    }
};

#endif