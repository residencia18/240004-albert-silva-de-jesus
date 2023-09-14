#include <iostream>
#include <vector>
#include <ctime>

using namespace std;

void limparTela();

struct MinhaData
{
    int dia, mes, ano;

    void lerData()
    {
        cout << "\n==========DATA DE REGISTRO==========\n";

        cout << "\nInforme o dia: ";
        cin >> dia;

        cout << "\nInforme o mes: ";
        cin >> mes;

        cout << "\nInforme o ano: ";
        cin >> ano;
    }

    void mostraData()
    {
        printf("%02d/%02d/%4d\n", dia, mes, ano);
    }

    int anosCompletos()
    {

        int anoAtual = 2023;
        int mesAtual = 9;
        int diaAtual = 11;
        int x = anoAtual - ano;

        if (mesAtual < mes)
        {
            x--;
        }
        else
        {
            if (mes == mesAtual && dia < diaAtual)
            {
                x--;
            }
        }
        return x;
    }
};

typedef struct
{
    string placa;
    string modelo;
    string cor;
    MinhaData dataRegistro;

    void cadastraVeiculo(int i)
    {
        limparTela();
        cout << "\n==========CADASTRO DE VEICULO==========\n"
             << endl;

        cout << i << "º Veiculo";
        cout << "\nInforme o modelo do veículo: ";
        cin >> modelo;

        cout << "\nInforme a cor do veículo: ";
        cin >> cor;

        cout << "\nInforme a placa do veiculo: ";
        cin >> placa;

        dataRegistro.lerData();
    }

} Veiculo;

typedef struct
{
    string nome;
    string sobrenome;
    string cpf;
    vector<Veiculo> veiculos;

    void lerNome()
    {
        cout << "\nInforme o nome do cliente: ";
        getline(cin, nome);
    }

    void lerSobrenome()
    {

        cout << "\nInforme o sobrenome: ";
        getline(cin, sobrenome);
    }

    void lerCpf()
    {
        cout << "\nInforme o cpf: ";
        cin >> cpf;
    }

    void mostraDadosCliente()
    {
        limparTela();
        int i = 1;

        cout << "\n======================================";
        cout << "\nNome do Cliente: " << nome << endl;
        cout << "\nSobrenome: " << sobrenome << endl;
        cout << "\nCPF do Cliente: " << cpf << endl;

        for (auto it = veiculos.begin(); it != veiculos.end(); it++, i++)
        {
            cout << "\n"
                 << i << "º VEICULO";
            cout << "\nModelo do Carro: " << it->modelo << endl;
            cout << "\nCor do veiculo: " << it->cor << endl;
            cout << "\nPlaca do veiculo: " << it->placa << endl;
            cout << "\nData de Registro: ";
            it->dataRegistro.mostraData();
        }
    }

    void lerCliente()
    {
        limparTela();
        Veiculo veiculo;
        int quantidadeDeCarros = 0;

        cout << "\n================CLIENTE=================\n";

        lerNome();

        lerSobrenome();

        lerCpf();

        cout << "\nInforme quantos carros você tem? ";
        cin >> quantidadeDeCarros;
        cin.get();

        for (int i = 0; i < quantidadeDeCarros; i++)
        {
            veiculo.cadastraVeiculo(i + 1);
            veiculos.push_back(veiculo);
            limparTela();
        }
    }

} Cliente;

int menu();

void pause();

void cadastraCliente(vector<Cliente> &listCliente);

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

    } while (escolha != 0);
}

int menu()
{
    limparTela();
    int opcao = 0;

    do
    {
        time_t now;
        time(&now);
        struct tm *local = localtime(&now);
        int dia = local->tm_mday;
        int mes = local->tm_mon + 1;
        int ano = local->tm_year + 1900;

        printf("Hoje é dia %2d/%02d/%2d", dia, mes, ano);
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

void cadastraCliente(vector<Cliente> &listCliente)
{
    Cliente cliente;
    cliente.lerCliente();
    listCliente.push_back(cliente);
}

void listarClientes(vector<Cliente> &listCliente)
{
    limparTela();
    int i = 1;
    cout << "\n==========LISTA DE CLIENTES===========\n";

    for (auto it = listCliente.begin(); it != listCliente.end(); it++, i++)
    {
        cout << "\n"
             << i << "º Cliente";
        cout << "\n======================================";
        cout << "\nNome do Cliente: " << it->nome << endl;
        cout << "\nSobrenome: " << it->sobrenome << endl;
        cout << "\nCPF do Cliente: " << it->cpf << endl;
        it->mostraDadosCliente();
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
            it->mostraDadosCliente();
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