#include<iostream>
#include<cmath>

using namespace std;

int main(){

    double x,y,z;
    double curva;
    
    cout << "Digite o valor de x : ";
    cin >> x;

    cout << "Digite o valor de y : ";
    cin >> y;

    z = sqrt(x*x+y*y);

    cout << "A distancia euclidiana eh : " << z << endl;

    return 0;
}