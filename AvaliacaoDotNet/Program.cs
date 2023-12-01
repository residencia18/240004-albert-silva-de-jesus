namespace AvaliacaoDotNet

{
  class Program
  {
    static void Main(string[] args)
    {

      ListaCliente clientes = new ListaCliente();
      ListaAdvogado advogados = new ListaAdvogado();
      Persistencia persistencia = new Persistencia(advogados, clientes);
      App.MenuGestaoDeEscritorio(clientes, advogados, persistencia);
    }
  }
}
