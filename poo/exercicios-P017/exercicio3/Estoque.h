#ifndef ESTOQUE_H
#define ESTOQUE_H
#include <iostream>
#include <string>

using namespace std;

#pragma once

class Estoque
{
public:

    int codigo = 0;
    string nome;
    double preco;
    int quantidade;

    Estoque(string nome, double preco, int quantidade)
    {
        this->nome = nome;
        this->preco = preco;
        this->quantidade = quantidade;
    }

    Estoque() {}

    ~Estoque() {}

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

    int getQuantidade()
    {
        return this->quantidade;
    }

    void setQuantidade(int quantidade)
    {
        this->quantidade = quantidade;
    }

    int codigoDoProduto()
    {
        return codigo++;
    }

private:
};

#endif