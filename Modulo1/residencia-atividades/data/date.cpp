#include <iostream>
#include <time.h>

using namespace std;

int main()
{
    time_t t;
    time(&t);
    struct tm *data;
    data = localtime(&t);

    int dia = data->tm_mday;
    int mes = data->tm_mon + 1;
    int ano = data->tm_year + 1900;
    int diaSemana = data->tm_wday;
    int diaAno = data->tm_yday;
    int hora = data->tm_hour;
    int minutos = data->tm_min;
    int segundos = data->tm_sec;

    // cout << dia << " de " << mes << " de " << ano << endl;
    // cout << hora << ":" << minutos << ":" << segundos << endl;
    // cout << "Dia da semana: " << diaSemana << endl;
    // cout << "Dia do ano: " << diaAno << endl;

    cout << "\nhora: " << (data->tm_hour + 1)  << endl;
}