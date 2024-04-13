#ifndef ESTADO_H
#define ESTADO_H
#include <vector>
#include <iostream>
using namespace std;

#pragma once

class Estado
{
private:
public:

    string nome;
    string sigla;
    vector<Estado> estados;

    Estado() {}

    ~Estado() {}

    string getNome()
    {
        return this->nome;
    }

    void setNome(string nome)
    {
        this->nome = nome;
    }

    string getSigla()
    {
        this->sigla = sigla;
    }

    void setSigla(string sigla)
    {
        this->sigla = sigla;
    }

    vector<Estado> getEstado()
    {
        return estados;
    }

    void setEstado(vector<Estado> estados)
    {
        this->estados = estados;
    }

};

#endif