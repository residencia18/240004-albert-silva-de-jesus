/*Exercício 3: Manipulação de strings tipo C
● Implemente uma aplicação em C que:
a. Leia do teclado uma string no formato dd/mm/aaaa, ao alguma variação desse formato (Ex. 5/12/2022, 05/02/23, 07/5/2024), e imprima na tela por separado dia, mês e ano.*/

#include <iostream>
#include <cstring>

using namespace std;

int main(void)
{
    char data[11];
    int dia, mes, ano;

    cout << "\nDigite uma data no formato dd/mm/aaaa: ";
    cin >> data;

    dia = atoi(strtok(data, "/"));
    mes = atoi(strtok(NULL, "/"));
    ano = atoi(strtok(NULL, "/"));

    cout << "\nUtilizando variáveis inteiras, formato (Ex. 5/12/2022) " << endl;
    cout << "Dia: " << dia << endl;
    cout << "Mes: " << mes << endl;
    cout << "Ano: " << ano << endl;

    cout << "\nUtilizando acesso direto aos caracteres da string, formato (Ex. 05/02/23) " << endl;
    cout << "Dia: " << data[0] << data[1] << endl;
    cout << "Mes: " << data[3] << data[4] << endl;
    cout << "Ano: " << data[6] << data[7] << data[8] << data[9] << endl;

    cout << "\nUtilizando acesso direto aos caracteres da string, formato (Ex.07/5/2024) " << endl;
    cout << "Dia: " << data[0] << data[1] << endl;
    cout << "Mes: " << data[4] << endl;
    cout << "Ano: " << data[6] << data[7] << data[8] << data[9] << endl;
}