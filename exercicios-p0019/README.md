# MÓDULO PI : INSTRUÇÃO PRÁTICA PI-P017 - PROGRAMAÇÃO ORIENTADA A OBJETOS EM C++

## OBJETIVO DA ATIVIDADE:

### Desenvolvimento de um controle de conjuntos de itens (strings) de supermercados. É necessária a implementação de métodos para incluir e excluir itens de qualquer conjunto. Em seguida é necessário implementar operadores para união (+), intersecção (*), diferença (-), delta (<>), atribuição (=) e comparação (==) de conjuntos. 

## DESCRIÇÃO DA ATIVIDADE:

## Sistema de gestão de conjuntos de itens 
### Etapa 1: Individual 
### Crie uma classe ItemSet (conjunto de itens) 
###   Dentro desta classe crie um vector de String É onde serão armazenados os itens (cada item é um String) 
## IMPORTANTE! Não pode haver repetição de itens num mesmo conjunto! 
### Crie o método inserir(string s) que insere o item s no conjunto, caso ele não exista. 
### Crie o método excluir(string s) que exclui o item s do conjunto, caso ele exista. 
### Crie uma função main() para facilitar seus testes 

### Etapa 2: Equipe 
### Crie a sobrecarga do operador = para atribuir a um conjunto os mesmos itens que estão no outro 
###   A=B; //A recebe os itens de B 
###  Considere a criação de um construtor de conjuntos que recebe outro conjunto como parâmetro 
### Crie a sobrecarga do operador + para executar a união entre dois conjuntos 
###   A = B+C; //A recebe todos os itens de B e ainda os de C que não se repetem em B 
### Crie a sobrecarga do operador * para executar a intersecção entre dois conjuntos 
###   A = B*C; //A recebe os itens de B que ocorrem também em C 
### Crie a sobrecarga do operador - para calcular a diferença entre dois conjuntos 
###   A = B-C; //A recebe os itens que estão em B mas não estão em C 
### Crie a sobrecarga do operador <> para calcular o delta entre dois conjuntos 
###   A = B<>C; //A recebe a união entre os itens que estão em B mas não em C, além dos elementos que estão em C mas não em B 
### Crie a sobrecarga do operador == para permitir a comparação entre dois conjuntos 
###   A==B dá true se todos os elementos de A estão em B e vice versa. Retorna false caso contrário. 

## Equipe:
### Albert e João