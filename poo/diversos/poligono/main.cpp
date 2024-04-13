#include <iostream>
#include "Poligono.h"
#include "Ponto.h"
using namespace std;

int main()
{
  Poligono poli;

  poli.lePontos();

  poli.listaPontos();

  cout << "\n\tO perimetro do poligono é: \n";
  cout << "\n\t" << poli.perimetro() << endl;
  cout << endl;
}