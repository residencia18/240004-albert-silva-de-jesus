#ifndef LOCACAO_HPP
#define LOCACAO_HPP

#include <iostream>
#include "dataHora.hpp"
#include "ocorrencia.hpp"
#include "veiculo.hpp"
#include "cliente.hpp"

using namespace std;

typedef struct
{
    bool realizada;
    DataHora retirada;
    DataHora entrega;
    Cliente cliente;
    Veiculo veiculo;
    Ocorrencia ocorrencia;
} Locacao;

#endif