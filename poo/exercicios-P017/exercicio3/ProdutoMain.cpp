#include <iostream>
#include <string>
#include <vector>
#include "Produto.h"
#include "Estoque.h"
#include "Utils.h"

using namespace std;

void gestaoDeVendas(Produto produto, vector<Estoque> &listEstoque);

int main()
{
  Produto produto;
  Estoque estoque;
  vector<Estoque> listEstoque;

  gestaoDeVendas(produto, listEstoque);

  estoque.cadastrarProduto(listEstoque);

  estoque.listarProdutos(listEstoque);
}

void gestaoDeVendas(Produto produto, vector<Estoque> &listEstoque)
{
  int escolha = 0;
  int cliente = 0;

  do
  {
    switch (cliente = produto.menuPrincipal())
    {

    case 1:

      do
      {
        escolha = produto.menuEscolha();
        if (escolha == 1)
        {
        }
        if (escolha == 2)
        {
          if (listEstoque.empty())
          {
            cout << "\n\tNão há clientes cadastrados!...\n";
            produto.pause();
          }
          else
          {
          }
        }
        if (escolha == 3)
        {
          if (listEstoque.empty())
          {
            cout << "\n\tNão há clientes cadastrados!...\n";
            produto.pause();
          }
          else
          {
          }
        }
        if (escolha == 4)
        {
          if (listEstoque.empty())
          {
            cout << "\n\tNão há clientes cadastrados!...\n";
            produto.pause();
          }
          else
          {
          }
        }
        if (escolha == 5)
        {
          if (listEstoque.empty())
          {
            cout << "\n\tNão há clientes cadastrados!...\n";
            produto.pause();
          }
          else
          {
          }
        }
        if (escolha > 5 && escolha < 0)
        {
          produto.limpaTela();
          cout << "\n\tOps, opção invalida!";
          produto.pause();
        }

      } while (escolha != 0);

      break;

    case 2:

      do
      {
        escolha = produto.menuEscolha();
        if (escolha == 1)
        {
        }

      } while (escolha != 0);

      break;

    case 3:

      break;

    case 0:

      cout << "\n\tPrograma encerrado com sucesso!..." << endl;
      cliente = 0;
      exit(0);

    default:
      cout << "\tOps, Opção invalida!";
    }
  } while (cliente != 0);
}