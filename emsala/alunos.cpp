#include <iostream>
#include <cstring>

using namespace std;

int main(){

    string nomes[5];
    float notas[6];
    float media = 0;

    for(int i = 0; i < 5; i++){
    
        cout << "Digite o " << i + 1 << "º nome: " << endl;
        getline(cin, nomes[i]);

    }

    for(int i = 0; i < 5; i++){
        cout << "Nomes = " << nomes[i] << endl;

        // cout << "Notas = " << i + 1 << endl;
    }
}