#include <iostream>
#include <stdlib.h>
#include <vector>
#include <cstring>

using namespace std;
#define TAM

typedef struct
{
    string nome;
    float nota1;
    float nota2;
    float media;
    int totalDeAlunos;
} Aluno;

int menu(int opcao);

void inserir(Aluno &aluno, vector<Aluno> &listaDeAlunos);

bool limiteDeAlunos(vector<Aluno> &listaDeAlunos);

void inserirAlunosNovos(Aluno &aluno, vector<Aluno> &listaDeAlunos);

void listar(vector<Aluno> listaDeAlunos);

void listarPorOrdemAlfabetica(vector<Aluno> listaDeAlunos);

void excluir(vector<Aluno> &listaDeAlunos);

void listaDeAprovados(vector<Aluno> &listaDeAlunos);

void alterarNotas(vector<Aluno> &listaDeAlunos);

void gerarClassificacao(vector<Aluno> &listaDeAlunos);

int main()
{
    Aluno aluno;
    vector<Aluno> listaDeAlunos;
    vector<Aluno>::iterator it;
    it = listaDeAlunos.begin();

    int opcao = 0;
    bool sair = true;
    while (sair)
    {
        opcao = menu(opcao);
        switch (opcao)
        {
        case 1:

            inserir(aluno, listaDeAlunos);

            break;
        case 2:

            listarPorOrdemAlfabetica(listaDeAlunos);
            system("pause");
            system("cls");

            break;
        case 3:

            excluir(listaDeAlunos);

            break;
        case 4:

            inserirAlunosNovos(aluno, listaDeAlunos);

            break;
        case 5:

            listaDeAprovados(listaDeAlunos);

            break;
        case 6:

            alterarNotas(listaDeAlunos);

            break;
        case 7:

            gerarClassificacao(listaDeAlunos);

            break;
        case 8:

            system("cls");
            cout << "\nObrigado por Utilizar nosso Sistema de Controle de Notas!\n\n"
                 << endl;
            sair = false;

            break;
        default:

            cout << "\nOpcao invalida!\n"
                 << endl;
            system("pause");

            break;
        }
    }
}

int menu(int opcao)
{

    cout << ("\n\n___________________________________________________________________________________________________________________________________________________________");
    cout << ("\n{*****|*****|*****|*****|*****|*****|*****|*****|*****|*****|*****|************************************|*****|*****|*****|*****|*****|*****|*****|*****|**}\n");
    cout << ("{_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|____SISTEMA DE CONTROLE DE NOTAS ___|_____|_____|_____|_____|_____|_____|_____|_____|__}\n");
    cout << ("***********************************************************************************************************************************************************");

    cout << ("\n\n                                                        \t{****************************************}\n");
    cout << ("                                                         \t|1 - CADASTRAR ALUNOS                    |");
    cout << ("\n                                                        \t{________________________________________}\n");
    cout << ("                                                        \t|****************************************|");
    cout << ("\n                                                        \t{2 - LISTAR ALUNOS                       }");
    cout << ("\n                                                        \t|________________________________________|\n");
    cout << ("                                                         \t{****************************************}");
    cout << ("\n                                                        \t|3 - EXCLUIR ALUNO                       |");
    cout << ("\n                                                        \t{________________________________________}\n");
    cout << ("                                                         \t|****************************************|");
    cout << ("\n                                                        \t{4 -INSERIR ALUNO NOVOS                  }");
    cout << ("\n                                                        \t|________________________________________|\n");
    cout << ("                                                         \t{****************************************}");
    cout << ("\n                                                         \t|5 - LISTA DE APROVADOS E REPROVADOS     |");
    cout << ("\n                                                         \t{________________________________________}\n");
    cout << ("                                                         \t|****************************************|");
    cout << ("\n                                                        \t{6 - ALTERAR NOTAS                       }");
    cout << ("\n                                                        \t|________________________________________|\n");
    cout << ("                                                        \t{****************************************}");
    cout << ("\n                                                         \t|7 - GERAR CLASSIFICAÇÃO                 |");
    cout << ("\n                                                        \t{________________________________________}\n");
    cout << ("                                                          \t|****************************************|");
    cout << ("\n                                                        \t{8 - SAIR                                }");
    cout << ("\n                                                        \t|________________________________________|\n");
    cout << ("                                                        \t{*******}********************************}");
    cout << ("\n                                                        \t\7|ENTRADA|-->  ");
    cin >> opcao;

    return opcao;
    system("cls");
}

void inserir(Aluno &aluno, vector<Aluno> &listaDeAlunos)
{
    system("cls");

    // empty() -> Retorna true se o vetor estiver vazio
    if (listaDeAlunos.empty())
    {
        cout << "\nInforme a quantidade de alunos: ";
        cin >> aluno.totalDeAlunos;
        cin.get();

        for (int i = 0; i < aluno.totalDeAlunos; i++)
        {
            cout << "\n"
                 << i + 1 << "º Aluno:" << endl;

            cout << "Informe o nome do aluno: ";
            getline(cin, aluno.nome);

            cout << "Informe a 1º nota do aluno: ";
            cin >> aluno.nota1;

            cout << "Informe a 2º nota do aluno: ";
            cin >> aluno.nota2;

            aluno.media = (aluno.nota1 + aluno.nota2) / 2;

            listaDeAlunos.push_back(aluno);
            cin.get();
        }
        system("cls");
    }
    else
    {
        cout << "\nNão é permetido inserir mais alunos!...\n";
        system("pause");
    }

    limiteDeAlunos(listaDeAlunos);
}

bool limiteDeAlunos(vector<Aluno> &listaDeAlunos)
{
    std::vector<Aluno>::iterator it;
    it = listaDeAlunos.begin();
    bool limite;

    if (it->totalDeAlunos > listaDeAlunos.size())
    {
        limite = true;
    }
    else
    {
        limite = false;
    }
    return limite;
}

void inserirAlunosNovos(Aluno &aluno, vector<Aluno> &listaDeAlunos)
{
    system("cls");
    std::vector<Aluno>::iterator it;
    it = listaDeAlunos.begin();
    char opcao = 's';

    if (listaDeAlunos.empty())
    {
        cout << "\nA lista precisa ser inicializada, favor escolha a opção 1 do menu!...\n";
    }
    else
    {
        if (limiteDeAlunos(listaDeAlunos))
        {
            while (limiteDeAlunos(listaDeAlunos))
            {

                if (opcao == 's' || opcao == 'S')
                {
                    cout << "\nINCLUIR ALUNO NOVO :\n"
                         << endl;
                    cin.get();
                    cout << "Informe o nome do aluno: ";
                    getline(cin, it->nome);

                    cout << "\nInforme a 1º nota do aluno: ";
                    cin >> it->nota1;

                    cout << "\nInforme a 2º nota do aluno: ";
                    cin >> it->nota2;

                    it->media = (it->nota1 + it->nota2) / 2;

                    listaDeAlunos.push_back(aluno);

                    system("cls");
                    cout << "\nAluno cadastrado com sucesso!...\n";
                    cout << "\nDeseja continuar cadastrando aluno ?\nDigite [s] para sim, [n] para não:  ";
                    cin >> opcao;
                }
                if (opcao != 's' && opcao != 'n')
                {
                    system("cls");
                    cout << "\nOpção invalida!...\n";
                    cout << "\nDeseja continuar cadastrando aluno ?\nDigite [s] para continuar, [n] para sair:  ";
                    cin >> opcao;
                }
                if (opcao == 'n' || opcao == 'N')
                {
                    system("cls");
                    break;
                }
                if (limiteDeAlunos(listaDeAlunos))
                {
                    system("cls");
                    cout << "Continue!...";
                    break;
                }
                else
                {
                    system("cls");
                    cout << "\nOps, não esta sendo permitido cadastrar novos alunos, aguarde a segunda chamada, ou a exclusão de algum aluno!...\n";
                    system("pause");
                }
            }
        }
        else
        {
            system("cls");
            cout << "\nOps, não esta sendo permitido cadastrar novos alunos, aguarde a segunda chamada, ou a exclusão de algum aluno!...\n";
            system("pause");
        }
    }
}

void listar(vector<Aluno> listaDeAlunos)
{
    int i = 0;
    cout << "\n==============LISTA DE ALUNOS ORDENADOS EM ORDEM ALFABETICA==============\n";
    for (auto it = listaDeAlunos.begin(); it != listaDeAlunos.end(); it++)
    {
        cout << "\n"
             << ++i << "º Aluno:" << endl;
        cout << "\nNome: " << it->nome
             << "| 1º Nota = " << it->nota1
             << "| 2º Nota = " << it->nota2
             << "| Media = " << it->media << endl;
        cout << "=========================================================================\n";
    }
}

void listarPorOrdemAlfabetica(vector<Aluno> listaDeAlunos)
{
    system("cls");
    int n = listaDeAlunos.size();
    bool trocou;
    Aluno aux;

    do
    {
        trocou = false;
        for (int j = 0; j < n - 1; j++)
        {
            if (listaDeAlunos[j].nome > listaDeAlunos[j + 1].nome)
            {
                aux = listaDeAlunos[j];
                listaDeAlunos[j] = listaDeAlunos[j + 1];
                listaDeAlunos[j + 1] = aux;
                trocou = true;
            }
        }
        n--;
    } while (trocou);

    listar(listaDeAlunos);
}
void excluir(vector<Aluno> &listaDeAlunos)
{

    system("cls");
    string nome;
    char opcao;
    bool sair = true;

    cout << "\n=================EXCLUSÃO DE ALUNOS=================\n";
    while (sair)
    {
        if (listaDeAlunos.empty())
        {
            system("cls");
            cout << "\nLista vazia, não possui alunos para exclusão!...\n";
            system("pause");
            sair = false;
        }
        else
        {
            cout << "\nInforme o nome do aluno, para exclusão:  ";
            cin >> nome;

            for (auto it = listaDeAlunos.begin(); it != listaDeAlunos.end(); it++)
            {
                if (it->nome == nome)
                {
                    listaDeAlunos.erase(it);
                    nome = "null";
                }
            }
        }
        if (nome == "null")
        {
            system("cls");
            cout << "\nAluno excluido com sucesso!...\n";
            system("pause");
        }
        else
        {
            system("cls");
            cout << "\nAluno não encontrado!...\n";
            system("pause");
        }

        if (sair)
        {
            system("cls");
            cout << "\nDeseja continuar fazendo a exclusão de alunos ?\nDigite [s] para sim, [n] para não:  ";
            cin >> opcao;

            if (opcao != 's' && opcao != 'n')
            {
                system("cls");
                cout << "\nOpção invalida!...\n";
                cout << "\nDeseja continuar fazendo a exclusão de alunos?\nDigite [s] para sim, [n] para não:  ";
                cin >> opcao;
            }
            if (opcao == 'n' || opcao == 'N')
            {
                sair = false;
            }
        }
    }
}
void listaDeAprovados(vector<Aluno> &listaDeAlunos)
{
    int i = 0;
    system("cls");
    cout << "\n================LISTA DE APROVADOS================\n";
    for (auto it = listaDeAlunos.begin(); it != listaDeAlunos.end(); it++)
    {
        if (it->media >= 7)
        {
            cout << "\n"
                 << ++i << "º Aluno:" << endl;
            cout << "\nNome: " << it->nome
                 << "| 1º Nota = " << it->nota1
                 << "| 2º Nota = " << it->nota2
                 << "| Media = " << it->media << endl;
            cout << "===============================================\n";
        }
    }
    cout << "\n================LISTA DE REPROVADOS================\n";
    for (auto it = listaDeAlunos.begin(); it != listaDeAlunos.end(); it++)
    {
        if (it->media < 7)
        {
            cout << "\n"
                 << ++i << "º Aluno:" << endl;
            cout << "\nNome: " << it->nome
                 << "| 1º Nota = " << it->nota1
                 << "| 2º Nota = " << it->nota2
                 << "| Media = " << it->media << endl;
            cout << "===============================================\n";
        }
    }
    system("pause");
}
void alterarNotas(vector<Aluno> &listaDeAlunos)
{

    system("cls");
    string nome;
    char opcao;
    int x = 0;
    bool sair = true;

    cout << "\n=================ALTERAÇÃO DE NOTAS=================\n";
    while (sair)
    {
        if (listaDeAlunos.empty())
        {
            system("cls");
            cout << "\nLista vazia, não possui alunos para alteração de notas!...\n";
            system("pause");
            sair = false;
        }
        else
        {
            cout << "\nInforme o nome do aluno, para alteração de notas:  ";
            cin >> nome;

            while (sair)
            {
                for (int i = 0; i < listaDeAlunos.size(); i++)
                {
                    if (listaDeAlunos[i].nome == nome)
                    {
                        system("cls");
                        nome = "null";
                        x = i;
                        cout << "\n"
                             << i + 1 << "º Aluno:" << endl;
                        cout << "\nNome: " << listaDeAlunos[i].nome
                             << "| 1º Nota = " << listaDeAlunos[i].nota1
                             << "| 2º Nota = " << listaDeAlunos[i].nota2
                             << "| Media = " << listaDeAlunos[i].media << endl;
                        cout << "================================================\n";
                    }
                }
                if (nome == "null")
                {
                    cout << "\nDeseja alterar a nota [1], nota [2] ou [0] para sair:  ";
                    cin >> opcao;

                    if (opcao == '0')
                    {
                        system("cls");
                        sair = false;
                        break;
                    }
                    else
                    {
                        if (opcao == '1')
                        {
                            system("cls");
                            cout << "\nInforme a 1º nota do aluno: ";
                            cin >> listaDeAlunos[x].nota1;
                            cout << "1º Nota alterada com sucesso!...\n";
                            listaDeAlunos[x].media = (listaDeAlunos[x].nota1 + listaDeAlunos[x].nota2) / 2;
                            cout << "\n"
                                 << x + 1 << "º Aluno:" << endl;
                            cout << "\nNome: " << listaDeAlunos[x].nome
                                 << "| 1º Nota = " << listaDeAlunos[x].nota1
                                 << "| 2º Nota = " << listaDeAlunos[x].nota2
                                 << "| Media = " << listaDeAlunos[x].media << endl;
                            cout << "================================================\n";
                        }
                        else
                        {
                            if (opcao == '2')
                            {
                                system("cls");
                                cout << "\nInforme a 2º nota do aluno: ";
                                cin >> listaDeAlunos[x].nota2;
                                cout << "2º Nota alterada com sucesso!...\n";
                                listaDeAlunos[x].media = (listaDeAlunos[x].nota1 + listaDeAlunos[x].nota2) / 2;
                                cout << "\n"
                                     << x + 1 << "º Aluno:" << endl;
                                cout << "\nNome: " << listaDeAlunos[x].nome
                                     << "| 1º Nota = " << listaDeAlunos[x].nota1
                                     << "| 2º Nota = " << listaDeAlunos[x].nota2
                                     << "| Media = " << listaDeAlunos[x].media << endl;
                                cout << "================================================\n";
                            }
                            else
                            {
                                system("cls");
                                cout << "\nOpção invalida!...\n";
                                cout << "\nDeseja continuar fazendo a alteração de notas?\nDigite [s] para sim, [n] para não:  ";
                                cin >> opcao;
                            }
                        }
                    }
                }
                if (nome == "null")
                {
                    system("pause");
                }
                else
                {
                    system("cls");
                    cout << "\nAluno não encontrado!...\n";
                    system("pause");
                }
                sair = true;
                if (sair)
                {
                    system("cls");
                    cout << "\nDeseja continuar fazendo a alteração de notas do mesmo aluno?\nDigite [s] para sim, [n] para não:  ";
                    cin >> opcao;

                    if (opcao == 's' || opcao == 'S')
                    {
                        system("cls");
                    }
                    else
                    {
                        while (sair)
                        {
                            cout << "\nInforme o nome do aluno, para alteração de notas:  ";
                            cin >> nome;

                            for (int i = 0; i < listaDeAlunos.size(); i++)
                            {
                                if (listaDeAlunos[i].nome == nome)
                                {
                                    system("cls");
                                    nome = "null";
                                    sair = false;
                                    opcao = 's';
                                    x = i;
                                    cout << "\n"
                                         << i + 1 << "º Aluno:" << endl;
                                    cout << "\nNome: " << listaDeAlunos[i].nome
                                         << "| 1º Nota = " << listaDeAlunos[i].nota1
                                         << "| 2º Nota = " << listaDeAlunos[i].nota2
                                         << "| Media = " << listaDeAlunos[i].media << endl;
                                    cout << "================================================\n";
                                }
                            }
                            if (nome != "null")
                            {
                                system("cls");
                                cout << "\nAluno não encontrado!...\n";
                                system("pause");
                            }
                        }
                    }
                    sair = true;
                    if (opcao != 's' && opcao != 'n')
                    {
                        system("cls");
                        cout << "\nOpção invalida!...\n";
                        cout << "\nDeseja continuar fazendo a alteração de notas?\nDigite [s] para sim, [n] para não:  ";
                        cin >> opcao;
                    }
                    if (opcao == 'n' || opcao == 'N')
                    {
                        sair = false;
                    }
                }
            }
        }
    }
}
void gerarClassificacao(vector<Aluno> &listaDeAlunos)
{

    system("cls");
    int n = listaDeAlunos.size();
    int i = 0;
    bool trocou;
    Aluno aux;

    do
    {
        trocou = false;
        for (int j = 0; j < n - 1; j++)
        {
            if (listaDeAlunos[j].media < listaDeAlunos[j + 1].media)
            {
                aux = listaDeAlunos[j];
                listaDeAlunos[j] = listaDeAlunos[j + 1];
                listaDeAlunos[j + 1] = aux;
                trocou = true;
            }
        }
        n--;
    } while (trocou);

    cout << "\n================LISTA DE CLASSIFICAÇÃO================\n";

    system("cls");
    cout << "\n================LISTA DE APROVADOS================\n";
    for (auto it = listaDeAlunos.begin(); it != listaDeAlunos.end(); it++)
    {
        if (it->media >= 7)
        {
            cout << "\n"
                 << ++i << "º Aluno:" << endl;
            cout << "\nNome: " << it->nome
                 << "| 1º Nota = " << it->nota1
                 << "| 2º Nota = " << it->nota2
                 << "| Media = " << it->media << endl;
            cout << "===============================================\n";
        }
    }
    cout << "\n================LISTA DE REPROVADOS================\n";
    for (auto it = listaDeAlunos.begin(); it != listaDeAlunos.end(); it++)
    {
        if (it->media < 7)
        {
            cout << "\n"
                 << ++i << "º Aluno:" << endl;
            cout << "\nNome: " << it->nome
                 << "| 1º Nota = " << it->nota1
                 << "| 2º Nota = " << it->nota2
                 << "| Media = " << it->media << endl;
            cout << "================================================\n";
        }
    }

    cout << "Retonar ao menu principal, ";
    system("pause");
}
