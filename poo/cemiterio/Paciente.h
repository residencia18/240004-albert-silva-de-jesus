#include <iostream>
#ifndef PACIENTE_H
#define PACIENTE_H

using namespace std;

#pragma once

class Paciente
{   

private:
    string nome;
    string dataMorte;
public: 
    Paciente();
    ~Paciente();
    void setNome(string nome){
        this->nome = nome;
    }
    void setDataMorte(string dataMorte){
        this->dataMorte = dataMorte;
    }
    string getNome(){
        return this->nome;
    }
    string getDataMorte(){
        return this->dataMorte;
    }  
};

#endif