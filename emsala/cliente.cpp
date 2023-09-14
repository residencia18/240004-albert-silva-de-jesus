#include <iostream>
#include <vector>

using namespace std;

typedef struct
{
    string placa;
    string modelo;
    string cor;

} Veiculo;

typedef struct
{
    string nome;
    string cpf;
    vector<Veiculo> veiculos;

} Cliente;

int menu();

void pause();

void limparTela();

void lerCliente(Cliente &cliente);

void lerNome(Cliente &cliente);

void lerCpf(Cliente &cliente);

void mostraDadosCliente(Cliente cliente);

void cadastraCliente(vector<Cliente> &listCliente);

void cadastraCarro(Veiculo &veiculo, int i);

void listarClientes(vector<Cliente> &listCliente);

void buscarCliente(vector<Cliente> &listCliente);

void removerCliente(vector<Cliente> &listCliente);

Cliente retornarCliente(vector<Cliente> &listCliente);

int main()
{

    vector<Cliente> listCliente;
    int escolha = 0;

    do
    {
        switch (escolha = menu())
        {

        case 1:

            cadastraCliente(listCliente);

            break;

        case 2:

            buscarCliente(listCliente);

            break;

        case 3:

            removerCliente(listCliente);

            break;

        case 4:

            listarClientes(listCliente);

            break;

        case 0:

            cout << "\nPrograma encerrado com sucesso!..." << endl;
            exit(0);

        default:
            cout << "Opção invalida!";
        }

    }while (escolha != 0);
}

int menu()
{
    limparTela();
    int opcao = 0;

    do
    {
        cout << "\n===============MENU===============";
        cout << "\n[1] - NOVO CLIENTE:";
        cout << "\n[2] - ENCONTRAR CLIENTE:";
        cout << "\n[3] - EXCLUIR CLIENTE:";
        cout << "\n[4] - LISTAR TODOS OS CLIENTES:";
        cout << "\n[0] - SAIR";
        cout << "\nENTRADA ->  ";
        cin >> opcao;
        cin.get();

        if (opcao > 4 || opcao < 0)
        {
            limparTela();
            cout << "Ops, escolha invalida!...\n";
            pause();
        }

    } while (opcao > 4 || opcao < 0);

    return opcao;
}

void lerCliente(Cliente &cliente)
{
    limparTela();
    Veiculo veiculo;
    int quantidadeDeCarros = 0;

    cout << "\n================CLIENTE=================\n";

    lerNome(cliente);

    lerCpf(cliente);

    cout << "\nInforme quantos carros você tem? ";
    cin >> quantidadeDeCarros;
    cin.get();

    for (int i = 0; i < quantidadeDeCarros; i++)
    {

        cadastraCarro(veiculo, i + 1);

        cliente.veiculos.push_back(veiculo);
        limparTela();
    }
}

void mostraDadosCliente(Cliente cliente)
{
    // limparTela();
    int i = 1;
    
    for (auto it = cliente.veiculos.begin(); it != cliente.veiculos.end(); it++, i++)
    {
        cout << "\n" << i << "º VEICULO";
        cout << "\nModelo do Carro: " << it->modelo << endl;
        cout << "\nCor do veiculo: " << it->cor << endl;
        cout << "\nPlaca do veiculo: " << it->placa << endl;
    }
    
}

void pause()
{
    cout << "Digite enter para continuar!";
    cin.get();
    limparTela();
}

void limparTela()
{
    #ifdef _WIN32
        system("cls");
    #else
        system("clear");
    #endif
}

void cadastraCarro(Veiculo &veiculo, int i)
{
    limparTela();
    cout << "\n==========CADASTRO DE VEICULO==========\n"
         << endl;

    cout << i << "º Veiculo";
    cout << "\nInforme o modelo do veículo:";
    cin >> veiculo.modelo;

    cout << "\nInforme a cor do veículo:";
    cin >> veiculo.cor;

    cout << "\nInforme a placa do veiculo:";
    cin >> veiculo.placa;
}

void cadastraCliente(vector<Cliente> &listCliente)
{
    Cliente cliente;
    lerCliente(cliente);
    listCliente.push_back(cliente);
}

void listarClientes(vector<Cliente> &listCliente)
{
    limparTela();
    int i = 1;
    cout << "\n==========LISTA DE CLIENTES===========\n";

    for (auto it = listCliente.begin(); it != listCliente.end(); it++, i++)
    {
        cout << "\n" << i << "º Cliente";
        cout << "\n======================================";
        cout << "\nNome do Cliente: " << it->nome << endl;
        cout << "\nCPF do Cliente: " << it->cpf << endl;
        mostraDadosCliente(*it);
        cout << "======================================\n";
    }
    pause();
}

void buscarCliente(vector<Cliente> &listCliente)
{
    limparTela();
    string cpf;
    int i = 1;

    cout << "Informe o CPF para consulta: ";
    getline(cin, cpf);

    for (auto it = listCliente.begin(); it != listCliente.end(); ++it, i++)
    {
        if (it->cpf == cpf)
        {
            mostraDadosCliente(*it);
            pause();
            return;
        }
    }

    limparTela();
    cout << "\nCliente não encontrado!...\n";
    pause();
}

void removerCliente(vector<Cliente> &listCliente)
{
    limparTela();
    string cpf;
    int i = 1;

    cout << "\n===============REMOVER CLIENTE============\n";
    cout << "\nInforme o CPF para remoção: ";
    getline(cin, cpf);

    for (auto it = listCliente.begin(); it != listCliente.end(); ++it, i++)
    {
        if (it->cpf == cpf)
        {
            listCliente.erase(it);
            cout << "\nCliente removido com sucesso!...\n";
            pause();
            return;
        }
    }

    limparTela();
    cout << "\nCliente não encontrado!...\n";
    pause();
}

void lerNome(Cliente &cliente)
{
    cout << "\nInforme o nome do cliente: ";
    getline(cin, cliente.nome);
}

void lerCpf(Cliente &cliente)
{
    cout << "\nInforme o cpf: ";
    cin >> cliente.cpf;
}