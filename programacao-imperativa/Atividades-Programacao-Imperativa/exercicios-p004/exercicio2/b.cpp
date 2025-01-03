/*b. Modifique o exercício anterior para que a saída imprima também o código numérico em octal e em hexadecimal.*/

#include <iostream>
#include <string>

using namespace std;

int main()
{
    char a;

    // printf("Caractere: '%c', Decimal: %i, Octal: 0%o, exadecimal: %x \n", '0', '0', '0', '0');

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
}