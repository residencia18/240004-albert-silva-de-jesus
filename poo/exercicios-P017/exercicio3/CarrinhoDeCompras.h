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
    vector<CarrinhoDeCompras> carrinho;
    double quantidade;
    double valorTotal = 0;

    CarrinhoDeCompras() {}

    ~CarrinhoDeCompras() {}

    double getQuantidade()
    {
        return this->quantidade;
    }

    void setQuantidade(double quantidade)
    {
        this->quantidade = quantidade;
    }

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
        CarrinhoDeCompras carrinho;
        carrinho.valorTotal = (produto.getPreco() * quantidade);
        carrinho.quantidade = quantidade;
        this->produtosDoCarinho.push_back(produto);
        this->carrinho.push_back(carrinho);
    }

    void removerProduto(Produto produto, double quantidade)
    {
        for (auto it = produtosDoCarinho.begin(); it != produtosDoCarinho.end(); it++)
        {
            if (it->getNome() == produto.getNome())
            {
                carrinho.at(it - produtosDoCarinho.begin()).quantidade -= quantidade;
                carrinho.at(it - produtosDoCarinho.begin()).valorTotal -= (produto.getPreco() * quantidade);

                break;
            }
        }
    }

    double calcularValorTotal()
    {
        double valorTotal = 0;
        for (auto it = carrinho.begin(); it != carrinho.end(); it++)
        {
            valorTotal += it->valorTotal;
        }
        return valorTotal;
    }

private:
};

#endif