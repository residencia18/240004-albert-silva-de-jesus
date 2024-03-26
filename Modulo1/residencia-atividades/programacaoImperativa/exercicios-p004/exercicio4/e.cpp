/*e. Identifique se existe alguma diferença entre o valor pif e pid quando seus valores são impressos com cout utilizando 2, 4, 8 e 16 casas
decimais*/

#include <iostream>
#include <iomanip>

using namespace std;

int main(){

    double pid = 3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679;
    float pif = 3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679;

    cout << "\nPID\n";
    cout << setprecision(2) << pid << "\n";
    cout << setprecision(4) << pid << "\n";
    cout << setprecision(8) << pid << "\n";
    cout << setprecision(16) << pid << "\n";

    cout << "\nPIF\n";
    cout << setprecision(2) << pif << "\n";
    cout << setprecision(4) << pif << "\n";
    cout << setprecision(8) << pif << "\n";
    cout << setprecision(16) << pif << "\n";

}