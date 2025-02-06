#ifndef VEICULO_H
#define VEICULO_H
#include <iostream>
#include <vector>
#include <string>
using namespace std;

#pragma once

class Veiculo
{
private:
    string identificador;
    string modelo;
    string marca;
    int anoFabricacao;
    float valorDiaria;

public:
    vector<Veiculo> veiculos;

    Veiculo() {}

    ~Veiculo() {}

    void setIdentificador(string identificador)
    {
        this->identificador = identificador;
    }

    string getIdentificador()
    {
        return this->identificador;
    }

    void setModelo(string modelo)
    {
        this->modelo = modelo;
    }

    string getModelo()
    {
        return this->modelo;
    }

    void setMarca(string marca)
    {
        this->marca = marca;
    }

    string getMarca()
    {
        return this->marca;
    }

    void setAnoFabricacao(int anoFabricacao)
    {
        this->anoFabricacao = anoFabricacao;
    }

    int getAnoFabricacao()
    {
        return this->anoFabricacao;
    }

    void setValorDiaria(float valorDiaria)
    {
        this->valorDiaria = valorDiaria;
    }

    float getValorDiaria()
    {
        return this->valorDiaria;
    }

    void setVeiculo(Veiculo veiculo)
    {
        this->veiculos.push_back(veiculo);
    }

    vector<Veiculo> getVeiculo()
    {
        return this->veiculos;
    }

    Veiculo cadastrar(Veiculo &veiculo)
    {
        limpaTela();
        cout << "\n\t==========CADASTRO DE VEICULO==========\n";
        cout << "\n\tInforme o identificador do veiculo: ";
        getline(cin, identificador);
        veiculo.setIdentificador(identificador);

        cout << "\n\tInforme o modelo do veiculo: ";
        getline(cin, modelo);
        veiculo.setModelo(modelo);

        cout << "\n\tInforme a marca do veiculo: ";
        getline(cin, marca);
        veiculo.setMarca(marca);

        cout << "\n\tInforme o ano de fabricação do veiculo: ";
        cin >> anoFabricacao;
        veiculo.setAnoFabricacao(anoFabricacao);

        cout << "\n\tInforme o valor da diaria do veiculo: ";
        cin >> valorDiaria;
        veiculo.setValorDiaria(valorDiaria);

        setVeiculo(veiculo);

        return veiculo;
    }

    void listar()
    {
        limpaTela();
        cout << "\n\t==========LISTAGEM DE VEICULOS==========\n";
        for (auto it = veiculos.begin(); it != veiculos.end(); it++)
        {
            cout << "\n\tIdentificador: " << it->identificador;
            cout << "\n\tModelo: " << it->modelo;
            cout << "\n\tMarca: " << it->marca;
            cout << "\n\tAno de fabricação: " << it->anoFabricacao;
            cout << "\n\tValor da diaria: " << it->valorDiaria;
            cout << "\n\t========================================\n";
        }
        pause();
    }

    string excluir(Veiculo &veiculo)
    {
        string identificador;
        bool encontrou = true;

        do
        {
            limpaTela();
            cout << "\n\t==========EXCLUSÃO DE VEICULO==========\n";
            cout << "\n\tInforme o identificador do veiculo: ";
            getline(cin, identificador);

            for (auto it = veiculo.veiculos.begin(); it != veiculo.veiculos.end(); it++)
            {
                if (it->identificador == identificador)
                {
                    cout << "\n\tVeiculo com o identificador: " << it->identificador << " excluido com sucesso!...\n";
                    pause();
                    veiculos.erase(it);
                    encontrou = false;
                    break;
                }
            }

            if (encontrou)
            {
                limpaTela();
                cout << "\n\tVeiculo não encontrado!...\n";
                pause();
            }
            else
            {
                listar();
                return identificador;
            }

        } while (encontrou);

        return identificador;
    }

    void editar()
    {
        string identificador;
        bool encontrou = false;

        do
        {
            limpaTela();
            cout << "\n\t==========EDIÇÃO DE VEICULO==========\n";
            cout << "\n\tInforme o identificador do veiculo: ";
            getline(cin, identificador);

            for (auto it = veiculos.begin(); it != veiculos.end(); it++)
            {
                if (it->identificador == identificador)
                {
                    cout << "\n\tInforme o novo identificador do veiculo: ";
                    getline(cin, it->identificador);

                    cout << "\n\tInforme o novo modelo do veiculo: ";
                    getline(cin, it->modelo);

                    cout << "\n\tInforme a nova marca do veiculo: ";
                    getline(cin, it->marca);

                    cout << "\n\tInforme o novo ano de fabricação do veiculo: ";
                    cin >> it->anoFabricacao;
                    limpaBuffer();

                    cout << "\n\tInforme o novo valor da diaria do veiculo: ";
                    cin >> it->valorDiaria;
                    limpaBuffer();

                    encontrou = true;
                    break;
                }
            }

            if (!encontrou)
            {
                cout << "\n\tVeiculo não encontrado!...\n";
                pause();
            }
            else
            {
                cout << "\n\tVeiculo editado com sucesso!...\n";
                pause();
                listar();
            }

        } while (!encontrou);
    }

    void localizar()
    {
        string identificador;
        bool encontrou = true;

        do
        {
            limpaTela();
            cout << "\n\t==========LOCALIZAÇÃO DE VEICULO==========\n";
            cout << "\n\tInforme o identificador do veiculo: ";
            getline(cin, identificador);

            for (auto it = veiculos.begin(); it != veiculos.end(); it++)
            {
                if (it->identificador == identificador)
                {
                    limpaTela();
                    cout << "\n\t==========VEICULO ENCONTRADO==========\n";
                    cout << "\n\tIdentificador: " << it->identificador;
                    cout << "\n\tModelo: " << it->modelo;
                    cout << "\n\tMarca: " << it->marca;
                    cout << "\n\tAno de fabricação: " << it->anoFabricacao;
                    cout << "\n\tValor da diaria: " << it->valorDiaria;
                    cout << "\n\t========================================\n";
                    pause();
                    encontrou = false;
                    break;
                }
            }

            if (encontrou)
            {
                cout << "\n\tVeiculo não encontrado!...\n";
                pause();
            }

        } while (encontrou);
    }

    string verificaVeiculo(string identificador)
    {
        bool existe = false;
        char opcao;

        do
        {
            limpaTela();
            cout << "\n\t==========VERIFICAÇÃO DE VEICULO==========\n";
            cout << "\n\tInforme o identificador do veiculo: ";
            getline(cin, identificador);

            for (auto it = veiculos.begin(); it != veiculos.end(); it++)
            {
                if (it->identificador == identificador)
                {
                    return identificador;
                }
            }

            if (!existe)
            {
                limpaTela();
                cout << "\n\tOps, veiculo não encontrado!..." << endl;
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
                        return identificador;
                    }

                } while (opcao != 's' && opcao != 'S' && opcao != 'n' && opcao != 'N');
            }
            else
            {
                listar();
            }

        } while (existe);

        return identificador;
    }

    vector<Veiculo>::iterator localizarVeiculo(string identificador)
    {
        for (auto it = veiculos.begin(); it != veiculos.end(); it++)
        {
            if (it->identificador == identificador)
            {
                return it;
            }
        }
        return veiculos.end();
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

private:
};

#endif