/*Exercício 5: Abstração e Modularização
• Em grupo, escolham um objeto do mundo real (por exemplo, um carro) e identifiquem suas características e comportamentos.
• Dividam o objeto em partes menores e atribuam a cada membro a responsabilidade por modelar uma parte como uma struct.
• Juntem as structs criadas por cada membro para formar uma representação completa do objeto.*/

#include <iostream>
#include <cstdlib>
#include <vector>

using namespace std;

typedef struct
{
    int id = 0;
    string marca;
    string placa;
    string modelo;
    string cor;
    int marchaAtual;
    double velocidadeAtual;

} Veiculo;

void cadastrar(Veiculo &veiculo, vector<Veiculo> &veiculos);

void listar(vector<Veiculo> &veiculos);

void editar(vector<Veiculo> &veiculos);

void remover(vector<Veiculo> *veiculos);

void veiculoComportamentos(vector<Veiculo> &veiculos);

void sistemaDeGestaoConsercionariaIlheus(vector<Veiculo> &veiculos);

Veiculo retornarVeiculo(vector<Veiculo> &veiculos, int id);

void limparTela();

void pause();

int menu();

int main()
{
    vector<Veiculo> veiculos;

    sistemaDeGestaoConsercionariaIlheus(veiculos);
}

int menu()
{
    limparTela();
    int opcao = 0;

    do
    {
        cout << "\n===============MENU===============";
        cout << "\n[1] - CADASTRAR VEICULO:";
        cout << "\n[2] - LISTAR VEICULOS:";
        cout << "\n[3] - EDITAR VEÍCULO:";
        cout << "\n[4] - EXCLUIR VEICULO:";
        cout << "\n[5] - SAIR COM O VEÍCULO:";
        cout << "\n[0] - SAIR";
        cout << "\nENTRADA ->  ";
        cin >> opcao;
        cin.get();

        if (opcao > 5 || opcao < 0)
        {
            limparTela();
            cout << "Ops, escolha invalida!...\n";
            pause();
        }

    } while (opcao > 4 || opcao < 0);

    return opcao;
}

void cadastrar(Veiculo &veiculo, vector<Veiculo> &veiculos)
{
    limparTela();

    cout << "\n==========CADASTRAR VEICULOS==========\n";

    cout << "\nInforme a marca do veículo: ";
    getline(cin, veiculo.marca);

    cout << "\nInforme o modelo do veiculo: ";
    getline(cin, veiculo.modelo);

    cout << "\nInforme a cor do veiculo: ";
    getline(cin, veiculo.cor);

    cout << "\nInforme a placa do veiculo: ";
    getline(cin, veiculo.placa);

    veiculo.id++;

    veiculos.push_back(veiculo);
    pause();
}

void listar(vector<Veiculo> &veiculos)
{
    limparTela();

    if (veiculos.empty())
    {
        cout << "\nNenhum veiculo cadastrado!\n";
        pause();
        return;
    }

    for (auto it = veiculos.begin(); it != veiculos.end(); it++)
    {
        cout << "\n" << it->id << "º Veiculo";
        cout << "\n======================================";
        cout << "\nMarca do Veiculo: " << it->marca << endl;
        cout << "\nModelo do Veiculo: " << it->modelo << endl;
        cout << "\nCor do Veiculo: " << it->cor << endl;
        cout << "\nPlaca do Veiculo: " << it->placa << endl;
        cout << "======================================\n";
    }
    pause();
}

void editar(vector<Veiculo> &veiculos)
{
    limparTela();
    auto it = veiculos.begin();

    if (veiculos.empty())
    {
        cout << "\nNenhum veiculo cadastrado!\n";
        pause();
        return;
    }

    int id = 0;

    cout << "\n===============EDITAR===============\n";

    cout << "\nInforme o id do veiculo para pesquisar: ";
    cin >> id;
    cin.get();
    limparTela();

    *it = retornarVeiculo(veiculos, id);

    if (it->id == id)
    {
        cout << "\n==========EDITAR VEICULOS==========\n";
        cout << "\nInforme a marca do veículo: ";
        getline(cin, it->marca.assign(it->marca));

        cout << "\nInforme o modelo do veiculo: ";
        getline(cin, it->modelo.assign(it->modelo));

        cout << "\nInforme a cor do veiculo: ";
        getline(cin, it->cor.assign(it->cor));

        cout << "\nInforme a placa do veiculo: ";
        getline(cin, it->placa.assign(it->placa));

        pause();
    }
    else
    {
        cout << "\nVeiculo não encontrado!\n";
        pause();
        return;
    }
}

void remover(vector<Veiculo> &veiculos)
{
    limparTela();
    int id = 0;
    auto it = veiculos.begin();

    if (veiculos.empty())
    {
        cout << "\nNenhum veiculo cadastrado!\n";
        pause();
        return;
    }

    cout << "\n===============REMOVER===============\n";

    cout << "\nInforme o id do veiculo para remover: ";
    cin >> id;
    cin.get();
    limparTela();

    *it = retornarVeiculo(veiculos, id);

    if (it->id == id)
    {
        veiculos.erase(it);
        cout << "\nVeiculo removido com sucesso!\n";
        pause();
        return;
    }
}

void veiculoComportamentos(vector<Veiculo> &veiculos)
{

    if (veiculos.empty())
    {
        cout << "\nNenhum veiculo cadastrado!\n";
        pause();
        return;
    }

    int id = 0;

    cout << "\nInforme o id do veiculo para remover: ";
    cin >> id;
    cin.get();

    limparTela();

    for (auto it = veiculos.begin(); it != veiculos.end(); it++)
    {
        if (it->id == id)
        {
            listar(veiculos);
            pause();
            return;
        }
    }
}

void sistemaDeGestaoConsercionariaIlheus(vector<Veiculo> &veiculos)
{
    int opcao = 0;
    Veiculo veiculo;

    do
    {
        switch (opcao = menu())
        {
        case 1:

            cadastrar(veiculo, veiculos);

            break;

        case 2:

            listar(veiculos);

            break;

        case 3:

            editar(veiculos);

            break;

        case 4:

            remover(veiculos);

            break;

        case 5:

            veiculoComportamentos(veiculos);

            break;

        case 0:

            limparTela();
            cout << "Saindo do sistema...\n";
            pause();

            break;

        default:

            cout << "Opção invalida!";

            break;
        }

    } while (opcao != 0);
}

Veiculo retornarVeiculo(vector<Veiculo> &veiculos, int id)
{
    if (id > veiculos.size())
    {
        cout << "\nVeiculo não encontrado!\n";
        pause();
    }
    else if (id < 0)
    {
        cout << "\nVeiculo não encontrado!\n";
        pause();
    }
    for (auto it = veiculos.begin(); it != veiculos.end(); it++)
    {
        if (it->id == id)
        {
            cout << "\n" << it->id << "º Veiculo";
            cout << "\n======================================";
            cout << "\nMarca do Veiculo: " << it->marca << endl;
            cout << "\nModelo do Veiculo: " << it->modelo << endl;
            cout << "\nCor do Veiculo: " << it->cor << endl;
            cout << "\nPlaca do Veiculo: " << it->placa << endl;
            cout << "======================================\n";
            return *it; // retorna o veiculo
        }
    }

    cout << "\nVeiculo não encontrado!\n";
    pause();
}

bool ligarMotor()
{
    return true;
}

bool desligarMotor()
{
    return false;
}

void limparTela()
{
#ifdef _WIN32
    system("cls");
#else
    system("clear");
#endif
}

void pause()
{
    cout << "\nDigite enter para continuar!\n";
    cin.get();
    limparTela();
}