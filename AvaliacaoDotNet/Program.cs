namespace AvaliacaoDotNet

{
  class Program
  {
    static void Main(string[] args)
    {
      ListaCliente clientes = new ListaCliente();
      ListaAdvogado advogados = new ListaAdvogado();
      App.MenuGestaoDeEscritorio(clientes, advogados);
    }
  }
}
