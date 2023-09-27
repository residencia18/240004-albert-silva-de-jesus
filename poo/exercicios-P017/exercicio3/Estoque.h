#include <iostream>
#include <string>
#include <vector>
#include <Produto.h>
#ifndef ESTOQUE_H
#define ESTOQUE_H

using namespace std;

#pragma once

class Estoque
{
public:
    int quantidade;
    vector<Produto> produtos;

    Estoque(int quantidade, vector<Produto> produtos)
    {
        this->quantidade = quantidade;
        this->produtos = produtos;
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

    void adicionarProduto(Produto produto)
    {
        char resposta;
        cout << "\n\t===========ADICIONANDO PRODUTO AO ESTOQUE===========\n";

        do
        {

            cout << "\n\tInforme o nome do produto: ";
            cin >> produto.nome;

            cout << "\n\tInforme o preço do produto: ";
            cin >> produto.preco;

            cout << "\n\tInforme a quantidade do produto: ";
            cin >> this->quantidade;

            cout << "Deseja adicionar mais produtos? (s/n): ";
            cin >> resposta;

            if (quantidade <= 0)
            {
                cout << "\n\tQuantidade inválida, tente novamente!\n";
            }

        } while (this->quantidade <= 0 && resposta == 's');

        this->produtos.push_back(produto);
        cout << "\n\tProduto adicionado com sucesso!\n";
    }

    void removerProduto(Produto produto)
    {
        for (int i = 0; i < this->produtos.size(); i++)
        {
            if (this->produtos[i].getNome() == produto.getNome())
            {
                this->produtos.erase(this->produtos.begin() + i);
            }
        }
    }

private:
};

#endif