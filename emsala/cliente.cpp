#include <iostream>
#include <vector>
#include <ctime>
#include <cmath>

using namespace std;

void limparTela();

struct MinhaData
{
    int dia, mes, ano;

    void lerData()
    {
        do
        {
            cout << "\nInforme o dia: ";
            cin >> dia;

            cout << "\nInforme o mes: ";
            cin >> mes;

            cout << "\nInforme o ano: ";
            cin >> ano;
        } while (!validaData());
    }

    void mostraData()
    {
        printf("%02d/%02d/%4d  ", dia, mes, ano);
        cout << diaDaSemana() << endl;
    }

    int anosCompletos()
    {
        time_t now;
        time(&now);
        struct tm *local = localtime(&now);
        int diaAtual = local->tm_mday;
        int mesAtual = local->tm_mon + 1;
        int anoAtual = local->tm_year + 1900;
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

    bool validaData()
    {

        int meses[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (ano % 4 == 0 || (ano % 100 == 0 && ano % 400 == 0))
        {
            meses[1] = 29;
        }

        {
            if (dia > 31 || dia < 1 || mes > 12 || mes < 1 || ano < 1)
            {
                limparTela();
                cout << "\nData invalida!" << endl;
                return false;
            }

            if (dia > meses[mes - 1])
            {
                limparTela();
                cout << "\nData invalida!" << endl;
                return false;
            }

            return true;
        }
    }
    
    string diaDaSemana()
    {

        int ds;
        int g;
        int f;
        int delta;
        int n;
        float frac;
        float intpart;

        if (mes > 2)
        {
            g = ano;
            f = mes + 1;
        }
        else if (mes <= 2)
        {
            g = ano - 1;
            f = mes + 13;
        }

        n = int(365.25 * g) + int(30.6 * f) - 621049 + dia;

        if (n < 36523)
        {
            delta = 2;
        }
        else if (36523 <= n and n < 73048)
        {
            delta = 1;
        }
        else if (n >= 73048)
        {
            delta = 0;
        }

        frac = modf((float)n / 7, &intpart);

        ds = round(frac * 7) + delta + 1;

        switch (ds)
        {
        case 1:
            return "domingo";
        case 2:
            return "segunda-feira";
        case 3:
            return "terca-feira";
        case 4:
            return "quarta-feira";
        case 5:
            return "quinta-feira";
        case 6:
            return "sexta-feira";
        case 7:
            return "sabado";
        }

        return "dia invalido";
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
    MinhaData dataNascimento;

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

    void mostraDadosCliente(int j)
    {
        int i = 1;

        cout << "\n"
             << j << "º CLIENTE";
        cout << "\nNome do Cliente: " << nome << endl;
        cout << "Sobrenome: " << sobrenome << endl;
        cout << "CPF do Cliente: " << cpf << endl;
        cout << "Data de Nascimento: ";
        dataNascimento.mostraData();

        for (auto it = veiculos.begin(); it != veiculos.end(); it++, i++)
        {
            cout << "\n"
                 << i << "º VEICULO";
            cout << "\nModelo do Carro: " << it->modelo << endl;
            cout << "Cor do veiculo: " << it->cor << endl;
            cout << "Placa do veiculo: " << it->placa << endl;
            cout << "Data de Registro: ";
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

        lerDataNascimento();

        if (dataNascimento.anosCompletos() >= 18)
        {
            limparTela();
            cout << "\n==========CADASTRO DE VEICULO==========\n";

            cout << "\nInforme a quantidade de veiculos: ";
            cin >> quantidadeDeCarros;
            cin.get();

            for (int i = 0; i < quantidadeDeCarros; i++)
            {
                veiculo.cadastraVeiculo(i + 1);
                veiculos.push_back(veiculo);
                limparTela();
            }
        }
    }

    void lerDataNascimento()
    {
        limparTela();
        cout << "\n==========DATA DE NASCIMENTO==========\n";

        dataNascimento.lerData();
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
    cout << "\nDigite enter para continuar!...\n";
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
        it->mostraDadosCliente(i);
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
            it->mostraDadosCliente(i);
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