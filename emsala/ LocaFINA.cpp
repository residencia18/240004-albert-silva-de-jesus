#include <iostream>
#include <vector>
#include <ctime>

using namespace std;

void limparTela();

void pause();

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
        // int diaSemana = getTempo()->tm_wday;

        printf("\n\tDATA ATUAL: %02d/%02d/%4d, %s\n ", getTempo()->tm_mday, getTempo()->tm_mon + 1, getTempo()->tm_year + 1900, diaDaSemana().c_str());
        printf("\tHORA ATUAL: %02d:%02d:%02d\n", getTempo()->tm_hour, getTempo()->tm_min, getTempo()->tm_sec);

        if (bissexto())
        {
            printf("\tANO BISSEXTO, FALTA %i PARA TERMINAR O ANO!...\n", 366 - getTempo()->tm_yday);
        }
        else
        {
            printf("\tANO NÃO BISSEXTO, FALTA %i PARA TERMINAR O ANO!...\n", 365 - getTempo()->tm_yday);
        }
        if (getTempo()->tm_hour >= 0 && getTempo()->tm_hour < 12)
        {
            printf("\tBOM DIA!...\n");
        }
        else if (getTempo()->tm_hour >= 12 && getTempo()->tm_hour < 18)
        {
            printf("\tBOA TARDE!...\n");
        }
        else
        {
            printf("\tBOA NOITE!...\n");
        }

        printf("\n");
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
            cin.get();

        } while (!validaData());
    }

    void mostraData()
    {
        printf("%02d/%02d/%4d ", dia, mes, ano);
    }

    int anosCompletos()
    {
        int x = (getTempo()->tm_year + 1900) - ano;

        // getTempo()->tm_mon siguinifica o mes atual
        if (getTempo()->tm_mon < mes)
        {
            x--;
        }
        else
        { // getTempo()->tm_mday siguinifica o dia atual
            if (getTempo()->tm_mon == mes && getTempo()->tm_mday < dia)
            {
                x--;
            }
        }
        return x;
    }

    bool bissexto()
    {
        // getTempo()->tm_year + 1900 siguinifica o ano atual
        if (getTempo()->tm_year + 1900 % 4 == 0 && getTempo()->tm_year + 1900 % 100 != 0)
        {
            return true;
        }
        else
        {
            if (getTempo()->tm_year + 1900 % 400 == 0)
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

        switch (getTempo()->tm_wday)
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
    string renavan;
    string placa;
    string modelo;
    string cor;
    MinhaData dataHoraRetirada;
    MinhaData dataHoraEntrega;
    string lojaRetirada;

    void lerVeiculo(int i)
    {
        limparTela();
        dataHoraRetirada.mostraDataAtual();

        cout << "\t==========CADASTRO DE VEICULO==========\n"
             << endl;

        cout << "\t" << i << "º Veiculo";
        cout << "\n\tInforme o modelo do veículo: ";
        cin >> modelo;

        cout << "\n\tInforme a cor do veículo: ";
        cin >> cor;

        cout << "\n\tInforme a placa do veiculo: ";
        cin >> placa;
        cin.get();

        limparTela();
        cout << "\n\tVeiculo cadastrado com sucesso!...\n";
        pause();

        cout << "\n\t==========DATA DE REGISTRO==========\n";

        dataHoraRetirada.lerData();
    }

    void mostraDadosVeiculo(int i)
    {
        cout << "\n\t" << i << "º VEICULO";
        cout << "\n\tModelo do Carro: " << modelo << endl;
        cout << "\tCor do veiculo: " << cor << endl;
        cout << "\tPlaca do veiculo: " << placa << endl;
        cout << "\tData de Registro: ";
        dataHoraRetirada.mostraData();
        cout << "\n\t========================================\n";
    }
};

struct Cliente
{
    string nome;
    string cpf;
    string cnh;
    vector<Veiculo> veiculos;
    MinhaData dataNascimento;

    void lerNome()
    {
        cout << "\n\tInforme o nome do cliente: ";
        getline(cin, nome);
    }

    void lerCpf()
    {
        cout << "\n\tInforme o cpf: ";
        getline(cin, cpf);
    }

    void lerCNH()
    {
        cout << "\n\tInforme a CNH: ";
        getline(cin, cnh);
    }

    void mostraDadosCliente(int j)
    {
        cout << "\n\t" << j << "º CLIENTE";
        cout << "\n\tNome do Cliente: " << nome << endl;
        cout << "\tCNH do Cliente: " << cnh << endl;
        cout << "\tCPF do Cliente: " << cpf << endl;
        cout << "\tData de Nascimento: ";
        dataNascimento.mostraData();
        cout << "\n\tIdade do cliente: " << dataNascimento.anosCompletos() << endl;
        cout << "\n\t========================================\n";
    }

    void listarClientesComCarroLocado(int j)
    {
        int i = 1;

        cout << "\n\t" << j << "º CLIENTE";
        cout << "\n\tNome do Cliente: " << nome << endl;
        cout << "\tCNH do Cliente: " << cnh << endl;
        cout << "\tCPF do Cliente: " << cpf << endl;
        cout << "\tData de Nascimento: ";
        dataNascimento.mostraData();
        cout << "\n\t========================================\n";

        for (auto it = veiculos.begin(); it != veiculos.end(); it++, i++)
        {
            cout << "\n\t" << i << "º VEICULO";
            cout << "\n\tModelo do Carro: " << it->modelo << endl;
            cout << "\tCor do veiculo: " << it->cor << endl;
            cout << "\tPlaca do veiculo: " << it->placa << endl;
            cout << "\tData de Registro: ";
            it->dataHoraRetirada.mostraData();
            cout << "\n\t========================================\n";
        }
    }

    void lerCliente(int i)
    {
        limparTela();
        Veiculo veiculo;

        dataNascimento.mostraDataAtual();
        cout << "\t================CLIENTE=================\n";

        cout << "\n\t" << i << "º Cliente";
        lerNome();

        lerCNH();

        lerCpf();

        limparTela();
        cout << "\n\t==========DATA DE NASCIMENTO==========\n";

        lerDataNascimento();

        cout << "\n\tCliente cadastrado com sucesso!...\n";
        pause();
    }

    void lerDataNascimento()
    {
        limparTela();
        dataNascimento.mostraDataAtual();

        cout << "\t==========DATA DE NASCIMENTO==========\n";

        dataNascimento.lerData();
    }

    void locarVeiculo(vector<Cliente> &listCliente)
    {
        limparTela();
        string cpf;
        string placa;
        int i = 1;

        dataNascimento.mostraDataAtual();
        cout << "\t===============LOCAR VEICULO============\n";

        if (veiculos.empty())
        {
            cout << "\n\tNão há veiculos cadastrados!...\n";
            pause();
            return;
        }
        do
        {
            cout << "\n\tInforme o CPF para locação: ";
            getline(cin, cpf);

            for (auto it = listCliente.begin(); it != listCliente.end(); ++it, i++)
            {
                if (it->cpf == cpf && it->dataNascimento.anosCompletos() >= 18)
                {
                    limparTela();
                    cout << "\t==========CLIENTE ENCONTRADO===========\n";
                    cout << "\n\tNome: " << it->nome << endl;
                    cout << "\tCpf: " << it->cpf << endl;
                    cout << "\tIdade: " << it->dataNascimento.anosCompletos() << endl;
                    cout << "\n\tCliente encontrado!...\n";
                    pause();

                    cout << "\n\t==========VEICULOS DISPONIVEIS==========\n";

                    for (auto it = veiculos.begin(); it != veiculos.end(); it++, i++)
                    {
                        it->mostraDadosVeiculo(i);
                    }

                    do
                    {
                        pause();
                        cout << "\n\tInforme a placa do veiculo: ";
                        cin >> placa;
                        cin.get();

                        for (auto itVeiculo = veiculos.begin(); itVeiculo != veiculos.end(); ++itVeiculo, i++)
                        {
                            if (itVeiculo->placa == placa)
                            {
                                limparTela();
                                cout << "\t==========VEICULO ENCONTRADO===========\n";
                                cout << "\n\tModelo: " << itVeiculo->modelo << endl;
                                cout << "\tPlaca: " << itVeiculo->placa << endl;
                                cout << "\n\tVeiculo encontrado!...\n";
                                pause();
                                placa = "0";

                                for (auto itCliente = listCliente.begin(); it != listCliente.end(); ++itCliente, i++)
                                {
                                    if (itCliente->cpf == cpf)
                                    {
                                        itCliente->veiculos.push_back(*itVeiculo);
                                        cout << "\n\tVeiculo locado com sucesso!...\n";
                                        pause();
                                        return;
                                    }
                                }
                            }
                        }

                        if (placa != "0")
                        {
                            limparTela();
                            cout << "\tOps, Veiculo não encontrado!...\n";
                            pause();
                        }

                    } while (placa != "0");
                }
                if (it->cpf == cpf && it->dataNascimento.anosCompletos() < 18)
                {

                    limparTela();
                    cout << "\t==========CLIENTE ENCONTRADO===========\n";
                    cout << "\n\tNome: " << it->nome << endl;
                    cout << "\tCpf: " << it->cpf << endl;
                    cout << "\tIdade: " << it->dataNascimento.anosCompletos() << endl;
                    cout << "\tCliente encontrado!...\n";
                    pause();
                    cout << "\n\tOps, Cliente menor de idade!...\n";
                    pause();
                    return;
                }
            }

            if (placa != "0")
            {
                limparTela();
                cout << "\tOps, Cliente não encontrado!...\n";
                pause();
            }

        } while (placa != "0");
    }
};

int menu();

void sistemaDeLocacao();

void cadastraCliente(vector<Cliente> &listCliente);

void cadastraVeiculo(Cliente &cliente);

void listarClientes(vector<Cliente> &listCliente);

void listarVeiculos(Cliente listVeiculos);

void alterarAndBucarCliente(vector<Cliente> &listCliente);

void removerCliente(vector<Cliente> &listCliente);

void localizarCliente(vector<Cliente> &listCliente);

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
        cout << "\t===========MENU===========";
        cout << "\n\t[1] - INCLUIR:";
        cout << "\n\t[2] - EXCLUIR:";
        cout << "\n\t[3] - ALTERAR:";
        cout << "\n\t[4] - LISTAR:";
        cout << "\n\t[5] - LOCALIZAR:";
        cout << "\n\t[6] - LISTAR VEICULOS:";
        cout << "\n\t[7] - LOCAR VEICULO:";
        cout << "\n\t[0] - SAIR";
        cout << "\n\tENTRADA ->  ";
        cin >> opcao;
        cin.get();

        if (opcao > 7 || opcao < 0)
        {
            limparTela();
            cout << "Ops, escolha invalida!...\n";
            pause();
        }

    } while (opcao > 7 || opcao < 0);

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
    Cliente cliente;
    int escolha = 1;

    do
    {
        switch (menu())
        {

        case 1:

            cadastraCliente(listCliente);

            break;

        case 2:

            // cadastraVeiculo(cliente);
            removerCliente(listCliente);

            break;

        case 3:

            alterarAndBucarCliente(listCliente);

            break;

        case 4:

            listarClientes(listCliente);

            break;

        case 5:

            localizarCliente(listCliente);

            break;

        case 6:

            listarVeiculos(cliente);

            break;

        case 7:

            cliente.locarVeiculo(listCliente);

            break;

        case 0:

            cout << "\n\tPrograma encerrado com sucesso!..." << endl;
            escolha = 0;
            exit(0);

        default:
            cout << "\tOps, Opção invalida!";
        }

    } while (escolha != 0);
}

void cadastraCliente(vector<Cliente> &listCliente)
{
    int i = 0;
    Cliente cliente;
    cliente.lerCliente(i = listCliente.size() + 1);
    listCliente.push_back(cliente);
}

void cadastraVeiculo(Cliente &cliente)
{
    int i = 0;
    Veiculo veiculo;
    veiculo.lerVeiculo(i = cliente.veiculos.size() + 1);
    cliente.veiculos.push_back(veiculo);
}

void listarClientes(vector<Cliente> &listCliente)
{
    limparTela();
    MinhaData dataAtual;
    int opcao = 0;
    int opcaoIdade = 0;
    int i = 1;

    do
    {
        limparTela();
        dataAtual.mostraDataAtual();
        cout << "\t==========LISTA DE CLIENTES===========\n";
        cout << "\n\t[1] - LISTAR TODOS OS CLIENTES:";
        cout << "\n\t[2] - LISTAR CLIENTES POR IDADE:";
        cout << "\n\t[3] - LISTAR CLIENTES COM CARRO LOCADO:";
        cout << "\n\t[0] - SAIR";
        cout << "\n\tENTRADA ->  ";
        cin >> opcao;
        cin.get();
        i = 1;

        limparTela();
        dataAtual.mostraDataAtual();
        cout << "\t==========LISTA DE CLIENTES===========\n";
        if (opcao == 0)
        {
            return;
        }
        if (opcao == 1)
        {

            for (auto it = listCliente.begin(); it != listCliente.end(); it++, i++)
            {
                it->mostraDadosCliente(i);
            }
            pause();
        }
        if (opcao == 2)
        {
            do
            {
                limparTela();
                dataAtual.mostraDataAtual();
                cout << "\t=======LISTA DE CLIENTES========\n";
                cout << "\n\t[1] - MAIOR DE IDADE:";
                cout << "\n\t[2] - MENOR DE IDADE:";
                cout << "\n\t[0] - SAIR";
                cout << "\n\tENTRADA ->  ";
                cin >> opcaoIdade;
                cin.get();
                i = 1;

                if (opcaoIdade == 1)
                {
                    limparTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========LISTA DE CLIENTES POR IDADE===========\n";

                    for (auto it = listCliente.begin(); it != listCliente.end(); it++, i++)
                    {
                        if (it->dataNascimento.anosCompletos() >= 18)
                        {
                            it->mostraDadosCliente(i);
                        }
                    }
                    pause();
                }
                if (opcaoIdade == 2)
                {
                    limparTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========LISTA DE CLIENTES POR IDADE===========\n";

                    for (auto it = listCliente.begin(); it != listCliente.end(); it++, i++)
                    {
                        if (it->dataNascimento.anosCompletos() < 18)
                        {
                            it->mostraDadosCliente(i);
                        }
                    }
                    pause();
                }

            } while (opcaoIdade != 0);
        }
        if (opcao == 3)
        {

            limparTela();
            dataAtual.mostraDataAtual();
            cout << "\t==========LISTA DE CLIENTES COM CARRO LOCADO===========\n";

            for (auto it = listCliente.begin(); it != listCliente.end(); it++, i++)
            {
                if (it->veiculos.size() > 0)
                {
                    it->listarClientesComCarroLocado(i);
                }
            }
            pause();
        }

    } while (opcao != 0);
}

void listarVeiculos(Cliente listVeiculos)
{
    limparTela();
    MinhaData dataAtual;
    dataAtual.mostraDataAtual();

    int i = 1;
    cout << "\t==========LISTA DE VEICULOS===========\n";

    if (listVeiculos.veiculos.empty())
    {
        cout << "\n\tNão há veiculos cadastrados!...\n";
        pause();
        return;
    }

    for (auto it = listVeiculos.veiculos.begin(); it != listVeiculos.veiculos.end(); it++, i++)
    {
        it->mostraDadosVeiculo(i);
    }
    pause();
}

void alterarAndBucarCliente(vector<Cliente> &listCliente)
{
    limparTela();
    MinhaData dataAtual;
    string cpf;
    int opcao = 0;
    int i = 1;

    if (listCliente.empty())
    {
        cout << "\t==========PESQUISAR CLIENTE===========\n";
        cout << "\n\tNão há clientes cadastrados!...\n";
        pause();
        return;
    }

    do
    {
        cout << "\n\t[1] - ALTERAR NOME:";
        cout << "\n\t[2] - ALTERAR CNH:";
        cout << "\n\t[3] - ALTERAR CPF:";
        cout << "\n\t[4] - ALTERAR IDADE DE NASCIMENTO:";
        cout << "\n\t[0] - SAIR";
        cout << "\n\tENTRADA ->  ";
        cin >> opcao;
        cin.get();

        if (opcao == 1)
        {
            limparTela();
            cout << "\tInforme o CPF para consulta: ";
            getline(cin, cpf);

            for (auto it = listCliente.begin(); it != listCliente.end(); ++it, i++)
            {
                if (it->cpf == cpf)
                {
                    limparTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========CLIENTE ENCONTRADO===========\n";
                    it->mostraDadosCliente(i);
                    pause();

                    do
                    {
                        cout << "\n\tDeseja alterar o nome desse cliente?\n\t[1] SIM\n\t[0] NÃO\n\tENTRADA ->  ";
                        cin >> opcao;
                        cin.get();

                    } while (opcao < 0 && opcao > 1);

                    if (opcao == 1)
                    {

                        cout << "\n\tInforme o nome do cliente para correção: ";
                        cin >> it->nome;
                        cin.get();

                        limparTela();
                        it->mostraDadosCliente(i);
                        cout << "\n\tNome alterado com sucesso!...";
                        pause();
                        opcao = 5;
                    }
                }
            }
        }
        if (opcao == 2)
        {
            limparTela();
            cout << "\tInforme o CPF para consulta: ";
            getline(cin, cpf);

            for (auto it = listCliente.begin(); it != listCliente.end(); ++it, i++)
            {
                if (it->cpf == cpf)
                {
                    limparTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========CLIENTE ENCONTRADO===========\n";
                    it->mostraDadosCliente(i);
                    pause();

                    do
                    {
                        cout << "\n\tDeseja alterar CNH desse cliente?\n\t[1] SIM\n\t[0] NÃO\n\tENTRADA ->  ";
                        cin >> opcao;
                        cin.get();

                    } while (opcao < 0 && opcao > 1);

                    if (opcao == 1)
                    {

                        cout << "\n\tInforme a CNH do cliente para correção: ";
                        cin >> it->cnh;
                        cin.get();

                        limparTela();
                        it->mostraDadosCliente(i);
                        cout << "\n\tCNH alterada com sucesso!...";
                        pause();
                        opcao = 5;
                    }
                }
            }
        }

    } while (opcao < 0 && opcao > 4);

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

    if (listCliente.empty())
    {
        cout << "\n\tNão há clientes cadastrados!...\n";
        pause();
        return;
    }
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

void localizarCliente(vector<Cliente> &listCliente)
{
    limparTela();
    MinhaData dataAtual;
    string cpf;
    int i = 1;

    if(listCliente.empty()){

        cout << "\t==========PESQUISAR CLIENTE===========\n";
        cout << "\n\tNão há clientes cadastrados!...\n";
        pause();
        return;
    }

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
