#include <iostream>
#include <math.h>
#ifndef PONTO_H
#define PONTO_H

using namespace std;

#pragma once

class Ponto
{

public:

    float x, y;

    Ponto(float x, float y);

    Ponto(){
    }

    ~Ponto(){
    }

    float getX()
    {
        return x;
    }

    void setX(float x)
    {
        this->x = x;
    }

    float getY()
    {
        return y;
    }

    void setY(float y)
    {
        this->y = y;
    }

    void lerPonto()
    {
        cout << "\n\tDigite as coordenadas do ponto: ";
        cout << "\n\tX: ";
        cin >> x;
        cout << "\n\tY: ";
        cin >> y;
    }

    string escrevePonto()
    {
        return to_string(x) + ", " + to_string(y);
    }

    float distancia(Ponto p)
    {
        return sqrt(pow(x - p.getX(), 2) + pow(y - p.getY(), 2));
    }

    bool operator==(Ponto p)
    {
        return p.getX() == x && p.getY() == y;
    }

    // Ponto operator+(Ponto p){
    //     Ponto p1;
    //     p1.setX(p.getX() + x);
    //     p1.setY(p.getY() + y);

    //     return p1;
    // }

    Ponto operator+(Ponto p)
    {
        Ponto p1(p.getX() + x, p.getY() + y);

        return p1;
    }

private:
};

#endif