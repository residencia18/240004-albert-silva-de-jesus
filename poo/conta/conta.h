#include <iostream>
#ifndef CONTA_H
#define CONTA_H

using namespace std;

#pragma once

class conta
{
public:
    float saldo;

    conta()
    {
        saldo = 0;
    }
    ~conta(){
        cout << "Destrutor chamado" << endl;
    }

    float getSaldo()
    {
        return saldo;
    }

    void setSaldo(float saldo)
    {
        this->saldo = saldo;
    }

    void depositar(float valor)
    {
        saldo += valor;
    }

private:
};

#endif