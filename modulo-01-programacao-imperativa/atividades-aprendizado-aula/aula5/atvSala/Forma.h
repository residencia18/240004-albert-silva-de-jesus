#ifndef FORMA_H
#define FORMA_H

#pragma once

class Forma
{
private:

public:

    float base =0;
    float altura =0;

    Forma(float base2, float altura2)
    {
        this->base = base2;
        this->altura = altura2;
    }

    Forma() {}

    ~Forma() {}

    float getBase(){
        return this->base;
    }

    void setBase(float base1){
        this->base = base1;
    }

    float getAltura(){
        return this->altura;
    }

    void setAltura(float altura1){
        this->altura = altura1;
    }

    float calcularArea();
};

#endif