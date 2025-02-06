/*Exercício 3:
Faça um programa para um supermercado para a consulta de preço de produtos. O programa deverá armazenar de cada produto o seu código, seu nome e seu preço. Ao utilizar o programa o usuário deve poder:

1. Inserir um novo produto
2. Excluir um produto cadastrado
3. Listar todos os produtos com seus respectivos códigos e preços
4. Consultar o preço de um produto através de seu código.
O código deve ser formado de uma string numérica de 13 caracteres
O nome deve ter um tamanho de no máximo 20 caracteres
O preço deve ter duas casas decimais
O sistema deve permitir o cadastro de até 300 produtos diferentes.
O sistema deve controlar para que não tenha produtos com o mesmo código ou
mesmo nome, não permitindo o seu cadastro.
O sistema deverá ser feito modularizados, com qualidade e utilizando estrutura na
sua implementação.*/

#include <iostream>
#include <string>
#include <iomanip>
#include <vector>
#include <algorithm>

using namespace std;

struct produto
{
    string codigo;
    string nome;
    float preco;
};

void inserirProduto(vector<produto> &produtos);

void excluirProduto(vector<produto> &produtos);

void listarProdutos(vector<produto> &produtos);

void consultarPreco(vector<produto> &produtos);

int main()
{
    vector<produto> produtos;
    int opcao;

    do
    {
        cout << "Digite a opcao desejada: " << endl;
        cout << "1. Inserir um novo produto" << endl;
        cout << "2. Excluir um produto cadastrado" << endl;
        cout << "3. Listar todos os produtos com seus respectivos codigos e precos" << endl;
        cout << "4. Consultar o preco de um produto atraves de seu codigo" << endl;
        cout << "0. Sair" << endl;
        cin >> opcao;

        switch (opcao)
        {
        case 1:
            inserirProduto(produtos);
            break;
        case 2:
            excluirProduto(produtos);
            break;
        case 3:
            listarProdutos(produtos);
            break;
        case 4:
            consultarPreco(produtos);
            break;
        case 0:
            cout << "Saindo..." << endl;
            break;
        default:
            cout << "Opcao invalida!" << endl;
            break;
        }
    } while (opcao != 0);

}

void inserirProduto(vector<produto> &produtos)
{
    produto novoProduto;
    cout << "Digite o codigo do produto: ";
    cin >> novoProduto.codigo;

    cout << "Digite o nome do produto: ";
    cin >> novoProduto.nome;

    cout << "Digite o preco do produto: ";
    cin >> novoProduto.preco;

    produtos.push_back(novoProduto);
}

void excluirProduto(vector<produto> &produtos)
{
    string codigo;
    cout << "Digite o codigo do produto que deseja excluir: ";
    cin >> codigo;

    for (int i = 0; i < produtos.size(); i++)
    {
        if (produtos[i].codigo == codigo)
        {
            produtos.erase(produtos.begin() + i);
            cout << "Produto excluido com sucesso!" << endl;
            return;
        }
    }
    cout << "Produto nao encontrado!" << endl;
}

void listarProdutos(vector<produto> &produtos)
{
    cout << "Produtos cadastrados: " << endl;
    for (int i = 0; i < produtos.size(); i++)
    {
        cout << "Codigo: " << produtos[i].codigo << endl;
        cout << "Nome: " << produtos[i].nome << endl;
        cout << "Preco: " << produtos[i].preco << endl;
    }
}

void consultarPreco(vector<produto> &produtos)
{
    string codigo;
    cout << "Digite o codigo do produto que deseja consultar o preco: ";
    cin >> codigo;

    for (int i = 0; i < produtos.size(); i++)
    {
        if (produtos[i].codigo == codigo)
        {
            cout << "Preco: " << produtos[i].preco << endl;
            return;
        }
    }
    cout << "Produto nao encontrado!" << endl;
}

