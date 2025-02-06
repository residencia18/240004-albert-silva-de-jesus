#include <iostream>
#include "Aviao.h"

using namespace std;

int main()
{
    Aviao *av1 = new Aviao(1);
    Aviao *av2 = new Aviao(2);
    Aviao *av3 = new Aviao(3);

    cout << "--------------------------" << endl;
    cout << "Tipo.............: " << av1->tipo << endl;
    cout << "Velocidade.......: " << av1->velMax << endl;
    cout << "Velocidade atual.: " << av1->vel << endl;
    cout << "--------------------------" << endl;
    cout << "Tipo.............: " << av2->tipo << endl;
    cout << "Velocidade.......: " << av2->velMax << endl;
    cout << "Velocidade atual.: " << av2->vel << endl;
    cout << "--------------------------" << endl;
    cout << "Tipo.............: " << av3->tipo << endl;
    cout << "Velocidade.......: " << av3->velMax << endl;
    cout << "Velocidade atual.: " << av3->vel << endl;
    cout << "--------------------------" << endl;

    return 0;
}
