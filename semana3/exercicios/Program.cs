using System;
using System.Collections.Generic;
using System.Linq;
namespace exercicios
{
  class Program

  {
    static void Main(string[] args)
    {
      LimparTela();

      /*Exercício 1: Tuplas
      Crie uma função que recebe um nome e uma idade como parâmetros e retorna uma tupla contendo o nome e a idade. Em 
      seguida, chame a função com diferentes valores e exiba os resultados.*/

      // Chamando a função com diferentes valores
      var pessoa1 = CriarTupla("Alice", 25);
      var pessoa2 = CriarTupla("Bob", 30);

      // Exibindo os resultados
      ExibirDadosDaPessoa(pessoa1);
      ExibirDadosDaPessoa(pessoa2);
      //========================================================================================================================

      /*Exercício 2: Expressões Lambda
      Defina uma expressão lambda que recebe dois números como parâmetros e retorna a soma dos quadrados desses números. Em seguida, chame a 
      expressão lambda com alguns valores diferentes e exiba os resultados.
      */

      // Chamando a expressão lambda com diferentes valores
      double resultado1 = CalcularSomaDosQuadrados(2, 3);
      double resultado2 = CalcularSomaDosQuadrados(4, 5);

      // Exibindo os resultados
      Console.WriteLine($"\n\tResultado 1: {resultado1}");
      Console.WriteLine($"\tResultado 2: {resultado2}");
      //========================================================================================================================

      /*Exercício 3: LINQ com Lista
      Crie uma lista de objetos simples, por exemplo, representando pessoas com propriedades como "Nome" e "Idade". Em seguida, use LINQ para 
      filtrar a lista e obter todas as pessoas com idade superior a 30.*/

      // Criando uma lista de pessoas
      List<Pessoa> listaDePessoas = new List<Pessoa>
        {
            new Pessoa { Nome = "Alice", Idade = 25 },
            new Pessoa { Nome = "Bob", Idade = 35 },
            new Pessoa { Nome = "Charlie", Idade = 28 },
            new Pessoa { Nome = "Diana", Idade = 40 }
        };

      // Usando LINQ para filtrar pessoas com idade superior a 30
      var pessoasComMaisDe30Anos = listaDePessoas.Where(pessoa => pessoa.Idade > 30).ToList();

      // Exibindo os resultados
      Console.WriteLine("\n\tPessoas com idade superior a 30:");
      foreach (var pessoa in pessoasComMaisDe30Anos)
      {
        Console.WriteLine($"\tNome: {pessoa.Nome}\n\tIdade: {pessoa.Idade}");
      }
      //========================================================================================================================

      /*Exercício 4: LINQ com Array
      Crie um array de números inteiros. Use LINQ para selecionar apenas os números pares e ordene-os de forma decrescente.
      */

      // Criando um array de números inteiros
      int[] numeros = { 5, 10, 3, 8, 7, 2, 15, 4, 6 };

      // Usando LINQ para selecionar apenas os números pares e ordená-los de forma decrescente
      var numerosParesOrdenados = numeros
          .Where(numero => numero % 2 == 0) // Seleciona apenas números pares
          .OrderByDescending(numero => numero) // Ordena de forma decrescente
          .ToArray(); // Converte para um array

      // Exibindo os resultados
      Console.WriteLine("\n\tNúmeros pares ordenados de forma decrescente:");
      Console.Write("\t");

      foreach (var numero in numerosParesOrdenados)
      {
        Console.Write(numero + " ");
      }

      /*Exercício 5: Combinação de Tuplas, Expressões Lambda e LINQ
      Crie uma lista de tuplas, onde cada tupla contém o nome de uma pessoa e a sua altura em centímetros. Utilize uma expressão 
      lambda e LINQ para calcular a altura média das pessoas na lista.*/

      // Criando uma lista de tuplas (nome, altura)
      List<(string Nome, double Altura)> listDePessoas = new List<(string, double)>
        {
            ("Alice", 165),
            ("Bob", 180),
            ("Charlie", 175),
            ("Diana", 160)
        };

      // Usando LINQ e expressão lambda para calcular a altura média
      double alturaMedia = listDePessoas.Select(pessoa => pessoa.Altura).Average();

      // Exibindo o resultado
      Console.WriteLine($"\n\n\tAltura média das pessoas: {alturaMedia} cm");

    }

    static (string Nome, int Idade) CriarTupla(string nome, int idade)
    {
      // Criando e retornando a tupla
      return (nome, idade);
    }

    static void ExibirDadosDaPessoa((string Nome, int Idade) pessoa)
    {
      // Exibindo os dados da pessoa
      Console.WriteLine($"\n\tNome: {pessoa.Nome}\n\tIdade: {pessoa.Idade}");
    }

    static Func<double, double, double> SomaDosQuadrados = (num1, num2) => (num1 * num1) + (num2 * num2);

    static double CalcularSomaDosQuadrados(double numero1, double numero2)
    {
      // Chama a expressão lambda
      return SomaDosQuadrados(numero1, numero2);
    }

    public static void LimparTela()
    {
      // Limpar a tela no Windows ou Linux
      if (Environment.OSVersion.Platform == PlatformID.Win32NT)
      {
        Console.Clear(); // Windows
      }
      else
      {
        Console.Write("\u001b[2J\u001b[1;1H"); // Linux
      }
    }
    public static void Pause()
    {
      Console.Write("\n\tPressione Enter para continuar...");
      Console.ReadLine();
    }

  }
}