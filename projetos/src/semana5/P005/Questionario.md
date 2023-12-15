<h1 align="center">Residência TIC18 Java</h1>

### DESENVOLVER CONCEITOS INICIAIS DE PROGRAMAÇÃO EM JAVA

**DESCRIÇÃO**

1. **O que é uma exceção em Java e qual é o propósito de usá-las em programas?**
  
      Uma exceção é um evento que ocorre durante a execução de um programa, que interrompe o fluxo normal das instruções. Quando uma exceção ocorre, o programa para de ser executado e o Java tenta encontrar algo para tratar a exceção. Se não houver um tratamento adequado, o programa é encerrado e o usuário recebe uma mensagem de erro.

      O propósito de usá-las em programas é que elas permitem que o programador crie um tratamento para o erro, evitando que o programa seja encerrado de forma abrupta. 

2. **Pesquise sobre a diferença entre exceções verificadas e não verificadas em Java. Dê exemplos de cada uma.**

      Exceções verificadas são exceções que o compilador obriga o programador a tratar. Exemplos: FileNotFoundException, IOException, ClassNotFoundException, SQLException, etc.

      Exceções não verificadas são exceções que o compilador não obriga o programador a tratar. Exemplos: ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException, etc.

3. **Como você pode lidar com exceções em Java? Quais são as palavras-chave e as práticas comuns para tratamento de exceções?**

      Para lidar com exceções em Java, o programador pode utilizar as palavras-chave try, catch e finally. 

      A palavra-chave try é utilizada para definir um bloco de código que será testado quanto a erros enquanto é executado.

      A palavra-chave catch é utilizada para definir um bloco de código que será executado caso ocorra um erro no bloco try.

      A palavra-chave finally é utilizada para definir um bloco de código que será executado após a execução do bloco try, independentemente de ter ocorrido um erro ou não.

      Exemplo:

      ```java
      try {
          // bloco de código a ser testado
      } catch (ExceptionType1 e1) {
          // bloco de código a ser executado caso ocorra um erro do tipo ExceptionType1
      } catch (ExceptionType2 e2) {
          // bloco de código a ser executado caso ocorra um erro do tipo ExceptionType2
      } catch (ExceptionType3 e3) {
          // bloco de código a ser executado caso ocorra um erro do tipo ExceptionType3
      } finally {
          // bloco de código a ser executado após a execução do bloco try, independentemente de ter ocorrido um erro ou não
      }
      ```
4. **O que é o bloco "try-catch" em Java? Como ele funciona e por que é importante usá-lo ao lidar com exceções?**

      O bloco try-catch é utilizado para tratar exceções em Java. Ele funciona da seguinte forma: o bloco try é executado e, caso ocorra um erro, o bloco catch é executado. É importante utilizá-lo ao lidar com exceções para que o programa não seja encerrado de forma abrupta. 

5. **Quando é apropriado criar suas próprias exceções personalizadas em Java e como você pode fazer isso? Dê um exemplo de quando e por que você criaria uma exceção personalizada.**
  
        É apropriado criar suas próprias exceções personalizadas em Java quando o programador deseja criar uma exceção que não existe na linguagem. Para fazer isso, o programador deve criar uma classe que herda da classe Exception. 
  
        Exemplo:
  
        ```java
        public class MinhaExcecao extends Exception {
            public MinhaExcecao(String mensagem) {
                super(mensagem);
            }
        }
        ```
  
        O programador criaria uma exceção personalizada para que o programa não seja encerrado de forma abrupta quando ocorrer um erro específico. Por exemplo, se o programador deseja que o programa não seja encerrado de forma abrupta quando o usuário digitar um número negativo, ele pode criar uma exceção personalizada para isso. 

Autor: [Albert Silva]