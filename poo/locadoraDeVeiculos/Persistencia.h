#ifndef PERSISTENCIA_H
#define PERSISTENCIA_H
#include <iostream>
#include "Cliente.h"
#include "Funcionario.h"
#include "Veiculo.h"
#include <string.h>
#include <vector>
#include <fstream>

using namespace std;

#pragma once

class Persistencia
{
public:
    Persistencia() {}

    ~Persistencia() {}

    static void salvarCliente(Cliente &cliente)
    {
        ofstream arquivo;
        arquivo.open("clientes.txt", ios::app);
        if (arquivo.is_open())
        {
            arquivo << cliente.getNome() << endl;
            arquivo << cliente.getCPF() << endl;
            arquivo << cliente.getEndereco() << endl;
            arquivo << cliente.getTelefone() << endl;
            arquivo << cliente.getHabilitacao() << endl;
        }
        else
        {
            cout << "Erro ao abrir o arquivo" << endl;
        }
        arquivo.close();
    }

    static void recuperarCliente(vector<Cliente> &clientes)
    {
        ifstream arquivo;
        arquivo.open("clientes.txt", ios::in);
        if (arquivo.is_open())
        {
            string nome, cpf, endereco, telefone, habilitacao;
            while (!arquivo.eof())
            {
                getline(arquivo, nome);
                getline(arquivo, cpf);
                getline(arquivo, endereco);
                getline(arquivo, telefone);
                getline(arquivo, habilitacao);
                if (nome != "")
                {
                    Cliente cliente;
                    cliente.setNome(nome);
                    cliente.setCPF(cpf);
                    cliente.setEndereco(endereco);
                    cliente.setTelefone(telefone);
                    cliente.setHabilitacao(habilitacao);
                    clientes.push_back(cliente);
                }
            }
        }
        else
        {
            cout << "Erro ao abrir o arquivo" << endl;
        }
        arquivo.close();
    }

    static void salvarFuncionario(Funcionario &funcionario)
    {
        ofstream arquivo;
        arquivo.open("funcionarios.txt", ios::app);
        if (arquivo.is_open())
        {
            arquivo << funcionario.getNome() << endl;
            arquivo << funcionario.getCPF() << endl;
            arquivo << funcionario.getEndereco() << endl;
            arquivo << funcionario.getTelefone() << endl;
        }
        else
        {
            cout << "Erro ao abrir o arquivo" << endl;
        }
        arquivo.close();
    }

    static void recuperarFuncionario(vector<Funcionario> &funcionarios)
    {
        ifstream arquivo;
        arquivo.open("funcionarios.txt", ios::in);
        if (arquivo.is_open())
        {
            string nome, cpf, endereco, telefone;
            while (!arquivo.eof())
            {
                getline(arquivo, nome);
                getline(arquivo, cpf);
                getline(arquivo, endereco);
                getline(arquivo, telefone);
                if (nome != "")
                {
                    Funcionario funcionario;
                    funcionario.setNome(nome);
                    funcionario.setCPF(cpf);
                    funcionario.setEndereco(endereco);
                    funcionario.setTelefone(telefone);
                    funcionarios.push_back(funcionario);
                }
            }
        }
        else
        {
            cout << "Erro ao abrir o arquivo" << endl;
        }
        arquivo.close();
    }

    static void salvarVeiculo(Veiculo &veiculo)
    {
        ofstream arquivo;
        arquivo.open("veiculos.txt", ios::app);
        if (arquivo.is_open())
        {
            arquivo << veiculo.getIdentificador() << endl;
            arquivo << veiculo.getMarca() << endl;
            arquivo << veiculo.getModelo() << endl;
            // arquivo << veiculo.getAnoFabricacao() << endl;
            arquivo << veiculo.getValorDiaria() << endl;
        }
        else
        {
            cout << "Erro ao abrir o arquivo" << endl;
        }
        arquivo.close();
    }

    static void recuperarVeiculo(vector<Veiculo> &veiculos)
    {
        ifstream arquivo;
        arquivo.open("veiculos.txt", ios::in);
        if (arquivo.is_open())
        {
            string identificador, marca, modelo, ano;
            float valorDiaria;
            int anoFabricacao = 0;

            while (!arquivo.eof())
            {
                getline(arquivo, identificador);
                getline(arquivo, marca);
                getline(arquivo, modelo);
                // getline(arquivo, ano);
                arquivo >> valorDiaria; 

                if (identificador != "")
                {
                    Veiculo veiculo;
                    // anoFabricacao = stoi(ano);
                    veiculo.setIdentificador(identificador);
                    veiculo.setMarca(marca);
                    veiculo.setModelo(modelo);
                    // veiculo.setAnoFabricacao(anoFabricacao);
                    veiculo.setValorDiaria(valorDiaria);
                    veiculos.push_back(veiculo);
                }
            }
        }
        else
        {
            cout << "Erro ao abrir o arquivo" << endl;
        }
        arquivo.close();
    }

private:
};

#endif