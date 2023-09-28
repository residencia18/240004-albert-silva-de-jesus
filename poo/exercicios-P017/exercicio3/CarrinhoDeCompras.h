#ifndef CARRINHODECOMPRAS_H
#define CARRINHODECOMPRAS_H
#include <iostream>
#include <vector>
#include "Produto.h"

using namespace std;

#pragma once

class CarrinhoDeCompras
{
public:

    Produto produto;
    vector<Produto> produtosDoCarinho;
    double valorTotal;

    CarrinhoDeCompras(Produto produto, double valorTotal)
    {
        this->produto = produto;
        this->produtosDoCarinho.push_back(produto);
        this->valorTotal = valorTotal;
    }

    CarrinhoDeCompras() {}

    ~CarrinhoDeCompras() {}

    double getValorTotal()
    {
        return this->valorTotal;
    }

    void setValorTotal(double valorTotal)
    {
        this->valorTotal = valorTotal;
    }

    void adicionarProduto(Produto produto, int quantidade)
    {
        this->valorTotal += produto.getPreco() * quantidade;
        this->produtosDoCarinho.push_back(produto);
    }

private:
};

#endif