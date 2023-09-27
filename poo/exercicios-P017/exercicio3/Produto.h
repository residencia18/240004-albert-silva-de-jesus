#include <iostream>
#ifndef PRODUTO_H
#define PRODUTO_H

using namespace std;

#pragma once

static auto codigo = 0;

class Produto
{
    
public:

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

    void codigoDoProduto()
    {
       codigo++;
    }

private:
};

#endif