using System;
using System.IO;
using System.Collections.Generic;

namespace AvaliacaoDotNet

{
  class Program
  {
    static void Main(string[] args)
    {
      ListaCliente clientes = new ListaCliente();
      ListaAdvogado advogados = new ListaAdvogado();
      Persistencia persistencia = new Persistencia();
      App.MenuGestaoDeEscritorio(clientes, advogados, persistencia);
    }
  }
}
