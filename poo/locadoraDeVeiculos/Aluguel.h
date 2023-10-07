#ifndef ALUGUEL_H
#define ALUGUEL_H
#include <iostream>
#include "Veiculo.h"
#include "Cliente.h"
#include "Funcionario.h"
#include <string>
#include <ctime>
#include <vector>

using namespace std;

#pragma once

class Aluguel
{
private:
    string identificador;
    Veiculo veiculo;
    Cliente cliente;
    //Funcionario funcionario;
    string dataInicio;
    string dataTermino;
    string dataDevolucao;
    float desconto;
    float adicional;
    float valorTotal;
    vector<Aluguel> alugueis;

public:
    Aluguel() {}

    ~Aluguel() {}

    void setIdentificador(string identificador)
    {
        this->identificador = identificador;
    }

    string getIdentificador()
    {
        return this->identificador;
    }

    void setVeiculo(Veiculo veiculo)
    {
        this->veiculo = veiculo;
    }

    Veiculo getVeiculo()
    {
        return this->veiculo;
    }

    void setCliente(Cliente cliente)
    {
        this->cliente = cliente;
    }

    Cliente getCliente()
    {
        return this->cliente;
    }

    // void setFuncionario(Funcionario funcionario)
    // {
    //     this->funcionario = funcionario;
    // }

    // Funcionario getFuncionario()
    // {
    //     return this->funcionario;
    // }

    void setDataInicio(string dataInicio)
    {
        this->dataInicio = dataInicio;
    }

    string getDataInicio()
    {
        return this->dataInicio;
    }

    void setDataTermino(string dataTermino)
    {
        this->dataTermino = dataTermino;
    }

    string getDataTermino()
    {
        return this->dataTermino;
    }

    void setDataDevolucao(string dataDevolucao)
    {
        this->dataDevolucao = dataDevolucao;
    }

    string getDataDevolucao()
    {
        return this->dataDevolucao;
    }

    void setDesconto(float desconto)
    {
        this->desconto = desconto;
    }

    float getDesconto()
    {
        return this->desconto;
    }

    void setAdicional(float adicional)
    {
        this->adicional = adicional;
    }

    float getAdicional()
    {
        return this->adicional;
    }

    void setValorTotal(float valorTotal)
    {
        this->valorTotal = valorTotal;
    }

    float getValorTotal()
    {
        return this->valorTotal;
    }

    void setAluguel(Aluguel &aluguel)
    {
        alugueis.push_back(aluguel);
    }

    vector<Aluguel> getAluguel()
    {
        return this->alugueis;
    }

    void imprime()
    {
        cout << "Identificador: " << this->identificador << endl;
        cout << "Veiculo: " << this->veiculo.getIdentificador() << endl;
        cout << "Cliente: " << this->cliente.getCPF() << endl;
        // cout << "Funcionario: " << this->funcionario.getCPF() << endl;
        cout << "Data Inicio: " << this->dataInicio << endl;
        cout << "Data Termino: " << this->dataTermino << endl;
        cout << "Data Devolucao: " << this->dataDevolucao << endl;
        cout << "Desconto: " << this->desconto << endl;
        cout << "Adicional: " << this->adicional << endl;
        cout << "Valor Total: " << this->valorTotal << endl;
    }

    void listar()
    {
        for (int i = 0; i < alugueis.size(); i++)
        {
            cout << "Identificador: " << alugueis[i].getIdentificador() << endl;
            cout << "Veiculo: " << alugueis[i].getVeiculo().getIdentificador() << endl;
            cout << "Cliente: " << alugueis[i].getCliente().getCPF() << endl;
            // cout << "Funcionario: " << alugueis[i].getFuncionario().getCPF() << endl;
            cout << "Data Inicio: " << alugueis[i].getDataInicio() << endl;
            cout << "Data Termino: " << alugueis[i].getDataTermino() << endl;
            cout << "Data Devolucao: " << alugueis[i].getDataDevolucao() << endl;
            cout << "Desconto: " << alugueis[i].getDesconto() << endl;
            cout << "Adicional: " << alugueis[i].getAdicional() << endl;
            cout << "Valor Total: " << alugueis[i].getValorTotal() << endl;
        }
    }

    void localizar()
    {
        string identificador;
        cout << "\n\tDigite o identificador do aluguel: ";
        cin >> identificador;
        for (int i = 0; i < alugueis.size(); i++)
        {
            if (alugueis[i].getIdentificador() == identificador)
            {
                cout << "Identificador: " << alugueis[i].getIdentificador() << endl;
                cout << "Veiculo: " << alugueis[i].getVeiculo().getIdentificador() << endl;
                cout << "Cliente: " << alugueis[i].getCliente().getCPF() << endl;
                // cout << "Funcionario: " << alugueis[i].getFuncionario().getCPF() << endl;
                cout << "Data Inicio: " << alugueis[i].getDataInicio() << endl;
                cout << "Data Termino: " << alugueis[i].getDataTermino() << endl;
                cout << "Data Devolucao: " << alugueis[i].getDataDevolucao() << endl;
                cout << "Desconto: " << alugueis[i].getDesconto() << endl;
                cout << "Adicional: " << alugueis[i].getAdicional() << endl;
                cout << "Valor Total: " << alugueis[i].getValorTotal() << endl;
            }
        }
    }

    void cadastrar(Aluguel &aluguel)
    {
        cliente.limpaTela();
        cout << "\n\t==========CADASTRO DE ALUGUEL==========\n";
        cout << "\n\tInforme o identificador do aluguel: ";
        getline(cin, identificador);

        // cout << "\n\tInforme o identificador do veiculo: ";
        // getline(cin, veiculo);

        // cout << "\n\tInforme o CPF do cliente: ";
        // getline(cin, cliente);

        // cout << "\n\tInforme o CPF do funcionario: ";
        // getline(cin, funcionario);

        cout << "\n\tInforme a data de inicio do aluguel: ";
        getline(cin, dataInicio);

        cout << "\n\tInforme a data de termino do aluguel: ";
        getline(cin, dataTermino);

        cout << "\n\tInforme a data de devolucao do aluguel: ";
        getline(cin, dataDevolucao);

        cout << "\n\tInforme o desconto do aluguel: ";
        cin >> desconto;

        cout << "\n\tInforme o adicional do aluguel: ";
        cin >> adicional;

        cout << "\n\tInforme o valor total do aluguel: ";
        cin >> valorTotal;

        setAluguel(aluguel);
    }

    void editar(Aluguel &aluguel)
    {
        string identificador;
        cout << "\n\tDigite o identificador do aluguel: ";
        cin >> identificador;
        for (int i = 0; i < alugueis.size(); i++)
        {
            if (alugueis[i].getIdentificador() == identificador)
            {
                cout << "\n\t==========EDITAR ALUGUEL==========\n";
                cout << "\n\tInforme o identificador do aluguel: ";
                getline(cin, identificador);

                // cout << "\n\tInforme o identificador do veiculo: ";
                // getline(cin, veiculo);

                // cout << "\n\tInforme o CPF do cliente: ";
                // string nome;
                // getline(cin, cliente.setCPF(nome));

                // cout << "\n\tInforme o CPF do funcionario: ";
                // getline(cin, funcionario);

                cout << "\n\tInforme a data de inicio do aluguel: ";
                getline(cin, dataInicio);

                cout << "\n\tInforme a data de termino do aluguel: ";
                getline(cin, dataTermino);

                cout << "\n\tInforme a data de devolucao do aluguel: ";
                getline(cin, dataDevolucao);

                cout << "\n\tInforme o desconto do aluguel: ";
                cin >> desconto;

                cout << "\n\tInforme o adicional do aluguel: ";
                cin >> adicional;

                cout << "\n\tInforme o valor total do aluguel: ";
                cin >> valorTotal;

                setAluguel(aluguel);
            }
        }
    }

    void excluir(Aluguel &aluguel)
    {
        string identificador;
        cout << "\n\tDigite o identificador do aluguel: ";
        cin >> identificador;
        for (int i = 0; i < alugueis.size(); i++)
        {
            if (alugueis[i].getIdentificador() == identificador)
            {
                alugueis.erase(alugueis.begin() + i);
            }
        }
    }

    //void alugar(Aluguel &aluguel, Veiculo &veiculo, Cliente &cliente, Funcionario &funcionario)
    // {
    //     string identificador;
    //     cout << "\n\tDigite o identificador do veiculo: ";
    //     cin >> identificador;
    //     for (int i = 0; i < veiculo.getVeiculo().size(); i++)
    //     {
    //         if (veiculo.getVeiculo()[i].getIdentificador() == identificador)
    //         {
    //             cout << "\n\t==========ALUGAR VEICULO==========\n";
    //             cout << "\n\tInforme o identificador do aluguel: ";
    //             getline(cin, identificador);

    //             // cout << "\n\tInforme o identificador do veiculo: ";
    //             // getline(cin, veiculo);

    //             // cout << "\n\tInforme o CPF do cliente: ";
    //             // getline(cin, cliente);

    //             // cout << "\n\tInforme o CPF do funcionario: ";
    //             // getline(cin, funcionario);

    //             cout << "\n\tInforme a data de inicio do aluguel: ";
    //             getline(cin, dataInicio);

    //             cout << "\n\tInforme a data de termino do aluguel: ";
    //             getline(cin, dataTermino);

    //             cout << "\n\tInforme a data de devolucao do aluguel: ";
    //             getline(cin, dataDevolucao);

    //             cout << "\n\tInforme o desconto do aluguel: ";
    //             cin >> desconto;

    //             cout << "\n\tInforme o adicional do aluguel: ";
    //             cin >> adicional;

    //             cout << "\n\tInforme o valor total do aluguel: ";
    //             cin >> valorTotal;

    //             setAluguel(aluguel);
    //         }
    //     }
    // }

    //void devolver(Aluguel &aluguel, Veiculo &veiculo, Cliente &cliente, Funcionario &funcionario)
    // {
        // string identificador;
        // cout << "\n\tDigite o identificador do veiculo: ";
        // cin >> identificador;
        // for (int i = 0; i < veiculo.getVeiculo().size(); i++)
        // {
        //     if (veiculo.getVeiculo()[i].getIdentificador() == identificador)
        //     {
        //         cout << "\n\t==========DEVOLVER VEICULO==========\n";
        //         cout << "\n\tInforme o identificador do aluguel: ";
        //         getline(cin, identificador);

        //         cout << "\n\tInforme o identificador do veiculo: ";
        //         getline(cin, veiculo);

        //         cout << "\n\tInforme o CPF do cliente: ";
        //         getline(cin, cliente);

        //         cout << "\n\tInforme o CPF do funcionario: ";
        //         getline(cin, funcionario);

        //         cout << "\n\tInforme a data de inicio do aluguel: ";
        //         getline(cin, dataInicio);

        //         cout << "\n\tInforme a data de termino do aluguel: ";
        //         getline(cin, dataTermino);

        //         cout << "\n\tInforme a data de devolucao do aluguel: ";
        //         getline(cin, dataDevolucao);

        //         cout << "\n\tInforme o desconto do aluguel: ";
        //         cin >> desconto;

        //         cout << "\n\tInforme o adicional do aluguel: ";
        //         cin >> adicional;

        //         cout << "\n\tInforme o valor total do aluguel: ";
        //         cin >> valorTotal;

        //         setAluguel(aluguel);
        //     }
        // }
    // }

    void listarAlugueis()
    {
        for (int i = 0; i < alugueis.size(); i++)
        {
            cout << "Identificador: " << alugueis[i].getIdentificador() << endl;
            cout << "Veiculo: " << alugueis[i].getVeiculo().getIdentificador() << endl;
            cout << "Cliente: " << alugueis[i].getCliente().getCPF() << endl;
            // cout << "Funcionario: " << alugueis[i].getFuncionario().getCPF() << endl;
            cout << "Data Inicio: " << alugueis[i].getDataInicio() << endl;
            cout << "Data Termino: " << alugueis[i].getDataTermino() << endl;
            cout << "Data Devolucao: " << alugueis[i].getDataDevolucao() << endl;
            cout << "Desconto: " << alugueis[i].getDesconto() << endl;
            cout << "Adicional: " << alugueis[i].getAdicional() << endl;
            cout << "Valor Total: " << alugueis[i].getValorTotal() << endl;
        }
    }

    float calcularValorTotal()
    {
        float valorTotal = 0;
        for (int i = 0; i < alugueis.size(); i++)
        {
            valorTotal += alugueis[i].getValorTotal();
        }
        return valorTotal;
    }

    void gerarRelatorio()
    {
        cout << "\n\t==========RELATORIO DE ALUGUEIS==========\n";
        cout << "\n\tQuantidade de alugueis: " << alugueis.size() << endl;
        cout << "\n\tValor total de alugueis: " << calcularValorTotal() << endl;
    }

    void gerarRelatorioPorData()
    {
        string dataInicio;
        string dataTermino;
        cout << "\n\t==========RELATORIO DE ALUGUEIS POR DATA==========\n";
        cout << "\n\tInforme a data de inicio: ";
        getline(cin, dataInicio);
        cout << "\n\tInforme a data de termino: ";
        getline(cin, dataTermino);
        for (int i = 0; i < alugueis.size(); i++)
        {
            if (alugueis[i].getDataInicio() >= dataInicio && alugueis[i].getDataTermino() <= dataTermino)
            {
                cout << "Identificador: " << alugueis[i].getIdentificador() << endl;
                cout << "Veiculo: " << alugueis[i].getVeiculo().getIdentificador() << endl;
                cout << "Cliente: " << alugueis[i].getCliente().getCPF() << endl;
                // cout << "Funcionario: " << alugueis[i].getFuncionario().getCPF() << endl;
                cout << "Data Inicio: " << alugueis[i].getDataInicio() << endl;
                cout << "Data Termino: " << alugueis[i].getDataTermino() << endl;
                cout << "Data Devolucao: " << alugueis[i].getDataDevolucao() << endl;
                cout << "Desconto: " << alugueis[i].getDesconto() << endl;
                cout << "Adicional: " << alugueis[i].getAdicional() << endl;
                cout << "Valor Total: " << alugueis[i].getValorTotal() << endl;
            }
        }
    }

    void gerarRelatorioPorVeiculo()
    {
        string identificador;
        cout << "\n\t==========RELATORIO DE ALUGUEIS POR VEICULO==========\n";
        cout << "\n\tInforme o identificador do veiculo: ";
        getline(cin, identificador);
        for (int i = 0; i < alugueis.size(); i++)
        {
            if (alugueis[i].getVeiculo().getIdentificador() == identificador)
            {
                cout << "Identificador: " << alugueis[i].getIdentificador() << endl;
                cout << "Veiculo: " << alugueis[i].getVeiculo().getIdentificador() << endl;
                cout << "Cliente: " << alugueis[i].getCliente().getCPF() << endl;
                // cout << "Funcionario: " << alugueis[i].getFuncionario().getCPF() << endl;
                cout << "Data Inicio: " << alugueis[i].getDataInicio() << endl;
                cout << "Data Termino: " << alugueis[i].getDataTermino() << endl;
                cout << "Data Devolucao: " << alugueis[i].getDataDevolucao() << endl;
                cout << "Desconto: " << alugueis[i].getDesconto() << endl;
                cout << "Adicional: " << alugueis[i].getAdicional() << endl;
                cout << "Valor Total: " << alugueis[i].getValorTotal() << endl;
            }
        }
    }

    void gerarRelatorioPorCliente()
    {
        string cpf;
        cout << "\n\t==========RELATORIO DE ALUGUEIS POR CLIENTE==========\n";
        cout << "\n\tInforme o CPF do cliente: ";
        getline(cin, cpf);
        for (int i = 0; i < alugueis.size(); i++)
        {
            if (alugueis[i].getCliente().getCPF() == cpf)
            {
                cout << "Identificador: " << alugueis[i].getIdentificador() << endl;
                cout << "Veiculo: " << alugueis[i].getVeiculo().getIdentificador() << endl;
                cout << "Cliente: " << alugueis[i].getCliente().getCPF() << endl;
                // cout << "Funcionario: " << alugueis[i].getFuncionario().getCPF() << endl;
                cout << "Data Inicio: " << alugueis[i].getDataInicio() << endl;
                cout << "Data Termino: " << alugueis[i].getDataTermino() << endl;
                cout << "Data Devolucao: " << alugueis[i].getDataDevolucao() << endl;
                cout << "Desconto: " << alugueis[i].getDesconto() << endl;
                cout << "Adicional: " << alugueis[i].getAdicional() << endl;
                cout << "Valor Total: " << alugueis[i].getValorTotal() << endl;
            }
        }
    }
};

#endif