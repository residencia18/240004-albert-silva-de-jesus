/*d. Pesquise como fazer para armazenar uma variável os caracteres especiais ‘ç’ e ‘ã’. Acrescente no código do exercício anterior um exemplo que demonstra como usar este recurso.*/

#include <iostream>
#include <windows.h>
using namespace std;

int main()
{
    /*Forma alternativa
    Função system, executa no prompt de comando o chcp 1252, para não exibir uma mensagem(Pagina de código alterada), retorna null
    system("chcp 1252 > null");*/

    // Alternado o code page do console para 1252
    SetConsoleCP(1252);
    SetConsoleOutputCP(1252);

    char a;

    /*Forma alternativa
    printf("Caractere: '%c', Decimal: %i, Octal: 0%o, exadecimal: %x \n", '0', '0', '0', '0');*/

    cout << (a = '0') << dec << ", dec - " << int('0') << oct << ", oct - 0" << int('0') << hex << ", hex - " << int('0') << '\n';
    cout << (a = '1') << dec << ", dec - " << int('1') << oct << ", oct - 0" << int('1') << hex << ", hex - " << int('1') << '\n';
    cout << (a = '2') << dec << ", dec - " << int('2') << oct << ", oct - 0" << int('2') << hex << ", hex - " << int('2') << '\n';
    cout << (a = '3') << dec << ", dec - " << int('3') << oct << ", oct - 0" << int('3') << hex << ", hex - " << int('3') << '\n';
    cout << (a = '4') << dec << ", dec - " << int('4') << oct << ", oct - 0" << int('4') << hex << ", hex - " << int('4') << '\n';
    cout << (a = '5') << dec << ", dec - " << int('5') << oct << ", oct - 0" << int('5') << hex << ", hex - " << int('5') << '\n';
    cout << (a = '6') << dec << ", dec - " << int('6') << oct << ", oct - 0" << int('6') << hex << ", hex - " << int('6') << '\n';
    cout << (a = '7') << dec << ", dec - " << int('7') << oct << ", oct - 0" << int('7') << hex << ", hex - " << int('7') << '\n';
    cout << (a = '8') << dec << ", dec - " << int('8') << oct << ", oct - 0" << int('8') << hex << ", hex - " << int('8') << '\n';
    cout << (a = '9') << dec << ", dec - " << int('9') << oct << ", oct - 0" << int('9') << hex << ", hex - " << int('9') << '\n';

    cout << "\nDigite um caractere: ";
    cin >> a;
    cout << "\n" << a << dec << ", dec - " << int(a) << oct << ", oct - " << int(a) << hex << ", hex - " << int(a) << '\n';

    cout << "\nDigite um caractere especial: ";
    cin >> a;
    cout << "\nCaractere especial:  " << a << '\n';

}