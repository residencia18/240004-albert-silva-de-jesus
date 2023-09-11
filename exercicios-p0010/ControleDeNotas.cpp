#include <iostream>
#include <stdlib.h>
#include <vector>
#include <cstring>

using namespace std;

typedef struct
{
    string nome;
    float nota1;
    float nota2;
    float media;
    int totalDeAlunos;
} Aluno;

void limparTela();

void pausar();

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
            pausar();
            limparTela();
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

            limparTela();
            cout << "\nObrigado por Utilizar nosso Sistema de Controle de Notas!\n\n"
                 << endl;
            sair = false;

            break;
        default:

            cout << "\nOpcao invalida!\n"
                 << endl;
            pausar();

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
    limparTela();
}

void inserir(Aluno &aluno, vector<Aluno> &listaDeAlunos)
{
    limparTela();

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
            do
            {
                cout << "Informe a 1º nota do aluno: ";
                cin >> aluno.nota1;
                if (aluno.nota1 > 10 || aluno.nota1 < 0)
                {
                    cout << "**Nota Inválida**" << endl;
                }
            } while (aluno.nota1 > 10 || aluno.nota1 < 0);

            do
            {
                cout << "Informe a 2º nota do aluno: ";
                cin >> aluno.nota2;
                if (aluno.nota2 > 10 || aluno.nota2 < 0)
                {
                    cout << "**Nota Inválida**" << endl;
                }
            } while (aluno.nota2 > 10 || aluno.nota2 < 0);
            aluno.media = (aluno.nota1 + aluno.nota2) / 2;

            listaDeAlunos.push_back(aluno);
            cin.get();
        }
        limparTela();
    }
    else
    {
        cout << "\nNão é permetido inserir mais alunos!...\n";
        pausar();
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
    limparTela();
    std::vector<Aluno>::iterator it;
    it = listaDeAlunos.begin();
    char opcao = 's';

    if (listaDeAlunos.empty())
    {
        cout << "\nA lista precisa ser inicializada, favor escolha a opção 1 do menu!...\n";
        pausar();
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

                    do
                    {
                        cout << "Informe a 1º nota do aluno: ";
                        cin >> it->nota1;
                        if (it->nota1 > 10 || it->nota1 < 0)
                        {
                            cout << "**Nota Inválida**" << endl;
                        }
                    } while (it->nota1 > 10 || it->nota1 < 0);

                    do
                    {
                        cout << "Informe a 2º nota do aluno: ";
                        cin >> it->nota2;
                        if (it->nota2 > 10 || it->nota2 < 0)
                        {
                            cout << "**Nota Inválida**" << endl;
                        }
                    } while (it->nota2 > 10 || it->nota2 < 0);

                    it->media = (it->nota1 + it->nota2) / 2;

                    listaDeAlunos.push_back(aluno);

                    limparTela();
                    cout << "\nAluno cadastrado com sucesso!...\n";
                    cout << "\nDeseja continuar cadastrando aluno ?\nDigite [s] para sim, [n] para não:  ";
                    cin >> opcao;
                }
                if (opcao != 's' && opcao != 'n')
                {
                    limparTela();
                    cout << "\nOpção invalida!...\n";
                    cout << "\nDeseja continuar cadastrando aluno ?\nDigite [s] para continuar, [n] para sair:  ";
                    cin >> opcao;
                }
                if (opcao == 'n' || opcao == 'N')
                {
                    limparTela();
                    break;
                }
                if (limiteDeAlunos(listaDeAlunos))
                {
                    limparTela();
                    cout << "Continue!...";
                    break;
                }
                else
                {
                    limparTela();
                    cout << "\nOps, não esta sendo permitido cadastrar novos alunos, aguarde a segunda chamada, ou a exclusão de algum aluno!...\n";
                    pausar();
                }
            }
        }
        else
        {
            limparTela();
            cout << "\nOps, não esta sendo permitido cadastrar novos alunos, aguarde a segunda chamada, ou a exclusão de algum aluno!...\n";
            pausar();
        }
    }
}

void listar(vector<Aluno> listaDeAlunos)
{

    if (listaDeAlunos.empty())
    {
        cout << "\nA lista precisa ser inicializada, favor escolha a opção 1 do menu!...\n";
        return;
    }

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
    limparTela();
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
    limparTela();
    string nome;
    char opcao;
    bool sair = true;

    cout << "\n=================EXCLUSÃO DE ALUNOS=================\n";
    while (sair)
    {
        if (listaDeAlunos.empty())
        {
            limparTela();
            cout << "\nLista vazia, não possui alunos para exclusão!...\n";
            pausar();
            sair = false;
        }
        else
        {
            cout << "\nInforme o nome do aluno, para exclusão:  ";
            cin >> nome;
            bool alunoEncontrado = false;

            for (auto it = listaDeAlunos.begin(); it != listaDeAlunos.end();)
            {
                if (it->nome == nome)
                {
                    it = listaDeAlunos.erase(it); // Remove o aluno e atualiza o iterador
                    alunoEncontrado = true;
                    break;
                }
                else
                {
                    ++it; // Avança para o próximo aluno
                }
            }

            if (alunoEncontrado)
            {
                limparTela();
                cout << "\nAluno excluído com sucesso!...\n";
                pausar();
            }
            else
            {
                limparTela();
                cout << "\nAluno não encontrado!...\n";
                pausar();
            }
        }

        if (sair)
        {
            limparTela();
            cout << "\nDeseja continuar fazendo a exclusão de alunos ?\nDigite [s] para sim, [n] para não:  ";
            cin >> opcao;

            if (opcao != 's' && opcao != 'n')
            {
                limparTela();
                cout << "\nOpção inválida!...\n";
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

    if (listaDeAlunos.empty())
    {
        limparTela();
        cout << "\nLista vazia, não possui alunos para alteração de notas!...\n";
        pausar();
        return;
    }

    int i = 0;
    limparTela();
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
    pausar();
}
void alterarNotas(vector<Aluno> &listaDeAlunos)
{

    limparTela();
    string nome;
    char opcao;
    int x = 0;
    bool sair = true;

    cout << "\n=================ALTERAÇÃO DE NOTAS=================\n";
    while (sair)
    {
        if (listaDeAlunos.empty())
        {
            limparTela();
            cout << "\nLista vazia, não possui alunos para alteração de notas!...\n";
            pausar();
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
                        limparTela();
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
                        limparTela();
                        sair = false;
                        break;
                    }
                    else
                    {
                        if (opcao == '1')
                        {
                            limparTela();
                            do
                            {
                                cout << "\nInforme a 1º nota do aluno: ";
                                cin >> listaDeAlunos[x].nota1;
                                if (listaDeAlunos[x].nota1 < 0 || listaDeAlunos[x].nota1 > 10)
                                {
                                    cout << "**Nota Inválida**" << endl;
                                }
                            } while (listaDeAlunos[x].nota1 < 0 || listaDeAlunos[x].nota1 > 10);
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
                                limparTela();
                                do
                                {
                                    cout << "\nInforme a 2º nota do aluno: ";
                                    cin >> listaDeAlunos[x].nota2;
                                    if (listaDeAlunos[x].nota2 < 0 || listaDeAlunos[x].nota2 > 10)
                                    {
                                        cout << "**Nota Inválida**" << endl;
                                    }
                                } while (listaDeAlunos[x].nota2 < 0 || listaDeAlunos[x].nota2 > 10);
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
                                limparTela();
                                cout << "\nOpção invalida!...\n";
                                cout << "\nDeseja continuar fazendo a alteração de notas?\nDigite [s] para sim, [n] para não:  ";
                                cin >> opcao;
                            }
                        }
                    }
                }
                if (nome == "null")
                {
                    pausar();
                }
                else
                {
                    limparTela();
                    cout << "\nAluno não encontrado!...\n";
                    pausar();
                }
                sair = true;
                if (sair)
                {
                    limparTela();
                    cout << "\nDeseja continuar fazendo a alteração de notas do mesmo aluno?\nDigite [s] para sim, [n] para não:  ";
                    cin >> opcao;

                    if (opcao == 's' || opcao == 'S')
                    {
                        limparTela();
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
                                    limparTela();
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
                                limparTela();
                                cout << "\nAluno não encontrado!...\n";
                                pausar();
                            }
                        }
                    }
                    sair = true;
                    if (opcao != 's' && opcao != 'n')
                    {
                        limparTela();
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

    if (listaDeAlunos.empty())
    {
        limparTela();
        cout << "\nLista vazia, não possui alunos para alteração de notas!...\n";
        pausar();
        return;
    }

    limparTela();
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

    limparTela();
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
    pausar();
}

void limparTela()
{
#ifdef _WIN32 // Se for Windows
    system("cls");
#else // Se for Linux ou macOS
    system("clear");
#endif
}

void pausar()
{
#ifdef WIN32
    system("pause");
#else
    char c;
    cout << "Pressione qualquer tecla...";
    c = getchar();
    c = getchar();
#endif
}
