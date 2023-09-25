#include <iostream>
#include <vector>
#include <ctime>

using namespace std;

void limpaTela();

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

    void lerDataRetirada()
    {

        do
        {
            cout << "\n\tInforme o dia de retirada: ";
            cin >> dia;

            cout << "\n\tInforme o mes de retirada: ";
            cin >> mes;

            cout << "\n\tInforme o ano de retirada: ";
            cin >> ano;
            cin.get();

        } while (!validaData());
    }

    void lerDataEntrega()
    {

        do
        {
            cout << "\n\tInforme o dia de entrega: ";
            cin >> dia;

            cout << "\n\tInforme o mes de entrega: ";
            cin >> mes;

            cout << "\n\tInforme o ano de entrega: ";
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
        limpaTela();

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

    bool validaDataDeEntrega(MinhaData dataHoraRetirada, MinhaData dataHoraEntrega)
    {
        // Data de retirada
        struct tm retirada = {0};
        retirada.tm_year = dataHoraRetirada.ano; // Ano - 1900
        retirada.tm_mon = dataHoraRetirada.mes;  // Mês (0-11)
        retirada.tm_mday = dataHoraRetirada.dia; // Dia
        retirada.tm_hour = 10;                   // Hora
        retirada.tm_min = 0;                     // Minuto
        retirada.tm_sec = 0;                     // Segundo

        // Data de entrega
        struct tm entrega = {0};
        entrega.tm_year = dataHoraEntrega.ano; // Ano - 1900
        entrega.tm_mon = dataHoraEntrega.mes;  // Mês (0-11)
        entrega.tm_mday = dataHoraEntrega.dia; // Dia
        entrega.tm_hour = 11;                  // Hora
        entrega.tm_min = 30;                   // Minuto
        entrega.tm_sec = 0;                    // Segundo

        // Converte as datas em timestamps
        time_t retiradaTimestamp = mktime(&retirada);
        time_t entregaTimestamp = mktime(&entrega);

        // Verifica se a data de entrega é anterior à data de retirada
        if (retirada.tm_year > entrega.tm_year)
        {
            cout << "\n\tOps, Data de entrega invalida!...\n";
            pause();
            return false;
        }
        else
        {
            if (retirada.tm_mon > entrega.tm_mon)
            {
                cout << "\n\tOps, Data de entrega invalida!...\n";
                pause();
                return false;
            }
            else
            {
                if (retirada.tm_mday > entrega.tm_mday)
                {
                    cout << "\n\tOps, Data de entrega invalida!...\n";
                    pause();
                    return false;
                }
            }
        }

        // Calcula a diferença entre as datas
        double diff = difftime(entregaTimestamp, retiradaTimestamp);

        // Converte a diferença de segundos para dias
        diff = diff / (60 * 60 * 24);

        // Mostra a diferença em dias
        cout << "\n\tDiferença em dias: " << diff << endl;
        pause();

        if (diff > 30)
        {
            cout << "\n\tOps, Data de entrega invalida!...\n";
            pause();
            return false;
        }

        cout << "\n\tData de entrega valida!...\n";
        pause();
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
    string lojaRetirada;
    MinhaData dataHoraRetirada;
    MinhaData dataHoraEntrega;

    void lerVeiculo(int i)
    {
        limpaTela();
        dataHoraRetirada.mostraDataAtual();

        cout << "\t==========CADASTRO DE VEICULO==========\n"
             << endl;

        cout << "\t" << i << "º Veiculo";
        cout << "\n\tInforme o renavan do veículo: ";
        getline(cin, renavan);

        cout << "\n\tInforme o modelo do veículo: ";
        getline(cin, modelo);

        cout << "\n\tInforme a cor do veículo: ";
        getline(cin, cor);

        cout << "\n\tInforme a placa do veiculo: ";
        getline(cin, placa);

        limpaTela();
        cout << "\n\t==========DATA DE REGISTRO==========\n";

        dataHoraRetirada.lerDataRetirada();

        do
        {
            limpaTela();
            cout << "\n\t==========DATA DE ENTREGA==========\n";

            dataHoraEntrega.lerDataEntrega();

        } while (!dataHoraEntrega.validaDataDeEntrega(dataHoraRetirada, dataHoraEntrega));

        limpaTela();
        cout << "\n\t==========LOJA DE RETIRADA==========\n";

        cout << "\n\tInforme a loja de retirada: ";
        getline(cin, lojaRetirada);

        limpaTela();
        cout << "\n\tVeiculo cadastrado com sucesso!...\n";
        pause();
    }

    void mostraDadosVeiculo(int i)
    {
        cout << "\n\t" << i << "º VEICULO";
        cout << "\n\tRenavan do veículo: " << renavan << endl;
        cout << "\tModelo do Carro: " << modelo << endl;
        cout << "\tCor do veiculo: " << cor << endl;
        cout << "\tPlaca do veiculo: " << placa << endl;
        cout << "\tData de Retirada: ";
        dataHoraRetirada.mostraData();
        cout << "\n\tData de Entrega: ";
        dataHoraEntrega.mostraData();
        cout << "\n\tLoja de Retirada: " << lojaRetirada << endl;
        cout << "\t========================================\n";
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
        cout << "\t========================================\n";
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
        cout << "\n\tIdade do cliente: " << dataNascimento.anosCompletos() << endl;

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
        limpaTela();
        Veiculo veiculo;

        dataNascimento.mostraDataAtual();
        cout << "\t================CLIENTE=================\n";

        cout << "\n\t" << i << "º Cliente";
        lerNome();

        lerCNH();

        lerCpf();

        limpaTela();
        cout << "\n\t==========DATA DE NASCIMENTO==========\n";

        lerDataNascimento();

        cout << "\n\tCliente cadastrado com sucesso!...\n";
        pause();
    }

    void lerDataNascimento()
    {
        limpaTela();
        dataNascimento.mostraDataAtual();

        cout << "\t==========DATA DE NASCIMENTO==========\n";

        dataNascimento.lerData();
    }

    void locarVeiculo(vector<Cliente> &listCliente)
    {
        limpaTela();
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
                    limpaTela();
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
                                limpaTela();
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
                            limpaTela();
                            cout << "\tOps, Veiculo não encontrado!...\n";
                            pause();
                        }

                    } while (placa != "0");
                }
                if (it->cpf == cpf && it->dataNascimento.anosCompletos() < 18)
                {

                    limpaTela();
                    cout << "\t==========CLIENTE ENCONTRADO===========\n";
                    cout << "\n\tNome: " << it->nome << endl;
                    cout << "\tCpf: " << it->cpf << endl;
                    cout << "\tIdade: " << it->dataNascimento.anosCompletos() << endl;
                    cout << "\tCliente encontrado!...\n";

                    cout << "\n\tOps, Cliente menor de idade!...\n";
                    pause();
                    return;
                }
            }

            if (placa != "0")
            {
                limpaTela();
                cout << "\tOps, Cliente não encontrado!...\n";
                pause();
            }

        } while (placa != "0");
    }
};

int menuPrincipal();

int menuEscolha();

int meuLocacao();

void sistemaDeGestaoLocacaoDeVeiculos();

void cadastrarCliente(vector<Cliente> &listCliente);

void cadastrarVeiculo(Cliente &cliente);

void listarClientes(vector<Cliente> &listCliente);

void listarVeiculos(Cliente listVeiculos);

void alterarCliente(vector<Cliente> &listCliente);

void alterarVeiculo(Cliente &listVeiculos);

void removerCliente(vector<Cliente> &listCliente);

void removerVeiculo(Cliente &listVeiculos);

void localizarCliente(vector<Cliente> &listCliente);

void localizarVeiculo(Cliente &listVeiculos);

void locarVeiculo(vector<Cliente> &listCliente, Cliente &listVeiculos);

int main()
{
    sistemaDeGestaoLocacaoDeVeiculos();
}

void pause()
{
    cout << "\n\tDigite enter para continuar!...\n";
    cin.get();
    limpaTela();
}

void limpaTela()
{
#ifdef _WIN32
    system("cls");
#else
    system("clear");
#endif
}

int menuPrincipal()
{
    MinhaData dataAtual;
    int opcao = 0;

    do
    {
        limpaTela();
        dataAtual.mostraDataAtual();
        cout << "\t======MENU PRINCIPAL======";
        cout << "\n\t[1] - GESTÃO CLIENTE:";
        cout << "\n\t[2] - GESTÃO VEICULO:";
        cout << "\n\t[3] - GESTÃO LOCAÇÃO:";
        cout << "\n\t[0] - SAIR";
        cout << "\n\tENTRADA ->  ";
        cin >> opcao;
        cin.get();

        if (opcao > 3 || opcao < 0)
        {
            limpaTela();
            cout << "Ops, escolha invalida!...\n";
            pause();
        }

    } while (opcao > 3 || opcao < 0);

    return opcao;
}

int menuEscolha()
{
    limpaTela();
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
        cout << "\n\t[0] - SAIR";
        cout << "\n\tENTRADA ->  ";
        cin >> opcao;
        cin.get();

        if (opcao > 5 || opcao < 0)
        {
            limpaTela();
            cout << "Ops, escolha invalida!...\n";
            pause();
        }

    } while (opcao > 5 || opcao < 0);

    return opcao;
}

int menuLocacao()
{
    limpaTela();
    MinhaData dataAtual;
    int opcao = 0;

    do
    {
        dataAtual.mostraDataAtual();
        cout << "\t===========MENU===========";
        cout << "\n\t[1] - INCLUIR LOCAÇÃO:";
        cout << "\n\t[2] - EXCLUIR LOCAÇÃO:";
        cout << "\n\t[3] - ALTERAR LOCAÇÃO:";
        cout << "\n\t[4] - LISTAR LOCAÇÕES:";
        cout << "\n\t[0] - SAIR";
        cout << "\n\tENTRADA ->  ";
        cin >> opcao;
        cin.get();

        if (opcao > 4 || opcao < 0)
        {
            limpaTela();
            cout << "Ops, escolha invalida!...\n";
            pause();
        }

    } while (opcao > 4 || opcao < 0);

    return opcao;
}

void sistemaDeGestaoLocacaoDeVeiculos()
{
    vector<Cliente> listCliente;
    Cliente cliente;
    int escolha = 0;
    int clienteOuVeiculo = 0;

    do
    {
        switch (clienteOuVeiculo = menuPrincipal())
        {

        case 1:

            do
            {
                escolha = menuEscolha();
                if (escolha == 1)
                {
                    cadastrarCliente(listCliente);
                }
                if (escolha == 2)
                {
                    if (listCliente.empty())
                    {
                        cout << "\n\tNão há clientes cadastrados!...\n";
                        pause();
                    }
                    else
                    {
                        removerCliente(listCliente);
                    }
                }
                if (escolha == 3)
                {
                    if (listCliente.empty())
                    {
                        cout << "\n\tNão há clientes cadastrados!...\n";
                        pause();
                    }
                    else
                    {
                        alterarCliente(listCliente);
                    }
                }
                if (escolha == 4)
                {
                    if (listCliente.empty())
                    {
                        cout << "\n\tNão há clientes cadastrados!...\n";
                        pause();
                    }
                    else
                    {
                        listarClientes(listCliente);
                    }
                }
                if (escolha == 5)
                {
                    if (listCliente.empty())
                    {
                        cout << "\n\tNão há clientes cadastrados!...\n";
                        pause();
                    }
                    else
                    {
                        localizarCliente(listCliente);
                    }
                }
                if (escolha > 5 && escolha < 0)
                {
                    limpaTela();
                    cout << "\n\tOps, opção invalida!";
                    pause();
                }

            } while (escolha != 0);

            break;

        case 2:

            do
            {
                escolha = menuEscolha();
                if (escolha == 1)
                {
                    cadastrarVeiculo(cliente);
                }
                if (escolha == 2)
                {
                    if (cliente.veiculos.empty())
                    {
                        cout << "\n\tNão há veiculos cadastrados!...\n";
                        pause();
                    }
                    else
                    {
                        removerVeiculo(cliente);
                    }
                }
                if (escolha == 3)
                {
                    if (cliente.veiculos.empty())
                    {
                        cout << "\n\tNão há veiculos cadastrados!...\n";
                        pause();
                    }
                    else
                    {
                        alterarVeiculo(cliente);
                    }
                }
                if (escolha == 4)
                {
                    if (cliente.veiculos.empty())
                    {
                        cout << "\n\tNão há veiculos cadastrados!...\n";
                        pause();
                    }
                    else
                    {
                        listarVeiculos(cliente);
                    }
                }
                if (escolha == 5)
                {
                    if (cliente.veiculos.empty())
                    {
                        cout << "\n\tNão há veiculos cadastrados!...\n";
                        pause();
                    }
                    else
                    {
                        localizarVeiculo(cliente);
                    }
                }
                if (escolha > 5 && escolha < 0)
                {
                    limpaTela();
                    cout << "\n\tOps, opção invalida!";
                    pause();
                }

            } while (escolha != 0);

            break;

        case 3:

            do
            {
                escolha = menuLocacao();
                if (escolha == 1)
                {
                    // INCLUIR LOCAÇÃO
                    cout << "\n\tINCLUIR LOCAÇÃO" << endl;
                    pause();
                }
                if (escolha == 2)
                {
                    if (cliente.veiculos.empty())
                    {
                        cout << "\n\tNão há veiculos cadastrados!...\n";
                        pause();
                    }
                    else
                    {
                        // EXCLUIR LOCAÇÃO
                        cout << "\n\tEXCLUIR LOCAÇÃO" << endl;
                        pause();
                    }
                }
                if (escolha == 3)
                {
                    if (cliente.veiculos.empty())
                    {
                        cout << "\n\tNão há veiculos cadastrados!...\n";
                        pause();
                    }
                    else
                    {
                        // ALTERAR LOCAÇÃO
                        cout << "\n\tALTERAR LOCAÇÃO" << endl;
                        pause();
                    }
                }
                if (escolha == 4)
                {
                    if (cliente.veiculos.empty())
                    {
                        cout << "\n\tNão há veiculos cadastrados!...\n";
                        pause();
                    }
                    else
                    {
                        // LISTAR TODAS AS LOCAÇÕES
                        cout << "\n\tLISTAR TODAS AS LOCAÇÕES" << endl;
                        pause();
                    }
                }
                if (escolha > 5 && escolha < 0)
                {
                    limpaTela();
                    cout << "\n\tOps, opção invalida!";
                    pause();
                }

            } while (escolha != 0);
            break;

        case 0:

            cout << "\n\tPrograma encerrado com sucesso!..." << endl;
            clienteOuVeiculo = 0;
            exit(0);

        default:
            cout << "\tOps, Opção invalida!";
        }
    } while (clienteOuVeiculo != 0);
}

void cadastrarCliente(vector<Cliente> &listCliente)
{
    int i = 0;
    Cliente cliente;
    cliente.lerCliente(i = listCliente.size() + 1);
    listCliente.push_back(cliente);
}

void cadastrarVeiculo(Cliente &cliente)
{
    int i = 0;
    Veiculo veiculo;
    veiculo.lerVeiculo(i = cliente.veiculos.size() + 1);
    cliente.veiculos.push_back(veiculo);
}

void removerCliente(vector<Cliente> &listCliente)
{
    limpaTela();
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

    limpaTela();
    cout << "\tOps, Cliente não encontrado!...\n";
    pause();
}

void removerVeiculo(Cliente &listVeiculos)
{
    limpaTela();
    MinhaData dataAtual;
    Veiculo veiculo;
    dataAtual.mostraDataAtual();
    string placa;
    int i = 1;

    cout << "\t===============REMOVER CLIENTE============\n";

    if (listVeiculos.veiculos.empty())
    {
        cout << "\n\tNão há veiculos cadastrados!...\n";
        pause();
        return;
    }
    cout << "\n\tInforme a placa para remoção: ";
    getline(cin, placa);

    for (auto it = listVeiculos.veiculos.begin(); it != listVeiculos.veiculos.end(); ++it, i++)
    {
        if (it->placa == placa)
        {
            it->mostraDadosVeiculo(i);
            listVeiculos.veiculos.erase(it);
            cout << "\n\tCliente removido com sucesso!...\n";
            pause();
            return;
        }
    }

    limpaTela();
    cout << "\tOps, Cliente não encontrado!...\n";
    pause();
}

void listarClientes(vector<Cliente> &listCliente)
{
    limpaTela();
    MinhaData dataAtual;
    int opcao = 0;
    int opcaoIdade = 0;
    int i = 1;

    do
    {
        limpaTela();
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

        limpaTela();
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
                limpaTela();
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
                    limpaTela();
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
                    limpaTela();
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

            limpaTela();
            dataAtual.mostraDataAtual();
            cout << "\t=========LISTA DE CLIENTES COM CARRO LOCADO==========";

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
    limpaTela();
    MinhaData dataAtual;
    dataAtual.mostraDataAtual();

    int i = 1;
    cout << "\t==========LISTA DE VEICULOS===========";

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

void alterarCliente(vector<Cliente> &listCliente)
{
    limpaTela();
    MinhaData dataAtual;
    string cpf;
    int opcao = 0;
    int escolha = 0;

    if (listCliente.empty())
    {
        cout << "\t==========PESQUISAR CLIENTE===========\n";
        cout << "\n\tNão há clientes cadastrados!...\n";
        pause();
        return;
    }

    do
    {
        int i = 1;
        limpaTela();
        dataAtual.mostraDataAtual();
        cout << "\t==========MENU ALTERAR===========\n";
        cout << "\n\t[1] - ALTERAR NOME:";
        cout << "\n\t[2] - ALTERAR CNH:";
        cout << "\n\t[3] - ALTERAR CPF:";
        cout << "\n\t[4] - ALTERAR IDADE DE NASCIMENTO:";
        cout << "\n\t[0] - SAIR";
        cout << "\n\tENTRADA ->  ";
        cin >> opcao;
        escolha = opcao;
        cin.get();

        if (opcao == 1)
        {
            limpaTela();
            cout << "\tInforme o CPF para consulta: ";
            getline(cin, cpf);

            for (auto it = listCliente.begin(); it != listCliente.end(); ++it, i++)
            {
                if (it->cpf == cpf)
                {
                    limpaTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========CLIENTE ENCONTRADO===========";
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

                        limpaTela();
                        dataAtual.mostraDataAtual();
                        cout << "\t=========CLIENTE ALTERADO (NOME)==========";
                        it->mostraDadosCliente(i);
                        cout << "\n\tNome alterado com sucesso!...";
                        cpf = "0";
                        pause();
                    }
                }
            }
            if (cpf != "0")
            {
                limpaTela();
                cout << "\tOps, Cliente não encontrado!...\n";
                pause();
            }
        }
        if (opcao == 2)
        {
            limpaTela();
            cout << "\tInforme o CPF para consulta: ";
            getline(cin, cpf);

            for (auto it = listCliente.begin(); it != listCliente.end(); ++it, i++)
            {
                if (it->cpf == cpf)
                {
                    limpaTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========CLIENTE ENCONTRADO===========";
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

                        limpaTela();
                        dataAtual.mostraDataAtual();
                        cout << "\n\t=========CLIENTE ALTERADO (CNH)=========\n";
                        it->mostraDadosCliente(i);
                        cout << "\n\tCNH alterada com sucesso!...";
                        cpf = "0";
                        pause();
                    }
                }
            }
            if (cpf != "0")
            {
                limpaTela();
                cout << "\tOps, Cliente não encontrado!...\n";
                pause();
            }
        }

        if (opcao == 3)
        {
            limpaTela();
            cout << "\tInforme o CPF para consulta: ";
            getline(cin, cpf);

            for (auto it = listCliente.begin(); it != listCliente.end(); ++it, i++)
            {
                if (it->cpf == cpf)
                {
                    limpaTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========CLIENTE ENCONTRADO===========";
                    it->mostraDadosCliente(i);
                    pause();

                    do
                    {
                        cout << "\n\tDeseja alterar CPF desse cliente?\n\t[1] SIM\n\t[0] NÃO\n\tENTRADA ->  ";
                        cin >> opcao;
                        cin.get();

                    } while (opcao < 0 && opcao > 1);

                    if (opcao == 1)
                    {

                        cout << "\n\tInforme o CPF do cliente para correção: ";
                        cin >> it->cpf;
                        cin.get();

                        limpaTela();
                        dataAtual.mostraDataAtual();
                        cout << "\t==========CLIENTE ALTERADO (CPF)==========";
                        it->mostraDadosCliente(i);
                        cout << "\n\tCPF alterado com sucesso!...";
                        cpf = "0";
                        pause();
                    }
                }
            }
            if (cpf != "0")
            {
                limpaTela();
                cout << "\tOps, Cliente não encontrado!...\n";
                pause();
            }
        }

        if (opcao == 4)
        {

            limpaTela();
            cout << "\tInforme o CPF para consulta: ";
            getline(cin, cpf);

            for (auto it = listCliente.begin(); it != listCliente.end(); ++it, i++)
            {
                if (it->cpf == cpf)
                {
                    limpaTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========CLIENTE ENCONTRADO===========";
                    it->mostraDadosCliente(i);
                    pause();

                    do
                    {
                        cout << "\n\tDeseja alterar a idade de nascimento desse cliente?\n\t[1] SIM\n\t[0] NÃO\n\tENTRADA ->  ";
                        cin >> opcao;
                        cin.get();

                    } while (opcao < 0 && opcao > 1);

                    if (opcao == 1)
                    {

                        cout << "\n\tInforme a idade de nascimento do cliente para correção:\n";
                        it->dataNascimento.lerData();

                        limpaTela();
                        dataAtual.mostraDataAtual();
                        cout << "\t========CLIENTE ALTERADO (DATA NASCIMENTO)=========";
                        it->mostraDadosCliente(i);
                        cout << "\n\tIdade de nascimento alterada com sucesso!...";
                        cpf = "0";
                        pause();
                    }
                }
            }
            if (cpf != "0")
            {
                limpaTela();
                cout << "\tOps, Cliente não encontrado!...\n";
                pause();
            }
        }
        if (escolha > 4 || escolha < 0)
        {

            limpaTela();
            cout << "\tOps, opção invalida!...\n";
            pause();
        }

    } while (escolha != 0);
}

void alterarVeiculo(Cliente &listVeiculos)
{

    limpaTela();
    MinhaData dataAtual;
    string placa;
    int opcao = 0;
    int escolha = 0;

    if (listVeiculos.veiculos.empty())
    {
        cout << "\t==========PESQUISAR VEICULO===========\n";
        cout << "\n\tNão há veiculos cadastrados!...\n";
        pause();
        return;
    }

    do
    {
        int i = 1;
        limpaTela();
        dataAtual.mostraDataAtual();
        cout << "\t==========MENU ALTERAR===========\n";
        cout << "\n\t[1] - ALTERAR RENAVAN:";
        cout << "\n\t[2] - ALTERAR MODELO:";
        cout << "\n\t[3] - ALTERAR COR:";
        cout << "\n\t[4] - ALTERAR PLACA:";
        cout << "\n\t[5] - ALTERAR DATA DE RETIRADA:";
        cout << "\n\t[6] - ALTERAR DATA DE ENTREGA:";
        cout << "\n\t[7] - ALTERAR LOJA DE RETIRADA:";
        cout << "\n\t[0] - SAIR";
        cout << "\n\tENTRADA ->  ";
        cin >> opcao;
        escolha = opcao;
        cin.get();

        if (opcao == 1)
        {
            limpaTela();
            cout << "\tInforme a placa para consulta: ";
            getline(cin, placa);

            for (auto it = listVeiculos.veiculos.begin(); it != listVeiculos.veiculos.end(); ++it, i++)
            {
                if (it->placa == placa)
                {
                    limpaTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========VEICULO ENCONTRADO===========";
                    it->mostraDadosVeiculo(i);
                    pause();

                    do
                    {
                        cout << "\n\tDeseja alterar o renavan desse veiculo?\n\t[1] SIM\n\t[0] NÃO\n\tENTRADA ->  ";
                        cin >> opcao;
                        cin.get();

                    } while (opcao < 0 && opcao > 1);

                    if (opcao == 1)
                    {
                        cout << "\n\tInforme o renavan do veiculo para correção: ";
                        cin >> it->renavan;
                        cin.get();

                        limpaTela();
                        dataAtual.mostraDataAtual();
                        cout << "\t=========VEICULO ALTERADO (RENAVAN)==========";
                        it->mostraDadosVeiculo(i);
                        cout << "\n\tRenavan alterado com sucesso!...";
                        placa = "0";
                        pause();
                    }
                }
            }
            if (placa != "0")
            {
                limpaTela();
                cout << "\tOps, Veiculo não encontrado!...\n";
                pause();
            }
        }

        if (opcao == 2)
        {
            limpaTela();
            cout << "\tInforme a placa para consulta: ";
            getline(cin, placa);

            for (auto it = listVeiculos.veiculos.begin(); it != listVeiculos.veiculos.end(); ++it, i++)
            {
                if (it->placa == placa)
                {
                    limpaTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========VEICULO ENCONTRADO===========";
                    it->mostraDadosVeiculo(i);
                    pause();

                    do
                    {
                        cout << "\n\tDeseja alterar o modelo desse veiculo?\n\t[1] SIM\n\t[0] NÃO\n\tENTRADA ->  ";
                        cin >> opcao;
                        cin.get();

                    } while (opcao < 0 && opcao > 1);

                    if (opcao == 1)
                    {
                        cout << "\n\tInforme o modelo do veiculo para correção: ";
                        cin >> it->modelo;
                        cin.get();

                        limpaTela();
                        dataAtual.mostraDataAtual();
                        cout << "\t=========VEICULO ALTERADO (MODELO)==========";
                        it->mostraDadosVeiculo(i);
                        cout << "\n\tModelo alterado com sucesso!...";
                        placa = "0";
                        pause();
                    }
                }
            }
            if (placa != "0")
            {
                limpaTela();
                cout << "\tOps, Veiculo não encontrado!...\n";
                pause();
            }
        }

        if (opcao == 3)
        {
            limpaTela();
            cout << "\tInforme a placa para consulta: ";
            getline(cin, placa);

            for (auto it = listVeiculos.veiculos.begin(); it != listVeiculos.veiculos.end(); ++it, i++)
            {
                if (it->placa == placa)
                {
                    limpaTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========VEICULO ENCONTRADO===========";
                    it->mostraDadosVeiculo(i);
                    pause();

                    do
                    {
                        cout << "\n\tDeseja alterar a cor desse veiculo?\n\t[1] SIM\n\t[0] NÃO\n\tENTRADA ->  ";
                        cin >> opcao;
                        cin.get();

                    } while (opcao < 0 && opcao > 1);

                    if (opcao == 1)
                    {
                        cout << "\n\tInforme a cor do veiculo para correção: ";
                        cin >> it->cor;
                        cin.get();

                        limpaTela();
                        dataAtual.mostraDataAtual();
                        cout << "\t=========VEICULO ALTERADO (COR)==========";
                        it->mostraDadosVeiculo(i);
                        cout << "\n\tCor alterada com sucesso!...";
                        placa = "0";
                        pause();
                    }
                }
            }
            if (placa != "0")
            {
                limpaTela();
                cout << "\tOps, Veiculo não encontrado!...\n";
                pause();
            }
        }

        if (opcao == 4)
        {
            limpaTela();
            cout << "\tInforme a placa para consulta: ";
            getline(cin, placa);

            for (auto it = listVeiculos.veiculos.begin(); it != listVeiculos.veiculos.end(); ++it, i++)
            {
                if (it->placa == placa)
                {
                    limpaTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========VEICULO ENCONTRADO===========";
                    it->mostraDadosVeiculo(i);
                    pause();

                    do
                    {
                        cout << "\n\tDeseja alterar a placa desse veiculo?\n\t[1] SIM\n\t[0] NÃO\n\tENTRADA ->  ";
                        cin >> opcao;
                        cin.get();

                    } while (opcao < 0 && opcao > 1);

                    if (opcao == 1)
                    {
                        cout << "\n\tInforme a placa do veiculo para correção: ";
                        cin >> it->placa;
                        cin.get();

                        limpaTela();
                        dataAtual.mostraDataAtual();
                        cout << "\t=========VEICULO ALTERADO (PLACA)==========";
                        it->mostraDadosVeiculo(i);
                        cout << "\n\tPlaca alterada com sucesso!...";
                        placa = "0";
                        pause();
                    }
                }
            }
            if (placa != "0")
            {
                limpaTela();
                cout << "\tOps, Veiculo não encontrado!...\n";
                pause();
            }
        }

        if (opcao == 5)
        {
            limpaTela();
            cout << "\tInforme a placa para consulta: ";
            getline(cin, placa);

            for (auto it = listVeiculos.veiculos.begin(); it != listVeiculos.veiculos.end(); ++it, i++)
            {
                if (it->placa == placa)
                {
                    limpaTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========VEICULO ENCONTRADO===========";
                    it->mostraDadosVeiculo(i);
                    pause();

                    do
                    {
                        cout << "\n\tDeseja alterar a data de retirada desse veiculo?\n\t[1] SIM\n\t[0] NÃO\n\tENTRADA ->  ";
                        cin >> opcao;
                        cin.get();

                    } while (opcao < 0 && opcao > 1);

                    if (opcao == 1)
                    {
                        cout << "\n\tInforme a data de retirada do veiculo para correção:\n";
                        it->dataHoraEntrega.lerDataRetirada();

                        limpaTela();
                        dataAtual.mostraDataAtual();
                        cout << "\t=========VEICULO ALTERADO (DATA RETIRADA)==========";
                        it->mostraDadosVeiculo(i);
                        cout << "\n\tData de retirada alterada com sucesso!...";
                        placa = "0";
                        pause();
                    }
                }
            }
            if (placa != "0")
            {
                limpaTela();
                cout << "\tOps, Veiculo não encontrado!...\n";
                pause();
            }
        }

        if (opcao == 6)
        {
            limpaTela();
            cout << "\tInforme a placa para consulta: ";
            getline(cin, placa);

            for (auto it = listVeiculos.veiculos.begin(); it != listVeiculos.veiculos.end(); ++it, i++)
            {
                if (it->placa == placa)
                {
                    limpaTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========VEICULO ENCONTRADO===========";
                    it->mostraDadosVeiculo(i);
                    pause();

                    do
                    {
                        cout << "\n\tDeseja alterar a data de entrega desse veiculo?\n\t[1] SIM\n\t[0] NÃO\n\tENTRADA ->  ";
                        cin >> opcao;
                        cin.get();

                    } while (opcao < 0 && opcao > 1);

                    if (opcao == 1)
                    {
                        cout << "\n\tInforme a data de entrega do veiculo para correção:\n";
                        it->dataHoraEntrega.lerDataEntrega();

                        limpaTela();
                        dataAtual.mostraDataAtual();
                        cout << "\t=========VEICULO ALTERADO (DATA ENTREGA)==========";
                        it->mostraDadosVeiculo(i);
                        cout << "\n\tData de entrega alterada com sucesso!...";
                        placa = "0";
                        pause();
                    }
                }
            }
            if (placa != "0")
            {
                limpaTela();
                cout << "\tOps, Veiculo não encontrado!...\n";
                pause();
            }
        }

        if (opcao == 7)
        {
            limpaTela();
            cout << "\tInforme a placa para consulta: ";
            getline(cin, placa);

            for (auto it = listVeiculos.veiculos.begin(); it != listVeiculos.veiculos.end(); ++it, i++)
            {
                if (it->placa == placa)
                {
                    limpaTela();
                    dataAtual.mostraDataAtual();
                    cout << "\t==========VEICULO ENCONTRADO===========";
                    it->mostraDadosVeiculo(i);
                    pause();

                    do
                    {
                        cout << "\n\tDeseja alterar a loja de retirada desse veiculo?\n\t[1] SIM\n\t[0] NÃO\n\tENTRADA ->  ";
                        cin >> opcao;
                        cin.get();

                    } while (opcao < 0 && opcao > 1);

                    if (opcao == 1)
                    {
                        cout << "\n\tInforme a loja de retirada do veiculo para correção: ";
                        cin >> it->lojaRetirada;
                        cin.get();

                        limpaTela();
                        dataAtual.mostraDataAtual();
                        cout << "\t=========VEICULO ALTERADO (LOJA RETIRADA)==========";
                        it->mostraDadosVeiculo(i);
                        cout << "\n\tLoja de retirada alterada com sucesso!...";
                        placa = "0";
                        pause();
                    }
                }
            }
            if (placa != "0")
            {
                limpaTela();
                cout << "\tOps, Veiculo não encontrado!...\n";
                pause();
            }
        }
        if (escolha > 7 || escolha < 0)
        {
            limpaTela();
            cout << "\tOps, opção invalida!...\n";
            pause();
        }

    } while (escolha != 0);
}

void localizarCliente(vector<Cliente> &listCliente)
{
    limpaTela();
    MinhaData dataAtual;
    string cpf;
    int i = 1;

    if (listCliente.empty())
    {

        cout << "\t==========PESQUISAR CLIENTE===========";
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
            limpaTela();
            dataAtual.mostraDataAtual();
            cout << "\t==========CLIENTE ENCONTRADO===========";
            it->mostraDadosCliente(i);
            pause();
            return;
        }
    }

    limpaTela();
    dataAtual.mostraDataAtual();
    cout << "\tOps, Cliente não encontrado!...\n";
    pause();
}

void localizarVeiculo(Cliente &listVeiculos)
{

    limpaTela();
    MinhaData dataAtual;
    string placa;
    int i = 1;

    if (listVeiculos.veiculos.empty())
    {
        cout << "\t==========PESQUISAR VEICULO===========\n";
        cout << "\n\tNão há veiculos cadastrados!...\n";
        pause();
        return;
    }

    cout << "\tInforme a placa para consulta: ";
    getline(cin, placa);

    for (auto it = listVeiculos.veiculos.begin(); it != listVeiculos.veiculos.end(); ++it, i++)
    {
        if (it->placa == placa)
        {
            limpaTela();
            dataAtual.mostraDataAtual();
            cout << "\t==========VEICULO ENCONTRADO===========";
            it->mostraDadosVeiculo(i);
            pause();
            return;
        }
    }

    limpaTela();
    dataAtual.mostraDataAtual();
    cout << "\tOps, Veiculo não encontrado!...\n";
    pause();
}

void locarVeiculo(vector<Cliente> &listCliente, Cliente &listVeiculos)
{
    int clienteOuVeiculo = menuEscolha();

    if (clienteOuVeiculo == 1)
    {
        if (listCliente.empty())
        {
            cout << "\n\tNão há clientes cadastrados!...\n";
            pause();
        }
        else
        {
            listVeiculos.locarVeiculo(listCliente);
        }
    }
    else
    {
        if (clienteOuVeiculo == 2)
        {
            if (listVeiculos.veiculos.empty())
            {
                cout << "\n\tNão há veiculos cadastrados!...\n";
                pause();
            }
            else
            {

                // Esta por enquanto pretendo listar veiculos disponiveis para locação...
                cout << "\n\tOps, Não é possivel locar um veiculo!...\n";
                pause();
            }
        }
        else
        {
            limpaTela();
            cout << "\n\tMenu encerrado com sucesso!...";
            pause();
        }
    }
}