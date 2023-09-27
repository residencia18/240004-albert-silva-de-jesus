#include <iostream>
#include "Produto.h"

using namespace std;

int main(){

    Produto produto1("Maça", 2.5);
    produto1.codigoDoProduto();
    Produto produto2("Arroz", 10.0);
    produto2.codigoDoProduto();
    Produto produto3("Leite", 4.0);

    cout << "Produto 1: " << produto1.getNome() << " - " << produto1.getPreco() << endl;
    
}