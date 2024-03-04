#ifndef RETANGULO_H
#define RETANGULO_H
#include <iostream>
#include "Forma.h"

using namespace std;

#pragma once

class Retangulo : Forma
{
public:

    float A = 0;
    Forma f;

    Retangulo(){
        this->f.base = f.base;
        this->f.altura = f.altura;
    }

    ~Retangulo(){}

    float getA(){
        return this->A;
    }

    void setA(float c){
        this->A = c;
    }

    float calcularArea(){
        return this->A = f.getBase() * f.getAltura();
    }

private:

};

#endif