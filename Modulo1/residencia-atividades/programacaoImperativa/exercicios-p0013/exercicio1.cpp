/*Exercício 1:
Uma empresa de ônibus faz diariamente 5 viagens de ida e 5 viagens de volta entre as cidades do Rio de Janeiro e São Paulo. Cada ônibus tem 40 assentos para serem preenchidos por passageiros. A empresa costuma vender as passagens antecipadamente, e para cada passagem vendida é anotado o número do assento, a data e hora, o CPF, o nome e a idade do passageiro. As passagens são vendidas por 80 reais cada. Faça um programa para gerenciar a venda de passagens de ônibus. O programa deve possibilitar obter as seguintes informações:

1. Qual o total arrecadado para uma determinada viagem.
2. Qual o total arrecadado em um determinado mês.
3. Qual o nome do passageiro de uma determinada poltrona P de uma determinada viagem.
4. Qual o horário de viagem mais rentável.
5. Qual a média de idade dos passageiros.*/

#include <iostream>
#include <string>
using namespace std;

struct Passageiro
{
    string nome;
    string cpf;
    int idade;
};

struct Viagem
{
    string data;
    string hora;
    Passageiro poltronas[40];
};

struct Empresa
{
    Viagem viagens[10];
};

int main()
{
    Empresa empresa;
    int opcao, viagem, poltrona, mes, total, soma, media, maior, hora, minuto;
    string nome;

    for (int i = 0; i < 10; i++)
    {
        cout << "Digite a data da viagem " << i + 1 << ": ";
        cin >> empresa.viagens[i].data;
        cout << "Digite a hora da viagem " << i + 1 << ": ";
        cin >> empresa.viagens[i].hora;
        for (int j = 0; j < 10; j++)
        {
            cout << "Digite o nome do passageiro " << j + 1 << ": ";
            cin >> empresa.viagens[i].poltronas[j].nome;
            cout << "Digite o CPF do passageiro " << j + 1 << ": ";
            cin >> empresa.viagens[i].poltronas[j].cpf;
            cout << "Digite a idade do passageiro " << j + 1 << ": ";
            cin >> empresa.viagens[i].poltronas[j].idade;
        }
    }

    do
    {
        cout << "1. Qual o total arrecadado para uma determinada viagem." << endl;
        cout << "2. Qual o total arrecadado em um determinado mês." << endl;
        cout << "3. Qual o nome do passageiro de uma determinada poltrona P de uma determinada viagem." << endl;
        cout << "4. Qual o horário de viagem mais rentável." << endl;
        cout << "5. Qual a média de idade dos passageiros." << endl;
        cout << "0. Sair" << endl;
        cout << "Digite a opção desejada: ";
        cin >> opcao;

        switch (opcao)
        {
        case 1:
            cout << "Digite o número da viagem: ";
            cin >> viagem;
            total = 0;
            for (int i = 0; i < 40; i++)
            {
                total += 80;
            }
            cout << "O total arrecadado para a viagem " << viagem << " foi de R$" << total << endl;
            break;
        case 2:
            cout << "Digite o mês: ";
            cin >> mes;
            total = 0;
            for (int i = 0; i < 10; i++)
            {
                if (stoi(empresa.viagens[i].data.substr(3, 2)) == mes)
                {
                    for (int j = 0; j < 40; j++)
                    {
                        total += 80;
                    }
                }
            }
            cout << "O total arrecadado no mês " << mes << " foi de R$" << total << endl;
            break;
        case 3:
            cout << "Digite o número da viagem: ";
            cin >> viagem;
            cout << "Digite o número da poltrona: ";
            cin >> poltrona;
            cout << "O nome do passageiro da poltrona " << poltrona << " da viagem " << viagem << " é " << empresa.viagens[viagem - 1].poltronas[poltrona - 1].nome << endl;
            break;
        case 4:
            maior = 0;
            for (int i = 0; i < 10; i++)
            {
                soma = 0;
                for (int j = 0; j < 40; j++)
                {
                    soma += 80;
                }
                if (soma > maior)
                {
                    maior = soma;
                    hora = stoi(empresa.viagens[i].hora.substr(0, 2));
                    minuto = stoi(empresa.viagens[i].hora.substr(3, 2));
                }
            }
            cout << "O horário de viagem mais rentável é " << hora << ":" << minuto << endl;
            break;
        case 5:
            soma = 0;
            for (int i = 0; i < 10; i++)
            {
                for (int j = 0; j < 40; j++)
                {
                    soma += empresa.viagens[i].poltronas[j].idade;
                }
            }
            media = soma / 400;
            cout << "A média de idade dos passageiros é " << media << endl;
            break;
        case 0:
            cout << "Saindo..." << endl;
            break;
        default:
            cout << "Opção inválida!" << endl;
            break;
        }
    } while (opcao != 0);

    return 0;
}
