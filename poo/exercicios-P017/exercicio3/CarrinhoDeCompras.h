#include <iostream>
#include <vector>
#include <Produto.h>
#ifndef CARRINHODECOMPRAS_H
#define CARRINHODECOMPRAS_H

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
        this->valorTotal = valorTotal;
    }

    CarrinhoDeCompras(Produto produto, vector<Produto> produtosDoCarinho)
    {
        this->produto = produto;
        this->produtosDoCarinho = produtosDoCarinho;
    }

    CarrinhoDeCompras();

    ~CarrinhoDeCompras();

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