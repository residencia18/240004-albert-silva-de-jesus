#ifndef CACHORRO_H
#define CACHORRO_H
#include <iostream>
#include "Animal.h"

using namespace std;

#pragma once

class Cachorro : Animal
{
public:

    Cachorro(){}

    ~Cachorro(){}

    void fazerSom(){
        cout << "\n\tAu Au!" << endl;
    }

private:

};

#endif