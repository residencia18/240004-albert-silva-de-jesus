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

void pause();

void limparTela();

int main()
{

    vector<Cliente> listCliente;

    while (1)
    {
        int escolha = menu();

        switch (escolha)
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
    }
}

int menu()
{
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
        system("clear");

        if (opcao > 4 || opcao < 0)
        {

            cout << "Ops, escolha invalida!...\n";
            pause();
        }

    } while (opcao > 4 || opcao < 0);

    return opcao;
}

void lerCliente(Cliente &cliente)
{
    Veiculo veiculo;
    int quantidadeDeCarros = 0;

    cout << "\n================CLIENTE=================\n";

    lerNome(cliente);

    lerCpf(cliente);

    cout << "\nInforme quantos carros você tem? ";
    cin >> quantidadeDeCarros;

    for (int i = 0; i < quantidadeDeCarros; i++)
    {

        cadastraCarro(veiculo, i + 1);

        cliente.veiculos.push_back(veiculo);
        limparTela();
    }
}

void mostraDadosCliente(Cliente cliente)
{
    cout << "\nNome: " << cliente.nome << endl;
    cout << "CPF: " << cliente.cpf << endl;

    for (auto it = cliente.veiculos.begin(); it != cliente.veiculos.end(); it++)
    {

        cout << "\nModelo do Carro: " << it->modelo << endl;
        cout << "\nCor do veiculo: " << it->cor << endl;
        cout << "\nPlaca do veiculo: " << it->placa << endl;
    }
    cout << "\n======================================\n";
}

void pause()
{
    cout << "Digite enter para continuar!";
    cin.get();
    getchar();
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

    int i = 1;
    cout << "\n===============LISTA DE CLIENTES============\n";

    for (auto it = listCliente.begin(); it != listCliente.end(); ++it, i++)
    {
        mostraDadosCliente(*it);
    }
    pause();
}

void buscarCliente(vector<Cliente> &listCliente)
{

    string cpf;
    int i = 1;

    cout << "Informe o CPF para consulta: ";
    cin.get();
    getline(cin, cpf);
    limparTela();

    for (auto it = listCliente.begin(); it != listCliente.end(); ++it, i++)
    {
        if (it->cpf == cpf)
        {
            mostraDadosCliente(*it);
            cout << "\n======================================\n";
            pause();
            return;
        }
    }

    cout << "\nCliente não encontrado!...";
    pause();
}

void removerCliente(vector<Cliente> &listCliente)
{

    string cpf;
    int i = 1;

    cout << "\n===============REMOVER CLIENTE============\n";
    cout << "\nInforme o CPF para remoção: ";
    cin.get();
    getline(cin, cpf);
    limparTela();

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

    cout << "\nCliente não encontrado!...\n";
    pause();
}

void lerNome(Cliente &cliente)
{

    cout << "\nInforme o nome do cliente: ";
    cin.get();
    getline(cin, cliente.nome);
}

void lerCpf(Cliente &cliente)
{

    cout << "\nInforme o cpf: ";
    cin >> cliente.cpf;
}