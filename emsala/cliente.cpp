#include <iostream>
#include <vector>
#include <ctime>
#include <cmath>

using namespace std;

void limparTela();

struct MinhaData
{
    int dia, mes, ano;

    tm *getTempo()
    {
        time_t t;
        time(&t);
        struct tm *data;
        data = localtime(&t);
        return data;
    }

    void mostraDataAtual()
    {
        struct tm *local = getTempo();
        int dia = local->tm_mday;
        int mes = local->tm_mon + 1;
        int ano = local->tm_year + 1900;
        int diaSemana = local->tm_wday;
        int diaAno = local->tm_yday;
        int hora = local->tm_hour;
        int minutos = local->tm_min;
        int segundos = local->tm_sec;

        printf("\n\tDATA: %02d/%02d/%4d, %s\n ", dia, mes, ano, diaDaSemana().c_str());
        printf("\tHORÁRIO: %02d:%02d:%02d\n", hora, minutos, segundos);
        printf("\n");
        // cout << "Dia do ano: " << diaAno << endl;
    }

    void lerData()
    {
        do
        {
            cout << "\n\tInforme o dia: ";
            cin >> dia;

            cout << "\n\tInforme o mes: ";
            cin >> mes;

            cout << "\n\tInforme o ano: ";
            cin >> ano;
        } while (!validaData());
    }

    void mostraData()
    {
        printf("%02d/%02d/%4d\n", dia, mes, ano);
        // cout << diaDaSemana() << " Horário: " << hora << ":" << minutos << ":" << segundos <<  endl;
    }

    int anosCompletos()
    {
        struct tm *local = getTempo();
        int diaAtual = local->tm_mday;
        int mesAtual = local->tm_mon + 1;
        int x = (local->tm_year + 1900) - ano;

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

    bool bissexto()
    {
        if (ano % 4 == 0 && ano % 100 != 0)
        {
            return true;
        }
        else
        {
            if (ano % 400 == 0)
            {
                return true;
            }
        }
        return false;
    }

    bool validaData()
    {
        limparTela();

        if (ano < 0)
        {
            cout << "\n\tOps, Ano invalido!...\n";
            return false;
        }

        if (mes < 1 || mes > 12)
        {
            cout << "\n\tOps, Mes invalido!...\n";
            return false;
        }

        if (dia < 1 || dia > 31)
        {
            cout << "\n\tOps, Dia invalido!...\n";
            return false;
        }

        if (mes == 2)
        {
            if (bissexto())
            {
                if (dia > 29)
                {
                    cout << "\n\tOps, Dia invalido!...\n";
                    return false;
                }
            }
            else
            {
                if (dia > 28)
                {
                    cout << "\n\tOps, Dia invalido!...\n";
                    return false;
                }
            }
        }

        if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
        {
            if (dia > 30)
            {
                cout << "\n\tOps, Dia invalido!...\n";
                return false;
            }
        }

        return true;
    }

    string diaDaSemana()
    {
        struct tm *data = getTempo();
        ;
        int diaDaSemana = data->tm_wday;

        switch (diaDaSemana)
        {
        case 0:
            return "DOMINGO";
        case 1:
            return "SEGUNDA-FEIRA";
        case 2:
            return "TERÇA-FEIRA";
        case 3:
            return "QUARTA-FEIRA";
        case 4:
            return "QUINTA-FEIRA";
        case 5:
            return "SEXTA-FEIRA";
        case 6:
            return "SABADO";
        }
        return "ERRO";
    }
};

struct Veiculo
{
    string placa;
    string modelo;
    string cor;
    MinhaData dataRegistro;

    void cadastraVeiculo(int i)
    {
        limparTela();
        dataRegistro.mostraDataAtual();

        cout << "\t==========CADASTRO DE VEICULO==========\n"
             << endl;

        cout << "\t" << i << "º Veiculo";
        cout << "\n\tInforme o modelo do veículo: ";
        cin >> modelo;

        cout << "\n\tInforme a cor do veículo: ";
        cin >> cor;

        cout << "\n\tInforme a placa do veiculo: ";
        cin >> placa;

        dataRegistro.lerData();
    }

};

struct Cliente
{
    string nome;
    string sobrenome;
    string cpf;
    vector<Veiculo> veiculos;
    MinhaData dataNascimento;

    void lerNome()
    {
        cout << "\n\tInforme o nome do cliente: ";
        getline(cin, nome);
    }

    void lerSobrenome()
    {
        cout << "\n\tInforme o sobrenome: ";
        getline(cin, sobrenome);
    }

    void lerCpf()
    {
        cout << "\n\tInforme o cpf: ";
        cin >> cpf;
    }

    void mostraDadosCliente(int j)
    {
        int i = 1;

        cout << "\n\t"
             << j << "º CLIENTE";
        cout << "\n\tNome do Cliente: " << nome << endl;
        cout << "\tSobrenome: " << sobrenome << endl;
        cout << "\tCPF do Cliente: " << cpf << endl;
        cout << "\tData de Nascimento: ";
        dataNascimento.mostraData();

        for (auto it = veiculos.begin(); it != veiculos.end(); it++, i++)
        {
            cout << "\n\t"
                 << i << "º VEICULO";
            cout << "\n\tModelo do Carro: " << it->modelo << endl;
            cout << "\tCor do veiculo: " << it->cor << endl;
            cout << "\tPlaca do veiculo: " << it->placa << endl;
            cout << "\tData de Registro: ";
            it->dataRegistro.mostraData();
            cout <<"\t========================================\n";
        }
    }

    void lerCliente()
    {
        limparTela();
        Veiculo veiculo;
        int quantidadeDeCarros = 0;

        dataNascimento.mostraDataAtual();
        cout << "\t================CLIENTE=================\n";

        lerNome();

        lerSobrenome();

        lerCpf();

        lerDataNascimento();

        if (dataNascimento.anosCompletos() >= 18)
        {
            limparTela();
            dataNascimento.mostraDataAtual();

            cout << "\t==========CADASTRO DE VEICULO==========\n";

            cout << "\n\tInforme a quantidade de veiculos: ";
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
        dataNascimento.mostraDataAtual();

        cout << "\t==========DATA DE NASCIMENTO==========\n";

        dataNascimento.lerData();
    }

} ;

int menu();

void pause();

void cadastraCliente(vector<Cliente> &listCliente);

void listarClientes(vector<Cliente> &listCliente);

void buscarCliente(vector<Cliente> &listCliente);

void removerCliente(vector<Cliente> &listCliente);

Cliente retornarCliente(vector<Cliente> &listCliente);

void sistemaDeLocacao();

int main()
{
    sistemaDeLocacao();
}

int menu()
{
    limparTela();
    MinhaData dataAtual;
    int opcao = 0;

    do
    {
        dataAtual.mostraDataAtual();
        cout << "\t===============MENU===============";
        cout << "\n\t[1] - NOVO CLIENTE:";
        cout << "\n\t[2] - ENCONTRAR CLIENTE:";
        cout << "\n\t[3] - EXCLUIR CLIENTE:";
        cout << "\n\t[4] - LISTAR TODOS OS CLIENTES:";
        cout << "\n\t[0] - SAIR";
        cout << "\n\tENTRADA ->  ";
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
    cout << "\n\tDigite enter para continuar!...\n";
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

void sistemaDeLocacao()
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

            cout << "\n\tPrograma encerrado com sucesso!..." << endl;
            exit(0);

        default:
            cout << "\tOps, Opção invalida!";
        }

    } while (escolha != 0);
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
    MinhaData dataAtual;
    dataAtual.mostraDataAtual();

    int i = 1;
    cout << "\t==========LISTA DE CLIENTES===========\n";

    for (auto it = listCliente.begin(); it != listCliente.end(); it++, i++)
    {
        it->mostraDadosCliente(i);
    }
    pause();
}

void buscarCliente(vector<Cliente> &listCliente)
{
    limparTela();
    MinhaData dataAtual;
    string cpf;
    int i = 1;

    cout << "\tInforme o CPF para consulta: ";
    getline(cin, cpf);

    for (auto it = listCliente.begin(); it != listCliente.end(); ++it, i++)
    {
        if (it->cpf == cpf)
        {
            dataAtual.mostraDataAtual();
            cout << "\t==========CLIENTE ENCONTRADO===========\n";
            it->mostraDadosCliente(i);
            pause();
            return;
        }
    }

    limparTela();
    dataAtual.mostraDataAtual();
    cout << "\tOps, Cliente não encontrado!...\n";
    pause();
}

void removerCliente(vector<Cliente> &listCliente)
{
    limparTela();
    MinhaData dataAtual;
    dataAtual.mostraDataAtual();
    string cpf;
    int i = 1;

    cout << "\t===============REMOVER CLIENTE============\n";
    cout << "\n\tInforme o CPF para remoção: ";
    getline(cin, cpf);

    for (auto it = listCliente.begin(); it != listCliente.end(); ++it, i++)
    {
        if (it->cpf == cpf)
        {
            listCliente.erase(it);
            cout << "\n\tCliente removido com sucesso!...\n";
            pause();
            return;
        }
    }

    limparTela();
    cout << "\tOps, Cliente não encontrado!...\n";
    pause();
}