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
    vector<pair<Produto, int>> itens_no_carrinho;
    double valorTotal = 0;

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

    void adicionarProduto(Produto produto, double quantidade)
    {
        itens_no_carrinho.push_back(make_pair(produto, quantidade));
    }

    void removerProduto(Produto produto, double quantidade)
    {
        for (auto it = itens_no_carrinho.begin(); it != itens_no_carrinho.end(); it++)
        {
            if (it->first.getNome() == produto.getNome())
            {
                itens_no_carrinho.at(it - itens_no_carrinho.begin()).second -= quantidade;

                break;
            }
        }
    }

    double calcularValorTotal()
    {
        valorTotal = 0;
        for (auto it = itens_no_carrinho.begin(); it != itens_no_carrinho.end(); it++)
        {
            valorTotal += (it->first.getPreco() * it->second);
        }
        return valorTotal;
    }

    int getQuantidadeDeProdutos(Produto produto)
    {
        int quantidade = 0;
        for (auto it = itens_no_carrinho.begin(); it != itens_no_carrinho.end(); it++)
        {
            if (it->second > 5)
            {
                quantidade = 5;
                break;
            }
        }
        return quantidade;
    }

    void esvaziarCarrinho()
    {
        itens_no_carrinho.clear();
    }

private:
};

#endif