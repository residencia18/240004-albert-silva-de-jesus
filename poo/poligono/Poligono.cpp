#include <iostream>
#include <vector>
#include "Poligono.h"
#include "Ponto.h"

using namespace std;

Poligono::Poligono(){
  cout << "\n\tPoligono criado!...";
}

Poligono::~Poligono()
{
  cout << "\n\tPoligono destruido!...";
}

void Poligono::lePontos()
{
  cout << "\n\tCriando Um Poligono!" << endl;
  char sn;

  do
  {
    Ponto p;
    p.lerPonto();
    pontos.push_back(p);

    cout << "\n\tDeseja continuar inserir mais ponto (s/n) ?" << endl;
    cout << "\n\tENTRADA ->  ";
    cin >> sn;

  } while (sn != 'n');
}

void Poligono::listaPontos()
{
  cout << "As Coordenadas doigitadas foram: " << endl;
  for (Ponto p : pontos)
  {
    cout << "\n\t(" << p.escrevePonto() << ")";
  }
}

float Poligono::perimetro()
{

  float per = 0;
  vector<Ponto>::iterator it2;
  Ponto p1;
  Ponto p2;

  for (auto it = pontos.begin(); it != pontos.end(); it++)
  {

    it2 = it;
    advance(it2, 1);
    p1 = *it;
    p2 = *it;
    per += p1.distancia(p2);
  }

  // pegando distancia entre o primeiro e ultimo
  it2 = pontos.begin();
  p1 = *it2;
  per += p1.distancia(p2);

  return per;
}