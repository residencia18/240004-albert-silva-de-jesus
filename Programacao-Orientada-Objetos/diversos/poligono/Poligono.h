#include <iostream>
#include "Ponto.h"
#include <vector>
#ifndef POLIGONO_H
#define POLIGONO_H

using namespace std;

#pragma once

class Poligono
{
public:
    vector<Ponto> pontos;

    Poligono()
    {
    }

    ~Poligono()
    {
    }

    void limpaTela()
    {
    #ifdef _WIN32
        system("cls");
    #else
        system("clear");
    #endif
    }

    void lePontos()
    {
        cout << "\n\tCriando Um Poligono!" << endl;
        char sn;

        do
        {
            Ponto p;
            p.lerPonto();
            pontos.push_back(p);

            limpaTela();
            cout << "\n\tDeseja continuar inserir mais ponto (s/n) ?" << endl;
            cout << "\n\tENTRADA ->  ";
            cin >> sn;

        } while (sn != 'n');
    }

    void listaPontos()
    {
        cout << "\n\tAs Coordenadas digitadas foram: " << endl;
        for (Ponto p : pontos)
        {
            cout << "\n\t(" << p.escrevePonto() << ")\n";
        }
    }

    float perimetro()
    {

        float per = 0;
        vector<Ponto>::iterator it2;
        Ponto p1;
        Ponto p2;

        for (auto it = pontos.begin(); it != pontos.end(); it++)
        {

            it2 = it;
            advance(it2, 1);
            p1 = *it;
            p2 = *it;
            per += p1.distancia(p2);
        }

        // pegando distancia entre o primeiro e ultimo
        it2 = pontos.begin();
        p1 = *it2;
        per += p1.distancia(p2);

        return per;
    }

private:
};

#endif