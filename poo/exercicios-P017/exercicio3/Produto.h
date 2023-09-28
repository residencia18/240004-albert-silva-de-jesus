#ifndef PRODUTO_H
#define PRODUTO_H
#include <iostream>
#include <string>
#include "Estoque.h"

using namespace std;

#pragma once

class Produto : public Estoque
{
public:

    int codigo = 0;
    string nome;
    double preco;

    Produto(string nome, double preco)
    {
        this->nome = nome;
        this->preco = preco;
    }

    Produto() {}

    ~Produto() {}

    int getCodigo()
    {
        return codigo;
    }

    string getNome()
    {
        return this->nome;
    }

    void setNome(string nome)
    {
        this->nome = nome;
    }

    double getPreco()
    {
        return this->preco;
    }

    void setPreco(double preco)
    {
        this->preco = preco;
    }

    int codigoDoProduto()
    {
        return codigo++;
    }

private:

};

#endif