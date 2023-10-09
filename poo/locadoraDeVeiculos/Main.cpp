#include <iostream>
#include "ControlerLocadora.h"
#include "Aluguel.h"
#include "Cliente.h"
#include "Funcionario.h"
#include "Veiculo.h"

using namespace std;

int main()
{
    ControlerLocadora gestao;
    Funcionario funcionario;
    Cliente cliente;
    Veiculo veiculo;
    Aluguel aluguel;
   
    gestao.LocadoraDeVeiculos(cliente, funcionario, veiculo, aluguel);
}