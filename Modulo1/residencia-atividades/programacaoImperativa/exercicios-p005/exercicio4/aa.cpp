

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