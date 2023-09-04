/*Exercício 3: Manipulação de strings tipo C
● A seguinte expressão em C++ gera caracteres aleatórios no intervalo das letras minúsculas: ‘a’ + rand()%(‘z’ - ‘a’). Utilizando esta expressão implemente uma aplicação em que:

a. Gere duas strings de forma aleatória com 10 caracteres;

b. Transforme o primeiro caractere de cada string em maiúscula;

c. Imprima as strings em ordem alfabética;*/

#include <iostream>
#include <cstring>
#include <cctype>
#include <ctime>

using namespace std;

int main()
{

    srand(time(nullptr));

    char string1[10];
    char string2[10];
    int tam = 0;
    bool trocou;

    for (int i = 0; i < sizeof(string1); i++)
    {
        string1[i] = 'a' + rand() % ('z' - 'a');
    }
    // string1[10] = '\0';

    for (int i = 0; i < sizeof(string2); i++)
    {
        string2[i] = 'a' + rand() % ('z' - 'a');
    }
    
    cout << "\nStrings geradas:\n";
    cout << "\nString1: ";
    for (int i = 0; i < sizeof(string1); i++)
    {
        cout << string1[i] << ", ";
    }
    cout << endl;

    cout << "String2: ";
    for (int i = 0; i < sizeof(string2); i++)
    {
        cout << string2[i] << ", ";
    }

    string1[0] = toupper(string1[0]);
    string2[0] = toupper(string2[0]);
    char aux[10];
    strcpy(aux, string1);
    strcpy(aux, string2);

    cout << "\n\n1º Letra de cada String em maiuscula:\n";
    cout << "\nString1: ";
    for (int i = 0; i < sizeof(string1); i++)
    {
        cout << string1[i] << ", ";
    }
    cout << endl;

    cout << "String2: ";
    for (int i = 0; i < sizeof(string2); i++)
    {
        cout << string2[i] << ", ";
    }
    // string2[10] = '\0';

    // tam = strlen(string1);
    // do {
    //     trocou = false;
    //     for (int i = 0; i < tam - 1; i++) {
    //         if (string1[i] > string1[i + 1]) {
    //             // Troca os caracteres manualmente sem usar swap
    //             char temp1 = string1[i];
    //             string1[i] = string1[i + 1];
    //             string1[i + 1] = temp1;
    //             trocou = true;
    //         }
    //     }
    // } while (trocou);

    tam = strlen(string2);
    do {
        trocou = false;
        for (int i = 0; i < tam - 1; i++) {
            if (string2[i] > string2[i + 1]) {
                // Troca os caracteres manualmente sem usar swap
                char temp = string2[i];
                string2[i] = string2[i + 1];
                string2[i + 1] = temp;
                trocou = true;
            }
        }
    } while (trocou);

    cout << "\n\nString1 em ordem alfabetica:\n";
    // cout << "\nString1: ";
    // for (int i = 0; i < tam; i++)
    // {
    //     cout << string1[i] << ", ";
    // }
    cout << endl;

    cout << "String1 = " << string1[0] << endl;

    // cout << "String2: ";
    // for (int i = 0; i < tam; i++)
    // {
    //     cout << string2[i] << ", ";
    // }
}