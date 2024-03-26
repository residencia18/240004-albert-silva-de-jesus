#ifndef LISTA_LOCACOES_HPP
#define LISTA_LOCACOES_HPP

#include <iostream>
#include <vector>
#include "locacao.hpp"

using namespace std;

void insereLocacao(vector<Cliente> &listaClientes, vector<Veiculo> &listaVeiculos, vector<Locacao> &listaLocacao);

void excluiLocacao(vector<Cliente> &listaClientes, vector<Veiculo> &listaVeiculos, vector<Locacao> &listaLocacao);

void alteraLocacao(vector<Cliente> &listaClientes, vector<Veiculo> &listaVeiculos, vector<Locacao> &listaLocacao);

void listarLocacao(vector<Locacao> &listaLocacao);

bool verificaCliente(Locacao &locacao, vector<Cliente> &listaClientes, string cpf);

bool verificaVeiculo(Locacao &locacao, vector<Veiculo> &listaVeiculos, string placa);

#endif
