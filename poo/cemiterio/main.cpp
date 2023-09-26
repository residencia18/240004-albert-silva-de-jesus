#include <iostream>
#include <string.h>
#include "Paciente.h"
using namespace std;


int main(){

    Paciente p1;
    string nome;

    cout << "\n\tDigite o nome do falecido: ";
    getline(cin, nome);
    p1.setNome(nome);

    cout << "\n\tNome do difunto: " << p1.getNome() << endl;
}