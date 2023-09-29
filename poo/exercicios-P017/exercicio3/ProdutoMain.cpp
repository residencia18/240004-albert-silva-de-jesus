#include <iostream>
#include <vector>
#include "Utils.h"
#include "Produto.h"
#include "Estoque.h"
#include "CarrinhoDeCompras.h"

using namespace std;

int main()
{
  Produto produto1("Maçã", 2.5);
  Produto produto2("Arroz", 10.0);
  Produto produto3("Leite", 4.0);

  CarrinhoDeCompras carrinho;
  carrinho.adicionarProduto(produto1, 3);
  carrinho.adicionarProduto(produto2, 2);
  carrinho.adicionarProduto(produto3, 1);

  double valorTotal = carrinho.calcularValorTotal();
  cout << "\n\tValor total da compra: " << valorTotal << "\n" << endl;

  carrinho.removerProduto(produto2, 1);
  valorTotal = carrinho.calcularValorTotal();
  cout << "\n\tValor total após remoção: " << valorTotal << "\n" << endl;
}