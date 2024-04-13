/*e. Crie uma variável ui, de tipo unsigned int, atribua a ela o valor da variável li e depois atribua novamente a li o valor armazenado em ui. 
O que acontece e por que? Mostre o resultado na tela e coloque suas considerações num comentário no código.*/

#include <iostream>
#include <limits>

using namespace std;

/*O que acontece e por que?
  ui é uma variável do tipo unsigned int com o valor de 4201243 e li é uma variável do tipo long int com o valor máximo de um long int 2147483647.
  O compilador consegue converter o valor máximo de um long int para um unsigned int, pois o valor máximo de um long int é menor que o valor máximo 
  de um unsigned int.*/ 
int main()
{

    unsigned int ui;
    long int li = numeric_limits<long int>::max();

    ui = li;
    li = ui;

    cout << "ui: " << ui << endl;
    cout << "li: " << li << endl;

}