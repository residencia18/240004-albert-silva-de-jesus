#ifndef ESTOQUE_H
#define ESTOQUE_H
#include "Produto.h"
#include <iostream>
#include <string>
#include <vector>

using namespace std;

#pragma once

class Estoque : public Produto
{

public:
    int quantidade = 0;
    vector<Estoque> listEstoque;

    Estoque(vector<Estoque> listEstoque)
    {
        this->listEstoque = listEstoque;
    }

    Estoque() {}

    ~Estoque() {}

    int getQuantidade()
    {
        return this->quantidade;
    }

    void setQuantidade(int quantidade)
    {
        this->quantidade = quantidade;
    }

    void cadastrarProduto(vector<Estoque> &listEstoque)
    {
        Estoque estoque;
        char resposta;
        cout << "\n\t===========ADICIONANDO PRODUTO AO ESTOQUE===========\n";

        do
        {
            cout << "\n\tInforme o nome do produto: ";
            getline(cin, estoque.nome);

            cout << "\n\tInforme o preço do produto: ";
            cin >> estoque.preco;

            cout << "\n\tInforme a quantidade do produto: ";
            cin >> estoque.quantidade;
            limpaBuffer();

            estoque.codigoDoProduto();

            if (estoque.getQuantidade() <= 0)
            {
                cout << "\n\tQuantidade inválida, tente novamente!\n";
            }
            else
            {
                estoque.limpaTela();
                listEstoque.push_back(estoque);
                cout << "\n\tProduto adicionado com sucesso!\n";
                pause();
            }

            cout << "\n\tDeseja adicionar mais produtos? (s/n): ";
            cin >> resposta;
            estoque.limpaBuffer();

        } while (resposta != 'n');
    }

    void listarProdutos(vector<Estoque> &listEstoque)
    {
        limpaTela();
        cout << "\n\t==============LISTANDO PRODUTOS DO ESTOQUE==============\n";
        cout << "\n\tCODIGO\t\tNOME\t\tPREÇO\t\tQUANTIDADE\n";
        for (auto it = listEstoque.begin(); it != listEstoque.end(); it++)
        {
            cout << "\n\t" << it->getCodigo() << "\t\t" << it->getNome() << "\t\t" << it->getPreco() << "\t\t" << it->getQuantidade() << "\n";
        }
    }

private:
};

#endif