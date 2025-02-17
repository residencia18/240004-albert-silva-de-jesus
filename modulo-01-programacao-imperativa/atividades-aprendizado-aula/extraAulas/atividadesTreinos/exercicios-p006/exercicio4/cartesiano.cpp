/*● Escreva um programa que leia os valores (x, y) de um ponto do plano e informe em qual quadrante o ponto se encontra. Use apenas o operador
condicional (?). Lembre que um ponto, no plano cartesiano, pode estar no primeiro quadrante ( se x> 0 e y>0), no segundo quadrante ( se x<0 e y>0),
no terceiro quadrante ( se x<0 e y<0), no quarto quadrante (se x>0 e y<0) ou sobre um dos eixos (caso x=0 ou y=0).*/

#include<iostream>

using namespace std;

int main(){

    double x,y;

    cout << "Entre com x : ";
    cin >> x;

    cout << "Entre com y : ";
    cin >> y;

    cout << 
    (((x>0) && (y>0)) ? "Primeiro Quadrante" : 
    ((x>0) && (y<0)) ? "Quarto Quadrante" : 
    ((x<0) && (y>0)) ? "Segundo Quadrante" : 
    ((x<0) && (y<0)) ? "Terceiro quadrante" : "Sobre os eixos") << endl; 



    return 0;
}