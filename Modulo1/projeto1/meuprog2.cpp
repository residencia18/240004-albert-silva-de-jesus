#include <iostream>
#include <iomanip>

using namespace std;

int main()
{

    float a, b;

    cout << "A = ";
    cin >> a;

    cout << "B = ";
    cin >> b;

    float soma = a + b;
    float subtracao = a - b;
    float multiplicacao = a * b;
    float divicao = a / b;
    int x = a, y = b;
    float resto = x % y;

    cout << setprecision(1) << fixed;

    cout << "\nSoma = "
         << soma
         << "\nSubtração = "
         << subtracao
         << "\nMultiplicação = "
         << multiplicacao
         << "\nDivicao = "
         << divicao
         << "\nResto = "
         << resto
         << endl;

    return 0;
}
