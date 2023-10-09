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

    // Cliente

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

    static void recuperarCliente(Cliente &clientes)
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
                    clientes.setCliente(cliente);
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
               getline(arquivoIn, habilitacao))
        {
            if (cpfLido == cpf)
            {
                cliente.limpaTela();
                clienteEncontrado = true;
                cout << "\n\t==========EDITAR CLIENTE==========\n";
                cout << "\n\tInforme o nome do Cliente: ";
                getline(cin, nome);
                cliente.localizarCliente(cpf)->setNome(nome);

                cout << "\n\tInforme o número da habilitação: ";
                getline(cin, habilitacao);
                cliente.localizarCliente(cpf)->setHabilitacao(habilitacao);

                cout << "\n\tInforme o endereço: ";
                getline(cin, endereco);
                cliente.localizarCliente(cpf)->setEndereco(endereco);

                cout << "\n\tInforme o telefone: ";
                getline(cin, telefone);
                cliente.localizarCliente(cpf)->setTelefone(telefone);

                arquivoTemp << cliente.localizarCliente(cpf)->getNome() << endl;
                arquivoTemp << cpf << endl;
                arquivoTemp << cliente.localizarCliente(cpf)->getEndereco() << endl;
                arquivoTemp << cliente.localizarCliente(cpf)->getTelefone() << endl;
                arquivoTemp << cliente.localizarCliente(cpf)->getHabilitacao() << endl;
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
            // cliente.listar();
        }
        else
        {
            cout << "Cliente não encontrado" << endl;
            remove("temp.txt"); // Exclua o arquivo temporário, pois não houve alterações
        }
    }

    // Funcionario

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

    static void recuperarFuncionario(Funcionario &funcionarios)
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
                    funcionarios.setFuncionario(funcionario);
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
               getline(arquivoIn, endereco) && getline(arquivoIn, telefone))
        {
            if (cpfLido == cpf)
            {
                funcionario.limpaTela();
                funcionarioEncontrado = true;
                cout << "\n\t==========EDITAR FUNCIONARIO==========\n";
                cout << "\n\tInforme o nome do Funcionario: ";
                getline(cin, nome);
                funcionario.localizarFuncionario(cpf)->setNome(nome);

                cout << "\n\tInforme o endereço: ";
                getline(cin, endereco);
                funcionario.localizarFuncionario(cpf)->setEndereco(endereco);

                cout << "\n\tInforme o telefone: ";
                getline(cin, telefone);
                funcionario.localizarFuncionario(cpf)->setTelefone(telefone);

                arquivoTemp << funcionario.localizarFuncionario(cpf)->getNome() << endl;
                arquivoTemp << cpf << endl;
                arquivoTemp << funcionario.localizarFuncionario(cpf)->getEndereco() << endl;
                arquivoTemp << funcionario.localizarFuncionario(cpf)->getTelefone() << endl;
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

    // Veiculo

    static void salvarVeiculo(Veiculo &veiculo)
    {
        veiculo.cadastrar(veiculo);

        ofstream arquivo;
        arquivo.open("veiculos.txt", ios::app);
        if (arquivo.is_open())
        {
            arquivo << veiculo.getIdentificador() << endl;
            arquivo << veiculo.getMarca() << endl;
            arquivo << veiculo.getModelo() << endl;
            arquivo << veiculo.getAnoFabricacao() << endl;
            arquivo << veiculo.getValorDiaria() << endl;
        }
        else
        {
            cout << "Erro ao abrir o arquivo" << endl;
        }
        arquivo.close();
    }

    static void recuperarVeiculo(Veiculo &veiculos)
    {
        ifstream arquivo;
        arquivo.open("veiculos.txt", ios::in);
        if (arquivo.is_open())
        {

            string identificador, marca, modelo, anoFabricacao, valorDiariaStr;

            while (getline(arquivo, identificador) &&
                   getline(arquivo, marca) &&
                   getline(arquivo, modelo) &&
                   getline(arquivo, anoFabricacao) &&
                   getline(arquivo, valorDiariaStr))
            {
                if (!identificador.empty() && !valorDiariaStr.empty())
                {
                    Veiculo veiculo;
                    veiculo.setIdentificador(identificador);
                    veiculo.setMarca(marca);
                    veiculo.setModelo(modelo);

                    try
                    {
                        float valorDiaria = stof(valorDiariaStr);
                        veiculo.setAnoFabricacao(stoi(anoFabricacao));
                        veiculo.setValorDiaria(valorDiaria);
                    }
                    catch (const exception &e)
                    {
                        cout << "Erro ao converter valor: " << e.what() << endl;
                        continue; // Pular este registro e continuar com o próximo
                    }

                    veiculos.setVeiculo(veiculo);
                }
            }
        }
        else
        {
            cout << "Erro ao abrir o arquivo" << endl;
        }

        arquivo.close();
    }

    static void editarVeiculo(Veiculo &veiculo)
    {
        string identificador;
        ifstream arquivoIn("veiculos.txt");
        ofstream arquivoTemp("temp.txt");

        if (!arquivoIn.is_open() || !arquivoTemp.is_open())
        {
            cout << "Erro ao abrir os arquivos" << endl;
            return;
        }

        bool veiculoEncontrado = false;
        string identificadorLido, marca, modelo, anoFabricacao, valorDiariaStr;
        identificador = veiculo.verificaVeiculo(identificador);

        while (getline(arquivoIn, identificadorLido) &&
               getline(arquivoIn, marca) &&
               getline(arquivoIn, modelo) &&
               getline(arquivoIn, anoFabricacao) &&
               getline(arquivoIn, valorDiariaStr))
        {
            if (identificadorLido == identificador)
            {
                veiculo.limpaTela();
                veiculoEncontrado = true;
                cout << "\n\t==========EDITAR VEICULO==========\n";
                cout << "\n\tInforme o identificador do Veiculo: ";
                getline(cin, identificador);
                veiculo.localizarVeiculo(identificador)->setIdentificador(identificador);

                cout << "\n\tInforme a marca: ";
                getline(cin, marca);
                veiculo.localizarVeiculo(identificador)->setMarca(marca);

                cout << "\n\tInforme o modelo: ";
                getline(cin, modelo);
                veiculo.localizarVeiculo(identificador)->setModelo(modelo);

                cout << "\n\tInforme o ano de fabricação: ";
                getline(cin, anoFabricacao);
                veiculo.localizarVeiculo(identificador)->setAnoFabricacao(stoi(anoFabricacao));

                cout << "\n\tInforme o valor da diária: ";
                getline(cin, valorDiariaStr);
                veiculo.localizarVeiculo(identificador)->setValorDiaria(stof(valorDiariaStr));

                arquivoTemp << veiculo.localizarVeiculo(identificador)->getIdentificador() << endl;
                arquivoTemp << veiculo.localizarVeiculo(identificador)->getMarca() << endl;
                arquivoTemp << veiculo.localizarVeiculo(identificador)->getModelo() << endl;
                arquivoTemp << veiculo.localizarVeiculo(identificador)->getAnoFabricacao() << endl;
                arquivoTemp << veiculo.localizarVeiculo(identificador)->getValorDiaria() << endl;
            }
            else
            {
                arquivoTemp << identificadorLido << endl;
                arquivoTemp << marca << endl;
                arquivoTemp << modelo << endl;
                arquivoTemp << anoFabricacao << endl;
                arquivoTemp << valorDiariaStr << endl;
            }
        }

        arquivoIn.close();
        arquivoTemp.close();

        if (veiculoEncontrado)
        {
            // Substitui o arquivo original pelo arquivo temporário
            remove("veiculos.txt");
            rename("temp.txt", "veiculos.txt");
            veiculo.limpaTela();
            cout << "\n\tVeiculo editado com sucesso!..." << endl;
            veiculo.pause();
            veiculo.listar();
        }
        else
        {
            cout << "Ops, Veiculo com identificador " << identificador << " não encontrado." << endl;
            remove("temp.txt"); // Exclui o arquivo temporário, pois não houve alterações
        }
    }

    static void excluirVeiculo(const string &identificador)
    {
        Veiculo veiculo;
        ifstream arquivoIn("veiculos.txt");
        ofstream arquivoTemp("temp.txt");

        if (!arquivoIn.is_open() || !arquivoTemp.is_open())
        {
            cout << "Erro ao abrir os arquivos" << endl;
            return;
        }

        string identificadorLido, marca, modelo, anoFabricacao, valorDiariaStr;

        bool veiculoEncontrado = false;

        while (getline(arquivoIn, identificadorLido) &&
               getline(arquivoIn, marca) &&
               getline(arquivoIn, modelo) &&
               getline(arquivoIn, anoFabricacao) &&
               getline(arquivoIn, valorDiariaStr))
        {
            if (identificadorLido == identificador) // Verifique se o identificador do veiculo coincide com o identificador fornecido
            {
                veiculoEncontrado = true;
            }
            else
            {
                arquivoTemp << identificadorLido << endl;
                arquivoTemp << marca << endl;
                arquivoTemp << modelo << endl;
                arquivoTemp << anoFabricacao << endl;
                arquivoTemp << valorDiariaStr << endl;
            }
        }

        arquivoIn.close();
        arquivoTemp.close();

        if (veiculoEncontrado)
        {
            // Substitua o arquivo original pelo arquivo temporário
            remove("veiculos.txt");
            rename("temp.txt", "veiculos.txt");
            cout << "Veiculo excluído com sucesso" << endl;
        }
        else
        {
            cout << "Veiculo não encontrado" << endl;
            veiculo.pause();
            remove("temp.txt"); // Exclua o arquivo temporário, pois não houve alterações
        }
    }

    // Aluguel

    static void salvarAluguel(Aluguel &aluguel)
    {
        aluguel.cadastrar(aluguel);

        ofstream arquivo;
        arquivo.open("alugueis.txt", ios::app);
        if (arquivo.is_open())
        {
            arquivo << aluguel.getCliente().getNome() << endl;
            arquivo << aluguel.getCliente().getCPF() << endl;
            arquivo << aluguel.getVeiculo().getIdentificador() << endl;
            // arquivo << aluguel.getFuncionario().getNome() << endl;
            // arquivo << aluguel.getFuncionario().getCPF() << endl;
            // arquivo << aluguel.getDataInicio() << endl;
            // arquivo << aluguel.getDataFim() << endl;
            // arquivo << aluguel.getValorTotal() << endl;
        }
        else
        {
            cout << "Erro ao abrir o arquivo" << endl;
        }
        arquivo.close();
    }

    static void recuperarAluguel(Aluguel &alugueis)
    {
        ifstream arquivo;
        arquivo.open("alugueis.txt", ios::in);
        if (arquivo.is_open())
        {
            string nomeCliente, cpfCliente, identificadorVeiculo, nomeFuncionario, cpfFuncionario, dataInicio, dataFim, valorTotalStr;

            while (getline(arquivo, nomeCliente) &&
                   getline(arquivo, cpfCliente) &&
                   getline(arquivo, identificadorVeiculo) &&
                   getline(arquivo, nomeFuncionario) &&
                   getline(arquivo, cpfFuncionario) &&
                   getline(arquivo, dataInicio) &&
                   getline(arquivo, dataFim) &&
                   getline(arquivo, valorTotalStr))
            {
                if (!nomeCliente.empty() && !cpfCliente.empty() && !identificadorVeiculo.empty() && !nomeFuncionario.empty() && !cpfFuncionario.empty() && !dataInicio.empty() && !dataFim.empty() && !valorTotalStr.empty())
                {
                    Aluguel aluguel;
                    // aluguel.setCliente(nomeCliente, cpfCliente);
                    // aluguel.setVeiculo(identificadorVeiculo);
                    // aluguel.setFuncionario(nomeFuncionario, cpfFuncionario);
                    // aluguel.setDataInicio(dataInicio);
                    // aluguel.setDataFim(dataFim);
                    // aluguel.setValorTotal(stof(valorTotalStr));
                    alugueis.setAluguel(aluguel);
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