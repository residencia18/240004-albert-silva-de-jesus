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
        cliente.cadastrar(cliente);

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

    static void editarCliente(Cliente &cliente)
    {
        string cpf;
        auto it = cliente.clientes.begin();
        ifstream arquivoIn("clientes.txt");
        ofstream arquivoTemp("temp.txt");

        if (!arquivoIn.is_open() || !arquivoTemp.is_open())
        {
            cout << "Erro ao abrir os arquivos" << endl;
            return;
        }

        bool clienteEncontrado = false;
        string nome, cpfLido, endereco, telefone, habilitacao;
        cpf = cliente.verificaCliente(cpf);

        while (getline(arquivoIn, nome) && getline(arquivoIn, cpfLido) &&
               getline(arquivoIn, endereco) && getline(arquivoIn, telefone) &&
               getline(arquivoIn, habilitacao) && it != cliente.clientes.end())
        {
            if (cpfLido == cpf)
            {
                cliente.limpaTela();
                clienteEncontrado = true;
                cout << "\n\t==========EDITAR CLIENTE==========\n";
                cout << "\n\tInforme o nome do Cliente: ";
                getline(cin, it->nome);

                cout << "\n\tInforme o número da habilitação: ";
                getline(cin, it->habilitacao);

                cout << "\n\tInforme o endereço: ";
                getline(cin, it->endereco);

                cout << "\n\tInforme o telefone: ";
                getline(cin, it->telefone);

                arquivoTemp << it->nome << endl;
                arquivoTemp << cpf << endl;
                arquivoTemp << it->endereco << endl;
                arquivoTemp << it->telefone << endl;
                arquivoTemp << it->habilitacao << endl;
            }
            else
            {
                arquivoTemp << nome << endl;
                arquivoTemp << cpfLido << endl;
                arquivoTemp << endereco << endl;
                arquivoTemp << telefone << endl;
                arquivoTemp << habilitacao << endl;
            }
        }

        arquivoIn.close();
        arquivoTemp.close();

        if (clienteEncontrado)
        {
            // Substitui o arquivo original pelo arquivo temporário
            remove("clientes.txt");
            rename("temp.txt", "clientes.txt");
            cliente.limpaTela();
            cout << "\n\tCliente editado com sucesso!..." << endl;
            cliente.pause();
            cliente.listar();
        }
        else
        {
            cout << "Ops, Cliente com CPF " << cpf << " não encontrado." << endl;
            remove("temp.txt"); // Exclui o arquivo temporário, pois não houve alterações
        }
    }

    static void excluirCliente(const string &cpf)
    {
        ifstream arquivoIn("clientes.txt");
        ofstream arquivoTemp("temp.txt");

        if (!arquivoIn.is_open() || !arquivoTemp.is_open())
        {
            cout << "Erro ao abrir os arquivos" << endl;
            return;
        }

        string nome, cpfLido, endereco, telefone, habilitacao;

        bool clienteEncontrado = false;

        while (getline(arquivoIn, nome) && getline(arquivoIn, cpfLido) &&
               getline(arquivoIn, endereco) && getline(arquivoIn, telefone) &&
               getline(arquivoIn, habilitacao))
        {
            if (cpfLido == cpf) // Verifique se o CPF do cliente coincide com o CPF fornecido
            {
                clienteEncontrado = true;
            }
            else
            {
                arquivoTemp << nome << endl;
                arquivoTemp << cpfLido << endl;
                arquivoTemp << endereco << endl;
                arquivoTemp << telefone << endl;
                arquivoTemp << habilitacao << endl;
            }
        }

        arquivoIn.close();
        arquivoTemp.close();

        if (clienteEncontrado)
        {
            // Substitua o arquivo original pelo arquivo temporário
            remove("clientes.txt");
            rename("temp.txt", "clientes.txt");
            cout << "Cliente excluído com sucesso" << endl;
        }
        else
        {
            cout << "Cliente não encontrado" << endl;
            remove("temp.txt"); // Exclua o arquivo temporário, pois não houve alterações
        }
    }

    static void salvarFuncionario(Funcionario &funcionario)
    {
        funcionario.cadastrar(funcionario);

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

    static void editarFuncionario(Funcionario &funcionario)
    {
        string cpf;
        auto it = funcionario.funcionarios.begin();
        ifstream arquivoIn("funcionarios.txt");
        ofstream arquivoTemp("temp.txt");

        if (!arquivoIn.is_open() || !arquivoTemp.is_open())
        {
            cout << "Erro ao abrir os arquivos" << endl;
            return;
        }

        bool funcionarioEncontrado = false;
        string nome, cpfLido, endereco, telefone;
        cpf = funcionario.verificaFuncionario(cpf);

        while (getline(arquivoIn, nome) && getline(arquivoIn, cpfLido) &&
               getline(arquivoIn, endereco) && getline(arquivoIn, telefone) &&
               it != funcionario.funcionarios.end())
        {
            if (cpfLido == cpf)
            {
                funcionario.limpaTela();
                funcionarioEncontrado = true;
                cout << "\n\t==========EDITAR FUNCIONARIO==========\n";
                cout << "\n\tInforme o nome do Funcionario: ";
                getline(cin, it->nome);

                cout << "\n\tInforme o endereço: ";
                getline(cin, it->endereco);

                cout << "\n\tInforme o telefone: ";
                getline(cin, it->telefone);

                arquivoTemp << it->nome << endl;
                arquivoTemp << cpf << endl;
                arquivoTemp << it->endereco << endl;
                arquivoTemp << it->telefone << endl;
            }
            else
            {
                arquivoTemp << nome << endl;
                arquivoTemp << cpfLido << endl;
                arquivoTemp << endereco << endl;
                arquivoTemp << telefone << endl;
            }
        }

        arquivoIn.close();
        arquivoTemp.close();

        if (funcionarioEncontrado)
        {
            // Substitui o arquivo original pelo arquivo temporário
            remove("funcionarios.txt");
            rename("temp.txt", "funcionarios.txt");
            funcionario.limpaTela();
            cout << "\n\tFuncionario editado com sucesso!..." << endl;
            funcionario.pause();
            funcionario.listar();
        }
        else
        {
            cout << "Ops, Funcionario com CPF " << cpf << " não encontrado." << endl;
            remove("temp.txt"); // Exclui o arquivo temporário, pois não houve alterações
        }
    }

    static void excluirFuncionario(const string &cpf)
    {
        ifstream arquivoIn("funcionarios.txt");
        ofstream arquivoTemp("temp.txt");

        if (!arquivoIn.is_open() || !arquivoTemp.is_open())
        {
            cout << "Erro ao abrir os arquivos" << endl;
            return;
        }

        string nome, cpfLido, endereco, telefone;

        bool funcionarioEncontrado = false;

        while (getline(arquivoIn, nome) && getline(arquivoIn, cpfLido) &&
               getline(arquivoIn, endereco) && getline(arquivoIn, telefone))
        {
            if (cpfLido == cpf) // Verifique se o CPF do funcionario coincide com o CPF fornecido
            {
                funcionarioEncontrado = true;
            }
            else
            {
                arquivoTemp << nome << endl;
                arquivoTemp << cpfLido << endl;
                arquivoTemp << endereco << endl;
                arquivoTemp << telefone << endl;
            }
        }

        arquivoIn.close();
        arquivoTemp.close();

        if (funcionarioEncontrado)
        {
            // Substitua o arquivo original pelo arquivo temporário
            remove("funcionarios.txt");
            rename("temp.txt", "funcionarios.txt");
            cout << "Funcionario excluído com sucesso" << endl;
        }
        else
        {
            cout << "Funcionario não encontrado" << endl;
            remove("temp.txt"); // Exclua o arquivo temporário, pois não houve alterações
        }
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