#include <iostream>
#include "Utils.h"
#include "Cliente.h"
#include "Funcionario.h"
#include <vector>
using namespace std;

int main()
{

    Utils utils;
    Funcionario funcionario;
    Cliente cliente;
    Veiculo veiculo;

    utils.gestaoLocadoraDeVeiculos(cliente, funcionario, veiculo);
}