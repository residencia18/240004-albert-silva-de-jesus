#include <iostream>
#include <string.h>
#include <vector>
#include <fstream>

using namespace std;

class Estado
{
    string nome;

public:
    string getNome()
    {
        return nome;
    };
    void setNome(string _nome)
    {
        nome = _nome;
    };
};

class Cidade
{
    string nome;
    Estado *estado;

public:
    string getNome()
    {
        return nome;
    };
    void setNome(string _nome)
    {
        nome = _nome;
    };
    Estado *getEstado()
    {
        return estado;
    };
    void setEstado(Estado *_estado)
    {
        estado = _estado;
    };
    string toString()
    {
        string s = nome.append(" - ");
        s = s.append(estado->getNome());
        return s;
    };
};

int main()
{
    Estado e1, e2;
    e1.setNome("Bahia");
    e2.setNome("Paraiba");
    Cidade c1, c2, c3, c4;
    c1.setNome("Feira de Santana");
    c2.setNome("Campina Grande");
    c3.setNome("Vitoria da Conquista");
    c4.setNome("Patos");
    c1.setEstado(&e1);
    c3.setEstado(&e1);
    c2.setEstado(&e2);
    c4.setEstado(&e2);
    cout << endl
         << c1.toString() << endl;
    cout << endl
         << c2.toString() << endl;
    cout << endl
         << c3.toString() << endl;
    cout << endl
         << c4.toString() << endl;
    return 0;
}

/*OUTRA FORMA DE FAZER:

#include <iostream>
#include <string.h>
#include <vector>
#include <fstream>

using namespace std;

class Estado {
    string nome;
    public:
    string getNome() {
        return nome;
    };
    void setNome(string _nome) {
        nome = _nome;
    };
};

class Cidade{
    string nome;
    Estado *estado;
    public:
    string getNome() {
        return nome;
    };
    void setNome(string _nome) {
        nome = _nome;
    };
    Estado* getEstado() {
        return estado;
    };
    void setEstado(Estado* _estado) {
        estado = _estado;
    };
    string toString() {
        string s = nome.append(" - ");
        s = s.append(estado->getNome());
        return s;
    };
};

int main() {
    Estado e1, e2;   
    e1.setNome("Bahia");
    e2.setNome("Paraiba");
    Cidade c1, c2, c3, c4;
    c1.setNome("Feira de Santana");
    c2.setNome("Campina Grande");
    c3.setNome("Vitoria da Conquista");
    c4.setNome("Patos");
    c1.setEstado(&e1);
    c3.setEstado(&e1);
    c2.setEstado(&e2);
    c4.setEstado(&e2);
    cout << endl << c1.toString() << endl;
    cout << endl << c2.toString() << endl;
    cout << endl << c3.toString() << endl;
    cout << endl << c4.toString() << endl;
    return 0;
}*/