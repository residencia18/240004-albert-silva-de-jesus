/*● Escreva um programa que:
a. leia da entrada padrão os valores reais dos coeficientes a, b e c, de um polinômio de segundo grau do tipo 𝑝(𝑥) = 𝑎𝑥(elevado a 2) 2 + 𝑏𝑥 + 𝑐, e imprima: i. Se o polinômio tem uma,
   duas ou nenhuma raiz real (lembre das suas aulas de segundo grau qual a condição que define qual o número de raízes de um polinômio);

ii. Se tiver raízes (uma ou duas) imprima o valor das mesmas. No exercício anterior você deve ter descoberto como calcular a raiz quadrada de um número;

b. Leia da entrada padrão um valor para x e imprima o valor de p(x);*/

#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    double a, b, c, delta, x1, x2;
    cout << "Digite os coeficientes a, b e c de um polinomio de segundo grau: ";
    cin >> a >> b >> c;

    delta = pow(b, 2) - 4 * a * c;

    if (delta > 0)
    {
        x1 = (-b + sqrt(delta)) / (2 * a);
        x2 = (-b - sqrt(delta)) / (2 * a);
        cout << "O polinomio tem duas raizes reais: " << x1 << " e " << x2 << endl;
    }
    else if (delta == 0)
    {
        x1 = -b / (2 * a);
        cout << "O polinomio tem uma raiz real: " << x1 << endl;
    }
    else
    {
        cout << "O polinomio nao tem raizes reais" << endl;
    }
    cout << "Digite um valor para x: ";
    cin >> x1;
    cout << "O valor de p(x) e: " << a * pow(x1, 2) + b * x1 + c << endl;
}
