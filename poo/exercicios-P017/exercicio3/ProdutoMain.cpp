#include <iostream>
#include <string>
#include <vector>
#include "Produto.h"
#include "Estoque.h"

using namespace std;

int main(){
  
    Estoque estoque;
    vector<Estoque> listEstoque;

    estoque.cadastrarProduto(listEstoque);

    estoque.listarProdutos(listEstoque);
}