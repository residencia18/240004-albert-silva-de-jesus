/*Exercício 2: Modularização
• Implemente um programa que converta uma temperatura de Celsius para Fahrenheit.
• Separe a lógica de conversão em uma função e a entrada/saída em outra função.
• Teste a função de conversão com diferentes valores.*/

#include <iostream>
using namespace std;

float converteCelsiusParaFahrenheit(float celsius);

void imprimeFahrenheit(float celsius);

int main()
{
    float celsius;

    imprimeFahrenheit(celsius);
    converteCelsiusParaFahrenheit(celsius);
}

float converteCelsiusParaFahrenheit(float celsius)
{
    float fahrenheit = (celsius * 9 / 5) + 32;
    return fahrenheit;
}

void imprimeFahrenheit(float celsius)
{
    cout << "\nDigite a temperatura em Celsius: ";
    cin >> celsius;

    cout << "\nA temperatura em Fahrenheit é: " << converteCelsiusParaFahrenheit(celsius) << endl;
}