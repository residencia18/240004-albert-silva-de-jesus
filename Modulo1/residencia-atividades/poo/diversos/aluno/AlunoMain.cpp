#include <iostream>
#include "Aluno.h"
#include "Turma.h"
#include <vector>

using namespace std;

int main(){

  Aluno aluno("Albert", 1);
  Turma turma;

  aluno.exibirDetalhes();
  turma.adicionarAlunos(aluno);

  // turma.lerAlunos(aluno);
   turma.listarAlunos();    
}