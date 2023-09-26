#include <iostream>
#ifndef MAUSOLEU_H
#define MAUSOLEU_H
#include "Paciente.h"
#include <vector>
using namespace std;

#pragma once

class Mausoleu
{
public:
    string localizacao;
    vector<Paciente> paciente;
    Mausoleu();
    ~Mausoleu();

    void setLocalizacao(string localizacao){
        this->localizacao = localizacao;
    }

    string getLocalizacao(){
        return this->localizacao;
    }

private:

};

#endif