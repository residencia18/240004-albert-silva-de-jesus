namespace AvaliacaoDotNet
{
    public class Persistencia
    {
        ListaAdvogado listaAdvogado;
        ListaCliente listaCliente;

        public Persistencia(ListaAdvogado listaAdvogado, ListaCliente listaCliente)
        {
            this.listaAdvogado = listaAdvogado;
            this.listaCliente = listaCliente;
        }

        public void CarregarArquivosAdvogado()
        {
            string caminhoArquivo = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "C:/Users/alber/OneDrive/Documentos/ProjetosResidencia/residenciaDotNet/AvaliacaoDotNet/BancoDeDados/dadosadvogados.txt");

            try
            {

                using (StreamReader reader = new StreamReader(caminhoArquivo))
                {
                    while (!reader.EndOfStream)
                    {
                        string linha = reader.ReadLine()!;
                        string[] dados = linha.Split(',');

                        // Certifique-se de que existam dados suficientes na linha
                        if (dados.Length >= 5)
                        {
                            string nome = dados[0];
                            DateTime dataNascimento = DateTime.Parse(dados[1]);
                            string cpf = dados[2];
                            int cna = int.Parse(dados[3]);
                            string especialidade = dados[4];

                            listaAdvogado.AdicionarAdvogado(new Advogado(nome, dataNascimento, cpf, cna, especialidade));
                        }
                        else
                        {
                            Console.WriteLine("A linha no arquivo não contém dados suficientes para um Advogado.");
                        }
                    }
                }

                Console.WriteLine("Dados dos advogados carregados com sucesso.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Ocorreu um erro ao carregar o arquivo de advogados: {ex.Message}");
            }
        }

        public void CarregarArquivosCliente()
        {
            string caminhoArquivo = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "C:/Users/alber/OneDrive/Documentos/ProjetosResidencia/residenciaDotNet/AvaliacaoDotNet/BancoDeDados/dadosclientes.txt");

            try
            {
                using (StreamReader reader = new StreamReader(caminhoArquivo))
                {
                    while (!reader.EndOfStream)
                    {
                        string linha = reader.ReadLine()!;
                        string[] dados = linha.Split(',');

                        // Certifique-se de que existam dados suficientes na linha
                        if (dados.Length >= 5)
                        {
                            string nome = dados[0];
                            string cpf = dados[1];
                            DateTime dataNascimento = DateTime.Parse(dados[2]);
                            string estadoCivil = dados[3];
                            string profissao = dados[4];

                            listaCliente.AdicionarCliente(new Cliente(nome, cpf, dataNascimento, estadoCivil, profissao));
                        }
                        else
                        {
                            Console.WriteLine($"A linha no arquivo não contém dados suficientes para um Cliente. Linha: {linha}");
                        }
                    }
                }

                Console.WriteLine("Dados dos clientes carregados com sucesso.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Ocorreu um erro ao carregar o arquivo de clientes: {ex.Message}");
            }
            App.Pause();
        }

        public void SalvarArquivosCliente()
        {
            string caminhoArquivo = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "C:/Users/alber/OneDrive/Documentos/ProjetosResidencia/residenciaDotNet/AvaliacaoDotNet/BancoDeDados/dadosclientes.txt");

            try
            {
                using (StreamWriter arquivo = File.CreateText(caminhoArquivo))
                {
                    foreach (Cliente cliente in listaCliente.GetClientes())
                    {
                        arquivo.WriteLine($"{cliente.Nome};{cliente.Cpf};{cliente.DataNascimento.ToShortDateString()};{cliente.EstadoCivil};{cliente.Profissão}");
                    }
                }

                Console.WriteLine("\n\tDados dos clientes foram salvos com sucesso!");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"\n\tOcorreu um erro ao salvar os dados dos clientes: {ex.Message}");
            }
        }

        public void SalvarArquivosAdvogado()
        {
            string caminhoArquivo = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "C:/Users/alber/OneDrive/Documentos/ProjetosResidencia/residenciaDotNet/AvaliacaoDotNet/BancoDeDados/dadosadvogados.txt");

            try
            {
                using (StreamWriter arquivo = File.CreateText(caminhoArquivo))
                {
                    foreach (Advogado advogado in listaAdvogado.GetAdvogados())
                    {
                        arquivo.WriteLine($"{advogado.Nome};{advogado.Cpf};{advogado.DataNascimento.ToShortDateString()};{advogado.Cna};{advogado.Especialidade}");
                    }
                }

                Console.WriteLine("\n\tDados dos advogados foram salvos com sucesso!");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"\n\tOcorreu um erro ao salvar os dados dos advogados: {ex.Message}");
            }
        }

    }
}