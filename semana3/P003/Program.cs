using System;
using System.Globalization;

namespace P003
{
  class Program
  {
    static void Main(string[] args)
    {
      Produto produto = new Produto();
      ProdutoRepository.MenuProduto(produto);
    }
  }
}