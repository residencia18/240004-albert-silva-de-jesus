#include <iostream>
#include "Ponto.h"

using namespace std;

Ponto::Ponto(float x, float y){}

Ponto::Ponto(){
  cout << "\n\tPonto criado!...\n";
}

Ponto::~Ponto()
{
  cout << "\n\tPonto destruido!...\n";
}

void Ponto::lerPonto()
{
  cout << "\n\tDigite as coordenadas do pornto: ";
  cout << "\nX: ";
  cin >> x;
  cout << "\n\tY: ";
  cin >> y;
}

string Ponto::escrevePonto()
{
  return to_string(x) + ", " + to_string(y);
}

float Ponto::distancia(Ponto p)
{
  return sqrt(pow(x - p.getX(), 2) + pow(y - p.getY(), 2));
}

bool Ponto::operator==(Ponto p)
{
  return p.getX() == x && p.getY() == y;
}

Ponto Ponto::operator+(Ponto p)
{
  Ponto p1(p.getX() + x, p.getY() + y);

  return p1;
}