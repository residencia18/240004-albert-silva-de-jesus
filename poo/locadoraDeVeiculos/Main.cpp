#include <iostream>
#include <vector>
#include "Funcionario.h"
using namespace std;


int main(){

    Funcionario funcionario;

    funcionario.cadastrar(funcionario);
    funcionario.listar();

}