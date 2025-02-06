#include <iostream>
#include "Retangulo.h"
#include "Forma.h"

using namespace std;

int main(){

    Retangulo r;
    // r.calcularArea();

    Forma forma(2,3);
    float result;
    result = r.calcularArea();
    
    cout << "\n\tRetangulo área: " << result;
    
}