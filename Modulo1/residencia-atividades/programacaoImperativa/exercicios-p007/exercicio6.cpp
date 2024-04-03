/*Exercício 1: Instale e configure o Git

Exercício 6:
Desenvolva um programa que receba a matrícula (apenas números) e 3 notas de um grupo de alunos. A cada aluno cadastrado o programa deve perguntar se deseja prosseguir com outro. Em seguida, calcule a média de cada aluno e imprima os dados da seguinte forma:

MATRICULA NOTA1 NOTA2 NOTA3 MEDIA
===========================================
123456789 10.0 8.0 9.9 8.5
MATRICULA NOTA1 NOTA2 NOTA3 MEDIA
===========================================
123456789 10.0 8.0 9.9 8.5
MATRICULA NOTA1 NOTA2 NOTA3 MEDIA
===========================================
123456789 10.0 8.0 9.9 8.5*/

#include <iostream>
#include <vector>
using namespace std;

typedef struct
{
    int matricula;
    float notas[3];
    float media = 0;
} Aluno;

int main()
{
    vector<Aluno> listaAlunos;
    Aluno aluno;
    int opcao = 1;
    int cont = 0;
    float soma = 0;

    while (opcao == 1)
    {
        cout << "\nDigite a matricula do aluno: ";
        cin >> aluno.matricula;
        for (int i = 0; i < 3; i++)
        {
            cout << "Digite a nota " << i + 1 << " do aluno: ";
            cin >> aluno.notas[i];
            soma += aluno.notas[i];
        }
        aluno.media = soma / 3;
        listaAlunos.push_back(aluno);
        soma = 0;
        cout << "\nDeseja cadastrar outro aluno? (1 - Sim, 2 - Nao): ";
        cin >> opcao;
    }
    cout << ("\nMATRICULA      NOTA1    NOTA2    NOTA3    MEDIA\n");
    for (int i = 0; i < listaAlunos.size(); ++i)
    {
        printf("%-10d      %-5.1f    %-5.1f    %-5.1f    %-5.1f\n", listaAlunos[i].matricula, listaAlunos[i].notas[0], listaAlunos[i].notas[1], listaAlunos[i].notas[2], listaAlunos[i].media);
        cout << ("-----------------------------------------------\n");
        cout << ("-----------------------------------------------\n");
    }
}