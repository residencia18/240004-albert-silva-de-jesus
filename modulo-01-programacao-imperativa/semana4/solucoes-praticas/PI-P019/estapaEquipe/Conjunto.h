/*Crie a sobrecarga do operador = para atribuir a um conjunto os mesmos itens que estão no outro
A=B; //A recebe os itens de B
Considere a criação de um construtor de conjuntos que recebe outro conjunto como parâmetro

Crie a sobrecarga do operador + para executar a união entre dois conjuntos
A = B+C; //A recebe todos os itens de B e ainda os de C que não se repetem em B

Crie a sobrecarga do operador * para executar a intersecção entre dois conjuntos
A = B*C; //A recebe os itens de B que ocorrem também em C

Crie a sobrecarga do operador - para calcular a diferença entre dois conjuntos
A = B-C; //A recebe os itens que estão em B mas não estão em C

Crie a sobrecarga do operador <> para calcular o delta entre dois conjuntos
A = B<>C; //A recebe a união entre os itens que estão em B mas não em C, além dos conjunto que estão em C mas não em B

Crie a sobrecarga do operador == para permitir a comparação entre dois conjuntos
A==B dá true se todos os conjunto de A estão em B e vice versa. Retorna false caso contrário.*/

#ifndef CONJUNTO_H
#define CONJUNTO_H
#include <iostream>
#include "Utils.h"
#include <ctime>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

#pragma once

class Conjunto
{
public:
    Utils utils;
    vector<int> conjunto;

    Conjunto() {}

    ~Conjunto() {}

    Conjunto(vector<int> conjunto)
    {
        this->conjunto = conjunto;
    }

    Conjunto operator=(const Conjunto &B)
    {
        this->conjunto = B.conjunto;
        return *this;
    }

    Conjunto operator+(const Conjunto &B)
    {
        Conjunto C;
        C.conjunto = this->conjunto;
        for (auto it = B.conjunto.begin(); it != B.conjunto.end(); it++)
        {
            if (find(C.conjunto.begin(), C.conjunto.end(), *it) == C.conjunto.end())
            {
                C.conjunto.push_back(*it);
            }
        }
        return C;
    }

    Conjunto operator*(const Conjunto &B)
    {
        Conjunto C;
        for (auto it = B.conjunto.begin(); it != B.conjunto.end(); it++)
        {
            if (find(this->conjunto.begin(), this->conjunto.end(), *it) != this->conjunto.end())
            {
                C.conjunto.push_back(*it);
            }
        }
        return C;
    }

    Conjunto operator-(const Conjunto &B)
    {
        Conjunto C;
        for (auto it = this->conjunto.begin(); it != this->conjunto.end(); it++)
        {
            if (find(B.conjunto.begin(), B.conjunto.end(), *it) == B.conjunto.end())
            {
                C.conjunto.push_back(*it);
            }
        }
        return C;
    }

    // Conjunto operator<>(const Conjunto &B)
    // {
    //     Conjunto C;
    //     for (auto it = this->conjunto.begin(); it != this->conjunto.end(); it++)
    //     {
    //         if (find(B.conjunto.begin(), B.conjunto.end(), *it) == B.conjunto.end())
    //         {
    //             C.conjunto.push_back(*it);
    //         }
    //     }
    //     for (auto it = B.conjunto.begin(); it != B.conjunto.end(); it++)
    //     {
    //         if (find(this->conjunto.begin(), this->conjunto.end(), *it) == this->conjunto.end())
    //         {
    //             C.conjunto.push_back(*it);
    //         }
    //     }
    //     return C;
    // }

    Conjunto calcularDelta(const Conjunto &B) const
    {
        Conjunto C;

        for (auto it = this->conjunto.begin(); it != this->conjunto.end(); it++)
        {
            if (find(B.conjunto.begin(), B.conjunto.end(), *it) == B.conjunto.end())
            {
                C.conjunto.push_back(*it);
            }
        }

        for (auto it = B.conjunto.begin(); it != B.conjunto.end(); it++)
        {
            if (find(this->conjunto.begin(), this->conjunto.end(), *it) == this->conjunto.end())
            {
                C.conjunto.push_back(*it);
            }
        }

        return C;
    }

    Conjunto operator==(const Conjunto &B)
    {
        Conjunto C;
        for (auto it = this->conjunto.begin(); it != this->conjunto.end(); it++)
        {
            if (find(B.conjunto.begin(), B.conjunto.end(), *it) != B.conjunto.end())
            {
                C.conjunto.push_back(*it);
            }
        }
        for (auto it = B.conjunto.begin(); it != B.conjunto.end(); it++)
        {
            if (find(this->conjunto.begin(), this->conjunto.end(), *it) != this->conjunto.end())
            {
                C.conjunto.push_back(*it);
            }
        }
        return C;
    }

    void imprimirConjunto()
    {
        Conjunto B({3, 4, 5});
        Conjunto C({2, 3, 6});

        cout << "\n\tA = {";
        for (auto it = conjunto.begin(); it != conjunto.end(); it++)
        {
            cout << "\t" << *it << ", ";
        }
        cout << "}\n\n" << endl;

        cout << "\n\tB = {"; 
        for (auto it = B.conjunto.begin(); it != B.conjunto.end(); it++)
        {
            cout << "\t" << *it << ", ";
        }
        cout << "}\n\n" << endl;

        cout << "\n\tC = {";
        for (auto it = C.conjunto.begin(); it != C.conjunto.end(); it++)
        {
            cout << "\t" << *it << ", ";
        }
        cout << "}\n\n" << endl;

        utils.pause();
    }

    void menuConjunto()
    {
        Conjunto A;
        Conjunto B({3, 4, 5});
        Conjunto C({2, 3, 6});
        int escolha = 0;

        do
        {
            switch (escolha = utils.menu())
            {

            case 1:

                utils.limpaTela();
                cout << "\n\t==========A RECEBE B========";
                A = B;
                A.imprimirConjunto();

                break;

            case 2:

                utils.limpaTela();
                cout << "\n\t==========A RECEBE B + C========";
                A = B + C;
                A.imprimirConjunto();

                break;

            case 3:

                utils.limpaTela();
                cout << "\n\t==========A RECEBE B * C========";
                A = B * C;
                A.imprimirConjunto();

                break;

            case 4:

                utils.limpaTela();
                cout << "\n\t==========A RECEBE B - C========";
                A = B - C;
                A.imprimirConjunto();

                break;

            case 5:

                utils.limpaTela();
                cout << "\n\t==========A RECEBE B <> C========";
                // A = B <> C;
                A.imprimirConjunto();
                break;

            case 6:

                utils.limpaTela();
                cout << "\n\t==========A == B========";
                A == B;
                A.imprimirConjunto();

                break;

            case 7:

                imprimirConjunto();

                break;

            case 0:

                cout << "\n\tPrograma encerrado com sucesso!..." << endl;
                escolha = 0;
                exit(0);

            default:
                cout << "\tOps, Opção invalida!";
            }

        } while (escolha != 0);
    }

private:
};

#endif