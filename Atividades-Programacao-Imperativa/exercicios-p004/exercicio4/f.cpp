/*f. No seu sistema existe diferença entre o tipo double e long double? Mostre seu achado com algum exemplo dentro do seu código.*/

#include <iostream>
#include <iomanip>

using namespace std;

// Tipo double pode armazenar até 12 casas 
int main(){

    double pid = 3.141592653589;
    float pif = 3.141592653589;
    cout << setprecision(12) << fixed;

    cout << "\nDouble\n";
    cout << pid << "\n";
    
    cout << "\nFloat\n";
    cout << pif << "\n";
    
}