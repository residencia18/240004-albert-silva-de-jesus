#include <iostream>
using namespace std;

int main(){

    char nomes[3];
    float notas[6];
    float media = 0;

    for(int i = 0; i < 3; i++){
    
        cout << "Digite o " << i + 1 << "º nome: " << endl;
        cin.getline(nomes,3);

        cout << "Digite a " << i + 1 << "º nota: " << endl;
        cin >> notas[i];
        cin.get();
        media = notas[i] / 3;

    }

    for(int i = 0; i < 3; i++){
        cout << "Nomes = " << nomes[i] << endl;

        cout << "Notas = " << i + 1 << endl;

    }
}