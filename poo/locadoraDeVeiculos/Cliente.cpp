#include "Cliente.h"
#include <iostream>
#include <vector>

using namespace std;

vector<Cliente> clientes;

Cliente::Cliente() {}

Cliente::~Cliente() {}

Cliente::Cliente(string nome, string cpf, string endereco, string telefone, string habilitacao)
{
  Usuario(nome, cpf, endereco, telefone);
  this->habilitacao = habilitacao;
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
  // cliente.setNome(nome);

  cout << "\n\tInforme o CPF: ";
  getline(cin, cpf);
  // cliente.setCPF(cpf);

  cout << "\n\tInforme o número da habilitação: ";
  getline(cin, habilitacao);
  // cliente.setHabilitacao(habilitacao);

  cout << "\n\tInforme o endereço: ";
  getline(cin, endereco);
  // cliente.setEndereco(endereco);

  cout << "\n\tInforme o telefone: ";
  getline(cin, telefone);
  // cliente.setTelefone(telefone);

  // cliente.setCliente(cliente);

  Cliente cliente(nome, cpf, endereco, telefone, habilitacao);

  clientes.push_back(cliente);

  return cliente;
}

void Cliente::listar()
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

const string Cliente::editar(Cliente &cliente)
{
  string nome;
  string cpf;
  string endereco;
  string telefone;
  string habilitacao;
  bool encontrou = false;

  do
  {
    limpaTela();
    cout << "\n\tInforme o cpf do cliente, para edição: ";
    getline(cin, cpf);

    for (auto it = cliente.clientes.begin(); it != cliente.clientes.end(); it++)
    {
      if (it->getCPF() == cpf)
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

        cliente.clientes.push_back(cliente);
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

string Cliente::excluir(Cliente &cliente)
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

string Cliente::verificaCliente(string cpf)
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

void Cliente::localizar()
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

void Cliente::limpaBuffer()
{
  cin.get();
}

void Cliente::limpaTela()
{
#ifdef _WIN32
  system("cls");
#else
  system("clear");
#endif
}

void Cliente::pause()
{
  cout << "\n\tDigite enter para continuar!...\n";
  cin.get();
  limpaTela();
}