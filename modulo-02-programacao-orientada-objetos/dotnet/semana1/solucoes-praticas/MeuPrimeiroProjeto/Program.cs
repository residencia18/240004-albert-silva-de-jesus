// See https://aka.ms/new-console-template for more information
// Estudar exceções

using System;

namespace MeuPrimeiroProjeto
{
  class Program
  {
    static void Main(string[] args)
    {
      Console.WriteLine("Hello World!");

      Console.WriteLine("Digite seu nome: ");

      var nome = Console.ReadLine();
      Console.WriteLine($"Hello {nome}!");
    }
  }
}