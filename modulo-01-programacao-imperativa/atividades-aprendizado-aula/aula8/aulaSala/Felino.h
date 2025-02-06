#ifndef FELINO_H
#define FELINO_H
#include <iostream>
#include "Animal.h"

using namespace std;

#pragma once

class Felino : Animal
{
public:

    Felino(){}

    ~Felino(){}

    void fazerSom(){
        cout << "\n\tMiau Miau!" << endl;
    }

private:

};

#endif