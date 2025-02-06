/*c. Explore as formas de formatar a saída com o comando cout e modifique a quantidade de casas decimais que são apresentadas para 2, 4, 8 e 16.*/

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{

    cout << setprecision(1) << fixed;

    float a = 2;
    float b = 4;
    float c = 8;
    float d = 16;

    cout << a << ", " << b << ", " << c << ", " << d << "\n";
}