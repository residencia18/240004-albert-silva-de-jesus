#ifndef ALUGUEL_H
#define ALUGUEL_H
#include <iostream>
#include "Cliente.h"
#include "Veiculo.h"
#include "Funcionario.h"
#include <vector>

using namespace std;

#pragma once

class Aluguel
{
private:
    string identificador;
    Veiculo veiculo;
    Cliente cliente;
    // Funcionario funcionario;
    string dataInicio;
    string dataTermino;
    string dataDevolucao;
    float desconto;
    float adicional;
    float valorTotal;

public:
    vector<Aluguel> alugueis;

    Aluguel() {}

    ~Aluguel() {}

    Aluguel(string identificador, Veiculo veiculo, Cliente cliente, string dataInicio, string dataTermino, string dataDevolucao, float desconto, float adicional, float valorTotal)
    {
        this->identificador = identificador;
        this->veiculo = veiculo;
        this->cliente = cliente;
        // this->funcionario = funcionario;
        this->dataInicio = dataInicio;
        this->dataTermino = dataTermino;
        this->dataDevolucao = dataDevolucao;
        this->desconto = desconto;
        this->adicional = adicional;
        this->valorTotal = valorTotal;
    }

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
        // cout << "Identificador: " << this->identificador << endl;
        // cout << "Veiculo: " << this->veiculo.getIdentificador() << endl;
        // cout << "Cliente: " << this->cliente.getCPF() << endl;
        // // cout << "Funcionario: " << this->funcionario.getCPF() << endl;
        // cout << "Data Inicio: " << this->dataInicio << endl;
        // cout << "Data Termino: " << this->dataTermino << endl;
        // cout << "Data Devolucao: " << this->dataDevolucao << endl;
        // cout << "Desconto: " << this->desconto << endl;
        // cout << "Adicional: " << this->adicional << endl;
        // cout << "Valor Total: " << this->valorTotal << endl;
    }

    void listar()
    {
        // for (auto it = alugueis.begin(); it != alugueis.end(); it++)
        // {
        //     cout << "Identificador: " << it->getIdentificador() << endl;
        //     cout << "Veiculo: " << it->getVeiculo().getIdentificador() << endl;
        //     cout << "Cliente: " << it->getCliente().getCPF() << endl;
        //     // cout << "Funcionario: " << it->getFuncionario().getCPF() << endl;
        //     cout << "Data Inicio: " << it->getDataInicio() << endl;
        //     cout << "Data Termino: " << it->getDataTermino() << endl;
        //     cout << "Data Devolucao: " << it->getDataDevolucao() << endl;
        //     cout << "Desconto: " << it->getDesconto() << endl;
        //     cout << "Adicional: " << it->getAdicional() << endl;
        //     cout << "Valor Total: " << it->getValorTotal() << endl;
        // }
    }

    void localizar(Cliente &cliente)
    {
        string identificador;
        // cout << "\n\tDigite o identificador do aluguel: ";
        cin >> identificador;
        for (auto it = cliente.clientesCadastrados(cliente).begin(); it != cliente.clientesCadastrados(cliente).end(); it++)
        {
            if (it->getCPF() == identificador)
            {
                // cout << "Identificador: " << it->getIdentificador() << endl;
                // cout << "Veiculo: " << it->getVeiculo().getIdentificador() << endl;
                // cout << "Cliente: " << it->getCliente().getCPF() << endl;
                // // cout << "Funcionario: " << it->getFuncionario().getCPF() << endl;
                // cout << "Data Inicio: " << it->getDataInicio() << endl;
                // cout << "Data Termino: " << it->getDataTermino() << endl;
                // cout << "Data Devolucao: " << it->getDataDevolucao() << endl;
                // cout << "Desconto: " << it->getDesconto() << endl;
                // cout << "Adicional: " << it->getAdicional() << endl;
                // cout << "Valor Total: " << it->getValorTotal() << endl;
            }
        }
    }

    void cadastrar(Aluguel &aluguel)
    {
        // cliente.limpaTela();
        // cout << "\n\t==========CADASTRO DE ALUGUEL==========\n";
        // cout << "\n\tInforme o identificador do aluguel: ";
        getline(cin, identificador);

        // cout << "\n\tInforme o identificador do veiculo: ";
        // getline(cin, veiculo);

        // cout << "\n\tInforme o CPF do cliente: ";
        // getline(cin, cl);

        // cout << "\n\tInforme o CPF do funcionario: ";
        // getline(cin, funcionario);

        // cout << "\n\tInforme a data de inicio do aluguel: ";
        // getline(cin, dataInicio);

        // cout << "\n\tInforme a data de termino do aluguel: ";
        // getline(cin, dataTermino);

        // cout << "\n\tInforme a data de devolucao do aluguel: ";
        // getline(cin, dataDevolucao);

        // cout << "\n\tInforme o desconto do aluguel: ";
        // cin >> desconto;

        // cout << "\n\tInforme o adicional do aluguel: ";
        // cin >> adicional;

        // cout << "\n\tInforme o valor total do aluguel: ";
        // cin >> valorTotal;

        setAluguel(aluguel);
    }

    void editar(Aluguel &aluguel)
    {
        string identificador;
        // cout << "\n\tDigite o identificador do aluguel: ";
        cin >> identificador;
        for (auto it = alugueis.begin(); it != alugueis.end(); it++)
        {
            if (it->getIdentificador() == identificador)
            {
                // cout << "\n\t==========EDITAR ALUGUEL==========\n";
                // cout << "\n\tInforme o identificador do aluguel: ";
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
        }
    }

    void excluir()
    {
        string identificador;
        // cout << "\n\tDigite o identificador do aluguel: ";
        cin >> identificador;

        for (auto it = alugueis.begin(); it != alugueis.end(); it++)
        {
            if (it->getIdentificador() == identificador)
            {
                alugueis.erase(it);
            }
        }
    }

    // void alugar(Aluguel &aluguel, Veiculo &veiculo, Cliente &cliente, Funcionario &funcionario)
    //  {
    //      string identificador;
    //      cout << "\n\tDigite o identificador do veiculo: ";
    //      cin >> identificador;
    //      for (int i = 0; i < veiculo.getVeiculo().size(); i++)
    //      {
    //          if (veiculo.getVeiculo()[i].getIdentificador() == identificador)
    //          {
    //              cout << "\n\t==========ALUGAR VEICULO==========\n";
    //              cout << "\n\tInforme o identificador do aluguel: ";
    //              getline(cin, identificador);

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

    // void devolver(Aluguel &aluguel, Veiculo &veiculo, Cliente &cliente, Funcionario &funcionario)
    // {
    //     string identificador;
    //     cout << "\n\tDigite o identificador do veiculo: ";
    //     cin >> identificador;
    //     for (int i = 0; i < veiculo.getVeiculo().size(); i++)
    //     {
    //         if (veiculo.getVeiculo()[i].getIdentificador() == identificador)
    //         {
    //             cout << "\n\t==========DEVOLVER VEICULO==========\n";
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

//     void listarAlugueis(Aluguel &aluguel)
//     {
//         for (auto it = aluguel.alugueis.begin(); it != aluguel.alugueis.end(); it++)
//         {
//             cout << "Identificador: " << it->getIdentificador() << endl;
//             cout << "Veiculo: " << it->getVeiculo().getIdentificador() << endl;
//             cout << "Cliente: " << it->getCliente().getCPF() << endl;
//             // cout << "Funcionario: " << it->getFuncionario().getCPF() << endl;
//             cout << "Data Inicio: " << it->getDataInicio() << endl;
//             cout << "Data Termino: " << it->getDataTermino() << endl;
//             cout << "Data Devolucao: " << it->getDataDevolucao() << endl;
//             cout << "Desconto: " << it->getDesconto() << endl;
//             cout << "Adicional: " << it->getAdicional() << endl;
//             cout << "Valor Total: " << it->getValorTotal() << endl;
//         }
//     }

//     float calcularValorTotal()
//     {
//         float valorTotal = 0;
//         for (auto it = alugueis.begin(); it != alugueis.end(); it++)
//         {
//             valorTotal += it->getValorTotal();
//         }
//         return valorTotal;
//     }

//     void gerarRelatorio()
//     {
//         cout << "\n\t==========RELATORIO DE ALUGUEIS==========\n";
//         cout << "\n\tQuantidade de alugueis: " << alugueis.size() << endl;
//         cout << "\n\tValor total de alugueis: " << calcularValorTotal() << endl;
//     }

//     void gerarRelatorioPorData()
//     {
//         string dataInicio;
//         string dataTermino;
//         cout << "\n\t==========RELATORIO DE ALUGUEIS POR DATA==========\n";
//         cout << "\n\tInforme a data de inicio: ";
//         getline(cin, dataInicio);
//         cout << "\n\tInforme a data de termino: ";
//         getline(cin, dataTermino);
//         for (auto it = alugueis.begin(); it != alugueis.end(); it++)
//         {
//             if (it->getDataInicio() == dataInicio && it->getDataTermino() == dataTermino)
//             {
//                 cout << "Identificador: " << it->getIdentificador() << endl;
//                 cout << "Veiculo: " << it->getVeiculo().getIdentificador() << endl;
//                 cout << "Cliente: " << it->getCliente().getCPF() << endl;
//                 // cout << "Funcionario: " << it->getFuncionario().getCPF() << endl;
//                 cout << "Data Inicio: " << it->getDataInicio() << endl;
//                 cout << "Data Termino: " << it->getDataTermino() << endl;
//                 cout << "Data Devolucao: " << it->getDataDevolucao() << endl;
//                 cout << "Desconto: " << it->getDesconto() << endl;
//                 cout << "Adicional: " << it->getAdicional() << endl;
//                 cout << "Valor Total: " << it->getValorTotal() << endl;
//             }
//         }
//     }

//     void gerarRelatorioPorVeiculo()
//     {
//         string identificador;
//         cout << "\n\t==========RELATORIO DE ALUGUEIS POR VEICULO==========\n";
//         cout << "\n\tInforme o identificador do veiculo: ";
//         getline(cin, identificador);
//         for (auto it = alugueis.begin(); it != alugueis.end(); it++)
//         {
//             if (it->getVeiculo().getIdentificador() == identificador)
//             {
//                 cout << "Identificador: " << it->getIdentificador() << endl;
//                 cout << "Veiculo: " << it->getVeiculo().getIdentificador() << endl;
//                 cout << "Cliente: " << it->getCliente().getCPF() << endl;
//                 // cout << "Funcionario: " << it->getFuncionario().getCPF() << endl;
//                 cout << "Data Inicio: " << it->getDataInicio() << endl;
//                 cout << "Data Termino: " << it->getDataTermino() << endl;
//                 cout << "Data Devolucao: " << it->getDataDevolucao() << endl;
//                 cout << "Desconto: " << it->getDesconto() << endl;
//                 cout << "Adicional: " << it->getAdicional() << endl;
//                 cout << "Valor Total: " << it->getValorTotal() << endl;
//             }
//         }
//     }

//     void gerarRelatorioPorCliente()
//     {
//         string cpf;
//         cout << "\n\t==========RELATORIO DE ALUGUEIS POR CLIENTE==========\n";
//         cout << "\n\tInforme o CPF do cliente: ";
//         getline(cin, cpf);
//         for (auto it = alugueis.begin(); it != alugueis.end(); it++)
//         {
//             if (it->getCliente().getCPF() == cpf)
//             {
//                 cout << "Identificador: " << it->getIdentificador() << endl;
//                 cout << "Veiculo: " << it->getVeiculo().getIdentificador() << endl;
//                 cout << "Cliente: " << it->getCliente().getCPF() << endl;
//                 // cout << "Funcionario: " << it->getFuncionario().getCPF() << endl;
//                 cout << "Data Inicio: " << it->getDataInicio() << endl;
//                 cout << "Data Termino: " << it->getDataTermino() << endl;
//                 cout << "Data Devolucao: " << it->getDataDevolucao() << endl;
//                 cout << "Desconto: " << it->getDesconto() << endl;
//                 cout << "Adicional: " << it->getAdicional() << endl;
//                 cout << "Valor Total: " << it->getValorTotal() << endl;
//             }
//         }
//     }
};

#endif