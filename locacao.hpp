#ifndef LOCACAO_HPP
#define LOCACAO_HPP

#include <iostream>
#include "dataHora.hpp"
#include "cliente.hpp"
#include "veiculo.hpp"

using namespace std;

typedef struct
{
    Cliente cliente;
    Veiculo veiculo;
    bool realizada;
    DataHora retirada;
    DataHora entrega;
} Locacao;

#endif