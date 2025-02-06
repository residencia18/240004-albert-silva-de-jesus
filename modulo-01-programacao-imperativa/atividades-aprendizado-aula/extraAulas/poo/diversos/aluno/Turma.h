#ifndef TURMA_H
#define TURMA_H
#include <iostream>
#include "Aluno.h"
#include <vector>
using namespace std;

#pragma once

class Turma
{

private:
    vector<Aluno> alunos;

public:
    Turma() {}

    ~Turma() {}

    void adicionarAlunos(Aluno &aluno)
    {
        alunos.push_back(aluno);
    }

    void lerAlunos(Aluno &aluno)
    {

        string nome;
        int identificacao;

        cout << "\n\tDigite o nome do aluno: ";
        getline(cin, nome);
        aluno.setNome(nome);

        cout << "\n\tDigite o identificador do aluno: ";
        cin >> identificacao;
        aluno.setIdentificacao(identificacao);

        adicionarAlunos(aluno);
    }

    void listarAlunos()
    {
        for (auto it = alunos.begin(); it != alunos.end(); it++)
        {
            cout << "\n\tNome: " << it->getNome();
            cout << "\n\tIdentificação: " << it->getIdentificacao() << endl;
        }
    }
};

#endif