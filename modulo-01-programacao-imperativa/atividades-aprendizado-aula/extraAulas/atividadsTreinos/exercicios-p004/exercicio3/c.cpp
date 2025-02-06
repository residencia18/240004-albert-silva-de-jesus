/*c. Crie uma variável li, de tipo long int, atribua a ela o valor da variável uli e depois atribua novamente a uli o valor armazenado
em li. O que acontece e por que? Mostre o resultado na tela e coloque suas considerações num comentário no código.*/

#include <iostream>
#include <limits>
using namespace std;

/* O que acontece e por que?
 Ocorre um erro de compilação, pois o valor máximo de um unsigned long int é maior que o valor máximo de um long int.
 O compilador não consegue converter o valor máximo de um unsigned long int para um long int, pois o valor máximo de um unsigned long int é maior que o valor máximo de um long int.*/

int main()
{

    long int li;
    unsigned int uli = numeric_limits<unsigned long int>::max();

    li = uli;
    uli = li;

    cout << "Valor de li: " << li << endl;
    cout << "Valor de uli: " << uli << endl;

}