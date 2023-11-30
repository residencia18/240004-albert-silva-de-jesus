namespace AvaliacaoDotNet

{
  class Program
  {
    static void Main(string[] args)
    {
      ListaCliente clientes = new ListaCliente();
      DateTime dataNascimento = new DateTime(2000, 11, 11);
      Advogado advogado = new Advogado("Albert", dataNascimento, 23, "070.468.350-47", "17374", "Pediatria");
      App.MenuGestaoDeEscritorio(clientes);
    }
  }
}
