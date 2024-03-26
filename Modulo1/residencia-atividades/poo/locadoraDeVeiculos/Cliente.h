#ifndef CLIENTE_H
#define CLIENTE_H
#include <iostream>
#include <vector>
#include "Usuario.h"
#include "Aluguel.h"
#include "Veiculo.h"

using namespace std;

#pragma once

class Cliente : public Usuario
{
private:
    string habilitacao;

    vector<Cliente> clientes;

    // Aluguel aluguel;

    // vector<Aluguel> listHistoricoAlugueis;

public:

    Cliente() {}

    ~Cliente() {}

    Cliente(string nome, string cpf, string endereco, string telefone, string habilitacao) : Usuario(nome, cpf, endereco, telefone)
    {
        this->habilitacao = habilitacao;
        this->setNome(nome);
        this->setCPF(cpf);
        this->setEndereco(endereco);
        this->setTelefone(telefone);
        // this->aluguel = aluguel;
    }

    void setHabilitacao(string habilitacao)
    {
        this->habilitacao = habilitacao;
    }

    string getHabilitacao()
    {
        return this->habilitacao;
    }

    // void setAluguel(Aluguel aluguel)
    // {
    //     this->listHistoricoAlugueis.push_back(aluguel);
    // }

    // vector<Aluguel> getAluguel()
    // {
    //     return this->listHistoricoAlugueis;
    // }

    void setCliente(Cliente cliente)
    {
        this->clientes.push_back(cliente);
    }

    vector<Cliente> getCliente()
    {
        return this->clientes;
    }

    vector<Cliente> clientesCadastrados(Cliente &cliente)
    {
        return cliente.clientes;
    }

    Cliente cadastrar(Cliente &cliente)
    {
        string nome;
        string cpf;
        string endereco;
        string telefone;
        string habilitacao;

        cliente.limpaTela();
        cout << "\n\t==========CADASTRO DE CLIENTE==========\n";
        cout << "\n\tInforme o nome do Cliente: ";
        getline(cin, nome);
        cliente.setNome(nome);

        cout << "\n\tInforme o CPF: ";
        getline(cin, cpf);
        cliente.setCPF(cpf);

        cout << "\n\tInforme o número da habilitação: ";
        getline(cin, habilitacao);
        cliente.setHabilitacao(habilitacao);

        cout << "\n\tInforme o endereço: ";
        getline(cin, endereco);
        cliente.setEndereco(endereco);

        cout << "\n\tInforme o telefone: ";
        getline(cin, telefone);
        cliente.setTelefone(telefone);

        // cliente.setCliente(cliente);

        // cliente(nome, cpf, endereco, telefone, habilitacao);

        setCliente(cliente);

        return cliente;
    }

    void listar()
    {
        limpaTela();
        cout << "\n\t==========LISTA DE CLIENTES==========\n";
        for (auto it = clientes.begin(); it != clientes.end(); it++)
        {

            cout << "\n\tNome: " << it->getNome();
            cout << "\n\tCPF: " << it->getCPF();
            cout << "\n\tCNH: " << it->getHabilitacao();
            cout << "\n\tEndereço: " << it->getEndereco();
            cout << "\n\tTelefone: " << it->getTelefone();
            cout << "\n\t====================================\n";
        }
        pause();
    }

    const string editar(Cliente &cliente)
    {
        string nome;
        string cpf;
        string endereco;
        string telefone;
        bool encontrou = false;

        do
        {
            limpaTela();
            cout << "\n\tInforme o cpf do cliente, para edição: ";
            getline(cin, cpf);

            for (auto it = cliente.clientes.begin(); it != cliente.clientes.end(); it++)
            {
                if (it->localizarCpf(cpf) == cpf)
                {
                    cout << "\n\t==========EDITAR CLIENTE==========\n";
                    cout << "\n\tInforme o nome do Cliente: ";
                    getline(cin, nome);
                    it->setNome(nome);

                    cout << "\n\tInforme o CPF: ";
                    getline(cin, cpf);
                    it->setCPF(cpf);

                    cout << "\n\tInforme o número da habilitação: ";
                    getline(cin, habilitacao);
                    it->setHabilitacao(habilitacao);

                    cout << "\n\tInforme o endereço: ";
                    getline(cin, endereco);
                    it->setEndereco(endereco);

                    cout << "\n\tInforme o telefone: ";
                    getline(cin, telefone);
                    it->setTelefone(telefone);

                    encontrou = true;
                    break;
                }
            }

            if (!encontrou)
            {
                limpaTela();
                cout << "\n\tOps, cliente não encontrado!..." << endl;
                pause();
            }
            else
            {
                limpaTela();
                cout << "\n\tCliente editado com sucesso!..." << endl;
                pause();
                listar();
                return cpf;
            }

        } while (!encontrou);

        return cpf;
    }

    string excluir(Cliente &cliente)
    {
        string nome;
        string cpf;
        string endereco;
        string telefone;
        bool encontrou = true;

        do
        {
            limpaTela();
            cout << "\n\t==========EXCLUIR CLIENTE==========\n";
            cout << "\n\tInforme o cpf do cliente, para exclusão: ";
            getline(cin, cpf);

            for (auto it = cliente.clientes.begin(); it != cliente.clientes.end(); it++)
            {
                if (it->getCPF() == cpf)
                {
                    cout << "\n\tCliente: " << it->getNome() << " excluido com sucesso!..." << endl;
                    pause();
                    cliente.clientes.erase(it);
                    encontrou = false;
                    break;
                }
            }

            if (encontrou)
            {
                limpaTela();
                cout << "\n\tOps, cliente não encontrado!..." << endl;
                pause();
            }
            else
            {
                listar();
                return cpf;
            }

        } while (encontrou);

        return cpf;
    }

    string verificaCliente(string cpf)
    {
        bool existe = false;
        char opcao;

        do
        {

            limpaTela();
            cout << "\n\t==========EDITAR CLIENTE==========\n";
            cout << "\n\tInforme o cpf do cliente, para edição: ";
            getline(cin, cpf);

            for (auto it = clientes.begin(); it != clientes.end(); it++)
            {
                if (it->getCPF() == cpf)
                {
                    return cpf;
                }
            }
            if (!existe)
            {
                limpaTela();
                cout << "\n\tOps, cliente não encontrado!..." << endl;
                pause();

                do
                {
                    cout << "\n\tDeseja continuar? (s/n): ";
                    cout << "\n\tEntrada -> ";
                    cin >> opcao;
                    limpaBuffer();

                    if (opcao != 's' && opcao != 'S' && opcao != 'n' && opcao != 'N')
                    {
                        limpaTela();
                        cout << "\n\tOps, opção invalida!..." << endl;
                        pause();
                    }
                    if (opcao == 'n' || opcao == 'N')
                    {
                        return cpf;
                    }

                } while (opcao != 's' && opcao != 'S' && opcao != 'n' && opcao != 'N');
            }
            else
            {
                listar();
            }

        } while (!existe || opcao != 'n' || opcao != 'N');

        return cpf;
    }

    string localizarCpf(string cpf)
    {
        for (auto it = clientes.begin(); it != clientes.end(); it++)
        {
            if (it->getCPF() == cpf)
            {
                return cpf;
            }
        }
        return cpf;
    }

    float cotarAluguel(Veiculo veiculo, string dataInicio, string dataFim)
    {
        float valor = 0;
        int dias = 0;
        float valorTotal = 0;

        // dias = Utils::calcularDias(dataInicio, dataFim);

        valor = veiculo.getValorDiaria();

        valorTotal = dias * valor;

        return valorTotal;  

    }
    
    // Aluguel solicitarAluguel(Veiculo veiculo, string dataIncio, string dataFim)
    // {
        // Aluguel aluguel;
        // string cpf;
        // string nome;
        // string endereco;
        // string telefone;
        // string habilitacao;
        // string placa;
        // string modelo;
        // string cor;
        // string ano;
        // string valorDiaria;
        // string valorTotal;
        // string dataInicio;
        // string dataTermino;

        // limpaTela();
        // cout << "\n\t==========SOLICITAR ALUGUEL==========\n";
        // cout << "\n\tInforme o nome do Cliente: ";
        // getline(cin, nome);
        // aluguel.setNome(nome);

        // cout << "\n\tInforme o CPF: ";
        // getline(cin, cpf);
        // aluguel.setCPF(cpf);

        // cout << "\n\tInforme o número da habilitação: ";
        // getline(cin, habilitacao);
        // aluguel.setHabilitacao(habilitacao);

        // cout << "\n\tInforme o endereço: ";
        // getline(cin, endereco);
        // aluguel.setEndereco(endereco);

        // cout << "\n\tInforme o telefone: ";
        // getline(cin, telefone);
        // aluguel.setTelefone(telefone);

        // cout << "\n\tInforme a placa do veículo: ";
        // getline(cin, placa);
        // aluguel.setPlaca(placa);

        // cout << "\n\tInforme o modelo do veículo: ";
        // getline(cin, modelo);
        // aluguel.setModelo(modelo);

        // cout << "\n\tInforme a cor do veículo: ";
        // getline(cin, cor);
        // aluguel.setCor(cor);

        // cout << "\n\tInforme o ano do veículo: ";
        // getline(cin, ano);
        // aluguel.setAno(ano);

        // cout << "\n\tInforme o valor da diária: ";
        // getline(cin, valorDiaria);
        // aluguel.setValorDiaria(valorDiaria);

        // cout << "\n\tInforme o valor total: ";
        // getline(cin, valorTotal);
        // aluguel.setValorTotal(valorTotal);

        // cout << "\n\tInforme a data de inicio: ";
        // getline(cin, dataInicio);
        // aluguel.setDataInicio(dataInicio);

        // cout << "\n\tInforme a data de fim: ";
        // getline(cin, dataFim);
        // aluguel.setDataFim(dataFim);

        // return aluguel;
    // }

    // void devolverVeiculo(Aluguel aluguel, string dataDevolucao)
    // {
    //     string cpf;
    //     string nome;
    //     string endereco;
    //     string telefone;
    //     string habilitacao;
    //     string placa;
    //     string modelo;
    //     string cor;
    //     string ano;
    //     string valorDiaria;
    //     string valorTotal;
    //     string dataInicio;
    //     string dataFim;

        // limpaTela();
        // cout << "\n\t==========DEVOLVER VEÍCULO==========\n";
        // cout << "\n\tInforme o nome do Cliente: ";
        // getline(cin, nome);
        // aluguel.setNome(nome);

        // cout << "\n\tInforme o CPF: ";
        // getline(cin, cpf);
        // aluguel.setCPF(cpf);

        // cout << "\n\tInforme o número da habilitação: ";
        // getline(cin, habilitacao);
        // aluguel.setHabilitacao(habilitacao);

        // cout << "\n\tInforme o endereço: ";
        // getline(cin, endereco);
        // aluguel.setEndereco(endereco);

        // cout << "\n\tInforme o telefone: ";
        // getline(cin, telefone);
        // aluguel.setTelefone(telefone);

        // cout << "\n\tInforme a placa do veículo: ";
        // getline(cin, placa);
        // aluguel.setPlaca(placa);

        // cout << "\n\tInforme o modelo do veículo: ";
        // getline(cin, modelo);
        // aluguel.setModelo(modelo);

        // cout << "\n\tInforme a cor do veículo: ";
        // getline(cin, cor);
        // aluguel.setCor(cor);

        // cout << "\n\tInforme o ano do veículo: ";
        // getline(cin, ano);
        // aluguel.setAno(ano);

        // cout << "\n\tInforme o valor da diária: ";
        // getline(cin, valorDiaria);
        // aluguel.setValorDiaria(valorDiaria);

        // cout << "\n\tInforme o valor total: ";
        // getline(cin, valorTotal);
        // aluguel.setValorTotal(valorTotal);

        // cout << "\n\tInforme a data de inicio: ";
        // getline(cin, dataInicio);
        // aluguel.setDataInicio(dataInicio);

        // cout << "\n\tInforme a data de fim: ";
        // getline(cin, dataFim);
    // }

    vector<Cliente>::iterator localizarCliente(string cpf)
    {
        for (auto it = clientes.begin(); it != clientes.end(); it++)
        {
            if (it->getCPF() == cpf)
            {
                return it;
            }
        }
        // retorna um iterador inválido (clientes.end())
        return clientes.end();
    }

    void localizar()
    {
        string cpf;
        bool encontrou = true;

        do
        {
            limpaTela();
            cout << "\n\t==========LOCALIZAR CLIENTE==========\n";
            cout << "\n\tInforme o cpf do cliente, para localizar: ";
            getline(cin, cpf);

            for (auto it = clientes.begin(); it != clientes.end(); it++)
            {
                if (it->getCPF() == cpf)
                {
                    limpaTela();
                    cout << "\n\t==========CLIENTE ENCONTRADO==========\n";
                    cout << "\n\tNome: " << it->getNome();
                    cout << "\n\tCPF: " << it->getCPF();
                    cout << "\n\tCNH: " << it->getHabilitacao();
                    cout << "\n\tEndereço: " << it->getEndereco();
                    cout << "\n\tTelefone: " << it->getTelefone();
                    cout << "\n\t======================================\n";
                    pause();
                    encontrou = false;
                    break;
                }
            }

            if (encontrou)
            {
                limpaTela();
                cout << "\n\tOps, cliente não encontrado!..." << endl;
                pause();
            }

        } while (encontrou);
    }

    void limpaBuffer()
    {
        cin.get();
    }

    void limpaTela()
    {
#ifdef _WIN32
        system("cls");
#else
        system("clear");
#endif
    }

    void pause()
    {
        cout << "\n\tDigite enter para continuar!...\n";
        cin.get();
        limpaTela();
    }
};

#endif