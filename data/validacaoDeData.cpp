#include <iostream>
#include <ctime>

int main() {
    // Data de retirada
    struct std::tm retirada = {0};
    retirada.tm_year = 123; // Ano - 1900
    retirada.tm_mon = 9;   // Mês (0-11)
    retirada.tm_mday = 2;  // Dia
    retirada.tm_hour = 10; // Hora
    retirada.tm_min = 0;   // Minuto
    retirada.tm_sec = 0;   // Segundo

    // Data de entrega
    struct std::tm entrega = {0};
    entrega.tm_year = 122; // Ano - 1900
    entrega.tm_mon = 9;   // Mês (0-11)
    entrega.tm_mday = 4;  // Dia
    entrega.tm_hour = 11; // Hora
    entrega.tm_min = 30;  // Minuto
    entrega.tm_sec = 0;   // Segundo

    // Converte as datas em timestamps
    std::time_t retiradaTimestamp = std::mktime(&retirada);
    std::time_t entregaTimestamp = std::mktime(&entrega);

    // Verifica se a data de entrega é anterior à data de retirada
    if (entregaTimestamp <= retiradaTimestamp) {
        std::cout << "A data de entrega não pode ser anterior à data de retirada." << std::endl;
    } else {
        std::cout << "Data de entrega válida." << std::endl;
    }

    return 0;
}