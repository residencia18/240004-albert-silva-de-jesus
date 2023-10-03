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

    Turma();

    ~Turma();

    void adicionarAlunos(){
        alunos.push_back(alunos);
    }

    void listarAlunos(){
        for(auto it = alunos.begin(); it != alunos.end(); it++){
            cout << "\n\tNome: " << it->getNome();
            cout << "\n\tIdentificação: " << it->getIdentificacao();
        }
    }

};

#endif