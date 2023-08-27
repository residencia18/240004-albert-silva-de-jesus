/*c. Acrescente ao código do exercício anterior a possibilidade de ler um caractere qualquer e imprima no mesmo formato do inciso anterior.*/

#include <iostream>
using namespace std;

int main()
{

    char a;

    // printf("Caractere: '%c', Decimal: %i, Octal: 0%o, exadecimal: %x \n", '0', '0', '0', '0');

    std::cout << (a = '0') << std::dec << ", dec - " << int('0') << std::oct << ", oct - 0" << int('0') << std::hex << ", hex - " << int('0') << '\n';
    std::cout << (a = '1') << std::dec << ", dec - " << int('1') << std::oct << ", oct - 0" << int('1') << std::hex << ", hex - " << int('1') << '\n';
    std::cout << (a = '2') << std::dec << ", dec - " << int('2') << std::oct << ", oct - 0" << int('2') << std::hex << ", hex - " << int('2') << '\n';
    std::cout << (a = '3') << std::dec << ", dec - " << int('3') << std::oct << ", oct - 0" << int('3') << std::hex << ", hex - " << int('3') << '\n';
    std::cout << (a = '4') << std::dec << ", dec - " << int('4') << std::oct << ", oct - 0" << int('4') << std::hex << ", hex - " << int('4') << '\n';
    std::cout << (a = '5') << std::dec << ", dec - " << int('5') << std::oct << ", oct - 0" << int('5') << std::hex << ", hex - " << int('5') << '\n';
    std::cout << (a = '6') << std::dec << ", dec - " << int('6') << std::oct << ", oct - 0" << int('6') << std::hex << ", hex - " << int('6') << '\n';
    std::cout << (a = '7') << std::dec << ", dec - " << int('7') << std::oct << ", oct - 0" << int('7') << std::hex << ", hex - " << int('7') << '\n';
    std::cout << (a = '8') << std::dec << ", dec - " << int('8') << std::oct << ", oct - 0" << int('8') << std::hex << ", hex - " << int('8') << '\n';
    std::cout << (a = '9') << std::dec << ", dec - " << int('9') << std::oct << ", oct - 0" << int('9') << std::hex << ", hex - " << int('9') << '\n';

    std::cout << "\nDigite um caractere: ";
    cin >> a;

    std::cout << "\n" << a << std::dec << ", dec - " << int(a) << std::oct << ", oct - " << int(a) << std::hex << ", hex - " << int(a) << '\n';

    return 0;
}