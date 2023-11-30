namespace AvaliacaoDotNet
{
    public class ListaCliente
    {
        public List<Cliente> clientes { get; set; }

        public ListaCliente()
        {
            clientes = new List<Cliente>();
        }

        public void AdicionarCliente(Cliente cliente)
        {
            clientes.Add(cliente);
        }

        public List<Cliente> GetClientes()
        {
            return clientes;
        }
        public void Cadastrar()
        {
            Console.Write("\n\tDigite o nome do clientes: ");
            string nome = Console.ReadLine()!;
            nome = Cliente.ConvertePrimeiraLetraParaMaiuscula(nome);

            string cpf;
            do
            {
                Console.Write("\n\tDigite o CPF do clientes: ");
                cpf = Console.ReadLine()!;

                if (!Cliente.IsValidCPF(cpf) || !Cliente.IsCpfUnico(cpf, clientes))
                {
                    Console.WriteLine("\n\tOps, CPF inválido ou já existe no cadastro. Por favor, digite um CPF válido.");
                    App.Pause();
                }

            } while (!Cliente.IsValidCPF(cpf) || !Cliente.IsCpfUnico(cpf, clientes));

            DateTime dataNascimento = Cliente.ObterDataDeNascimento();

            Console.Write("\n\tDigite o estado civil do clientes: ");
            string estadoCivil = Console.ReadLine()!;

            Console.Write("\n\tDigite a profissão do clientes: ");
            string profissão = Console.ReadLine()!;

            AdicionarCliente(new Cliente(nome, cpf, dataNascimento, estadoCivil, profissão));

        }

        public void Listar()
        {
            Console.WriteLine("\n\t=== Lista de Pacientes ===");
            foreach (Cliente cliente in clientes)
            {
                Console.WriteLine("\tNome: " + cliente.Nome);
                Console.WriteLine("\tCPF: " + cliente.Cpf);
                Console.WriteLine("\tData de Nascimento: " + cliente.DataNascimento.ToString("dd/MM/yyyy"));
                Console.WriteLine("\tIdade: " + cliente.Idade);
                Console.WriteLine("\tEstado Civil: " + cliente.EstadoCivil);
                Console.WriteLine("\tProfissão: " + cliente.Profissão);
                Console.WriteLine("\t==========================\n");
            }
        }

    }
}