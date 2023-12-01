namespace AvaliacaoDotNet
{
    public class Relatorios
    {
        ListaCliente clientes;

        ListaAdvogado advogados;

        public Relatorios(ListaCliente clientes, ListaAdvogado advogados)
        {
            this.clientes = clientes;
            this.advogados = advogados;
        }
        public void MenuRelatorios()
        {

            do
            {
                App.LimparTela();
                Console.WriteLine("\n\t========== RELATÓRIOS ==========");
                Console.WriteLine("\t[1] - ADVOGADOS COM IDADE ENTRE DOIS VALORES");
                Console.WriteLine("\t[2] - CLIENTE COM IDADE ENTRE DOIS VALORES");
                Console.WriteLine("\t[3] - CLIENTES COM ESTADO CIVIL INFORMADO PELO CLIENTE");
                Console.WriteLine("\t[4] - CLIENTES EM ORDEM ALFABÉTICA");
                Console.WriteLine("\t[5] - CLIENTES CUJA  PROFISSÃO CONTENHA TEXTO INFORMADO PELO USUÁRIO");
                Console.WriteLine("\t[6] - ADVOGADOS E CLIENTES ANIVERSARIANTES DO MÊS INFORMADO");
                Console.WriteLine("\t[0] - MENU PRINCIPAL");
                Console.Write("\tENTRADA -> ");

                if (int.TryParse(Console.ReadLine(), out int opcao))
                {
                    switch (opcao)
                    {
                        case 1:
                            RelatorioAdvogadosIdadeEntreDoisValores();
                            break;

                        case 2:
                            RelatorioClientesIdadeEntreDoisValores();
                            break;

                        case 3:
                            RelatorioEstadoCivilInformadoPeloCliente();
                            break;

                        case 4:
                            RelatorioClienteEmOrdemAlfabetica();
                            break;

                        case 5:
                            RelatorioClientesCujaProfissaoContenhaTexto();
                            break;

                        case 6:
                            RelatorioAdvogadosEClientesAniversariantesDoMes();
                            break;

                        case 0:
                            Console.WriteLine("\n\tOps, retornando ao menu prncipal!...");
                            App.Pause();
                            return;

                        default:
                            Console.WriteLine("\n\tOpção inválida. Por favor, escolha uma opção válida.");
                            App.Pause();
                            break;
                    }
                }
                else
                {
                    Console.WriteLine("\n\tPor favor, insira um valor numérico válido.");
                    App.Pause();
                }

            } while (true);
        }

        public void RelatorioClientesIdadeEntreDoisValores()
        {
            Console.WriteLine("\n\t========== RELATÓRIO DE CLIENTES COM IDADE ENTRE DOIS VALORES ==========");
            
            int valorMinimo = Cliente.LerNumeroInteiro("\n\tDigite o valor mínimo: ");

            int valorMaximo = Cliente.LerNumeroInteiro("\n\tDigite o valor máximo: ");

            var clientesFiltrados = clientes.GetClientes().Where(cliente => cliente.Idade >= valorMinimo && cliente.Idade <= valorMaximo);

            if (clientesFiltrados.Any())
            {
                Console.WriteLine("\n\tCLIENTE ENCONTRADOS:");
                foreach (var cliente in clientesFiltrados)
                {
                    App.LimparTela();
                    Console.WriteLine("\n\t=========== CLIENTES ===========");
                    Console.WriteLine($"\n\tNome: {cliente.Nome}");
                    Console.WriteLine($"\tIdade: {cliente.Idade}");
                    Console.WriteLine($"\tCPF: {cliente.Cpf}");
                    Console.WriteLine($"\tData de Nascimento: {cliente.DataNascimento.ToString("dd/MM/yyyy")}");
                    Console.WriteLine($"\tEstado Civil: {cliente.EstadoCivil}");
                    Console.WriteLine($"\tProfissão: {cliente.Profissao}");
                    Console.WriteLine($"\t==========================\n");
                }
            }
            else
            {
                Console.WriteLine("\n\tNenhum cliente encontrado.");
            }

            App.Pause();
        }

        public void RelatorioEstadoCivilInformadoPeloCliente()
        {
            if (clientes.GetClientes() == null)
            {
                Console.WriteLine("\n\tLista de clientes não fornecida. Retornando ao menu.");
                App.Pause();
                return;
            }

            Console.WriteLine("\n\t========== RELATÓRIO DE CLIENTES COM ESTADO CIVIL ==========");
            Console.Write("\n\tDigite o estado civil: ");
            string estadoCivil = Console.ReadLine()!;

            var clientesFiltrados = clientes.GetClientes().Where(cliente => cliente.EstadoCivil == estadoCivil);

            if (clientesFiltrados.Any())
            {
                App.LimparTela();
                Console.WriteLine("\n\tCLIENTES ENCONTRADOS:");
                foreach (var cliente in clientesFiltrados)
                {
                    Console.WriteLine("\n\t=========== CLIENTES ===========");
                    Console.WriteLine($"\n\tNome: {cliente.Nome}");
                    Console.WriteLine($"\tIdade: {cliente.Idade}");
                    Console.WriteLine($"\tCPF: {cliente.Cpf}");
                    Console.WriteLine($"\tEstado Civil: {cliente.EstadoCivil}");
                    Console.WriteLine($"\tProfissão: {cliente.Profissao}");
                    Console.WriteLine($"\t==========================\n");
                }
            }
            else
            {
                Console.WriteLine("\n\tNenhum cliente encontrado.");
            }

            App.Pause();
        }

        public void RelatorioClienteEmOrdemAlfabetica()
        {
            Console.WriteLine("\n\t========== RELATÓRIO DE CLIENTES EM ORDEM ALFABÉTICA ==========");


            var clientesOrdenados = clientes.GetClientes().OrderBy(cliente => cliente.Nome);

            if (clientesOrdenados.Count() > 0)
            {
                App.LimparTela();   
                Console.WriteLine("\n\tCLIENTES ENCONTRADOS:");
                foreach (var cliente in clientesOrdenados)
                {
                    Console.WriteLine("\n\t=========== CLIENTES ===========");
                    Console.WriteLine($"\n\tNome: {cliente.Nome}");
                    Console.WriteLine($"\tIdade: {cliente.Idade}");
                    Console.WriteLine($"\tCPF: {cliente.Cpf}");
                    Console.WriteLine($"\tEstado Civil: {cliente.EstadoCivil}");
                    Console.WriteLine($"\tProfissão: {cliente.Profissao}");
                    Console.WriteLine($"\t==========================\n");
                }
            }
            else
            {
                Console.WriteLine("\n\tNenhum paciente encontrado.");
            }

            App.Pause();
        }

        public void RelatorioClientesCujaProfissaoContenhaTexto()
        {
            Console.WriteLine("\n\t========== RELATÓRIO DE CLIENTES CUJO A PROFISSÃO CONTENHA TEXTO ==========");
            Console.Write("\n\tDigite o texto: ");
            string texto = Console.ReadLine()!;

            var pacientesFiltrados = clientes.GetClientes().Where(cliente => cliente.Profissao.Contains(texto));

            if (pacientesFiltrados.Count() > 0)
            {
                App.LimparTela();
                Console.WriteLine("\n\tCLIENTES ENCONTRADOS:");
                foreach (var paciente in pacientesFiltrados)
                {
                    Console.WriteLine("\n\t=========== CLIENTES ===========");
                    Console.WriteLine($"\n\tNome: {paciente.Nome}");
                    Console.WriteLine($"\tIdade: {paciente.Idade}");
                    Console.WriteLine($"\tCPF: {paciente.Cpf}");
                    Console.WriteLine($"\tEstado Civil: {paciente.EstadoCivil}");
                    Console.WriteLine($"\tProfissão: {paciente.Profissao}");
                    Console.WriteLine($"\t==========================\n");
                }
            }
            else
            {
                Console.WriteLine("\n\tNenhum cliente encontrado.");
            }

            App.Pause();
        }

        public void RelatorioClienteAniversarioMes()
        {
            Console.WriteLine("\n\t========== RELATÓRIO DE CLIENTES ANIVERSARIANTES DO MÊS ==========");

            var clienteFiltrados = clientes.GetClientes().Where(cliente => cliente.DataNascimento.Month == DateTime.Now.Month);

            if (clienteFiltrados.Count() > 0)
            {
                Console.WriteLine("\n\tCLIENTES ENCONTRADOS:");
                foreach (var cliente in clienteFiltrados)
                {
                    Console.WriteLine("\n\t=========== CLIENTES ===========");
                    Console.WriteLine($"\n\tNome: {cliente.Nome}");
                    Console.WriteLine($"\tIdade: {cliente.Idade}");
                    Console.WriteLine($"\tCPF: {cliente.Cpf}");
                    Console.WriteLine($"\tEstado Civil: {cliente.EstadoCivil}");
                    Console.WriteLine($"\tProfissão: {cliente.Profissao}");
                    Console.WriteLine($"\t==========================\n");
                }
            }
            else
            {
                Console.WriteLine("\n\tNenhum paciente encontrado.");
            }

            App.Pause();
        }

        public void RelatorioAdvogadosEClientesAniversariantesDoMes()
        {

            Console.WriteLine("\n\t========== RELATÓRIO DE ADVOGADOS E CLIENTES ANIVERSARIANTES DO MÊS ==========");

            var advogadosFiltrados = advogados.GetAdvogados().Where(advogado => advogado.DataNascimento.Month == DateTime.Now.Month);
            var clientesFiltrados = clientes.GetClientes().Where(cliente => cliente.DataNascimento.Month == DateTime.Now.Month);

            if (advogadosFiltrados.Count() > 0)
            {
                Console.WriteLine("\n\tADVOGADOS ENCONTRADOS:");
                foreach (var advogado in advogadosFiltrados)
                {
                    Console.WriteLine("\n\t=========== ADVOGADOS ===========");
                    Console.WriteLine($"\n\tNome: {advogado.Nome}");
                    Console.WriteLine($"\tIdade: {advogado.Idade}");
                    Console.WriteLine($"\tCPF: {advogado.Cpf}");
                    Console.WriteLine($"\tCNA: {advogado.Cna}");
                    Console.WriteLine($"\tEspecialidade: {advogado.Especialidade}");
                    Console.WriteLine($"\t==========================\n");
                }
                App.Pause();
            }
            else
            {
                Console.WriteLine("\n\tNenhum advogado encontrado.");
                App.Pause();
            }

            if (clientesFiltrados.Count() > 0)
            {
                Console.WriteLine("\n\tCLIENTES ENCONTRADOS:");
                foreach (var cliente in clientesFiltrados)
                {
                    Console.WriteLine("\n\t=========== CLIENTES ===========");
                    Console.WriteLine($"\n\tNome: {cliente.Nome}");
                    Console.WriteLine($"\tIdade: {cliente.Idade}");
                    Console.WriteLine($"\tCPF: {cliente.Cpf}");
                    Console.WriteLine($"\tEstado Civil: {cliente.EstadoCivil}");
                    Console.WriteLine($"\tProfissão: {cliente.Profissao}");
                    Console.WriteLine($"\t==========================\n");
                }
                App.Pause();
            }
            else
            {
                Console.WriteLine("\n\tNenhum cliente encontrado.");
                App.Pause();    
            }

            App.Pause();
        }

        public void RelatorioAdvogadoEmOrdemAlfabetica()
        {
            Console.WriteLine("\n\t=== Lista de Advogados em Ordem Alfabética ===");
            var advogadosOrdenados = advogados.GetAdvogados().OrderBy(advogado => advogado.Nome);

            foreach (Advogado advogado in advogadosOrdenados)
            {
                Console.WriteLine("\n\t=========== ADVOGADOS ===========");
                Console.WriteLine("\tNome: " + advogado.Nome);
                Console.WriteLine("\tCPF: " + advogado.Cpf);
                Console.WriteLine("\tData de Nascimento: " + advogado.DataNascimento.ToString("dd/MM/yyyy"));
                Console.WriteLine("\tIdade: " + advogado.Idade);
                Console.WriteLine("\tCNA: " + advogado.Cna);
                Console.WriteLine("\tEspecialidade: " + advogado.Especialidade);
                Console.WriteLine("\t==========================\n");
            }

            App.Pause();
        }

        public void RelatorioAdvogadoComIdadeMaiorQue()
        {
            Console.WriteLine("\n\t=== Lista de Advogados com Idade Maior que ===");
            Console.Write("\n\tDigite a idade: ");
            int idade = int.Parse(Console.ReadLine()!);

            var advogadosFiltrados = advogados.GetAdvogados().Where(advogado => advogado.Idade > idade);
            
            App.LimparTela();
            foreach (Advogado advogado in advogadosFiltrados)
            {
                Console.WriteLine("\n\t=========== ADVOGADOS ===========");
                Console.WriteLine("\tNome: " + advogado.Nome);
                Console.WriteLine("\tCPF: " + advogado.Cpf);
                Console.WriteLine("\tData de Nascimento: " + advogado.DataNascimento.ToString("dd/MM/yyyy"));
                Console.WriteLine("\tIdade: " + advogado.Idade);
                Console.WriteLine("\tCNA: " + advogado.Cna);
                Console.WriteLine("\tEspecialidade: " + advogado.Especialidade);
                Console.WriteLine("\t==========================\n");
            }

            App.Pause();
        }

        public void RelatorioAdvogadosIdadeEntreDoisValores()
        {
            Console.WriteLine("\n\t=== Lista de Advogados com Idade Entre ===");

            int valorMinimo = Cliente.LerNumeroInteiro("\n\tDigite o valor mínimo: ");

            Console.Write("\n\tDigite a idade máxima: ");
            int valorMaximo = Cliente.LerNumeroInteiro("\n\tDigite o valor máximo: ");

            var advogadosFiltrados = advogados.GetAdvogados().Where(advogado => advogado.Idade >= valorMinimo && advogado.Idade <= valorMaximo);

            App.LimparTela();
            foreach (Advogado advogado in advogadosFiltrados)
            {
                Console.WriteLine("\n\t=========== ADVOGADOS ===========");
                Console.WriteLine("\tNome: " + advogado.Nome);
                Console.WriteLine("\tCPF: " + advogado.Cpf);
                Console.WriteLine("\tData de Nascimento: " + advogado.DataNascimento.ToString("dd/MM/yyyy"));
                Console.WriteLine("\tIdade: " + advogado.Idade);
                Console.WriteLine("\tCNA: " + advogado.Cna);
                Console.WriteLine("\tEspecialidade: " + advogado.Especialidade);
                Console.WriteLine("\t==========================\n");
            }

            App.Pause();
        }

        public void RelatorioAdvogadoComIdadeMenorQue()
        {
            Console.WriteLine("\n\t=== Lista de Advogados com Idade Menor que ===");
            Console.Write("\n\tDigite a idade: ");
            int idade = int.Parse(Console.ReadLine()!);

            var advogadosFiltrados = advogados.GetAdvogados().Where(advogado => advogado.Idade < idade);

            App.LimparTela();
            foreach (Advogado advogado in advogadosFiltrados)
            {
                Console.WriteLine("\n\t=========== ADVOGADOS ===========");
                Console.WriteLine("\tNome: " + advogado.Nome);
                Console.WriteLine("\tCPF: " + advogado.Cpf);
                Console.WriteLine("\tData de Nascimento: " + advogado.DataNascimento.ToString("dd/MM/yyyy"));
                Console.WriteLine("\tIdade: " + advogado.Idade);
                Console.WriteLine("\tCNA: " + advogado.Cna);
                Console.WriteLine("\tEspecialidade: " + advogado.Especialidade);
                Console.WriteLine("\t==========================\n");
            }

            App.Pause();
        }

        public void RelatorioAdvogadoComIdadeIgualA()
        {
            Console.WriteLine("\n\t=== Lista de Advogados com Idade Igual a ===");
            Console.Write("\n\tDigite a idade: ");
            int idade = int.Parse(Console.ReadLine()!);

            var advogadosFiltrados = advogados.GetAdvogados().Where(advogado => advogado.Idade == idade);

            App.LimparTela();
            foreach (Advogado advogado in advogadosFiltrados)
            {
                Console.WriteLine("\n\t=========== ADVOGADOS ===========");
                Console.WriteLine("\tNome: " + advogado.Nome);
                Console.WriteLine("\tCPF: " + advogado.Cpf);
                Console.WriteLine("\tData de Nascimento: " + advogado.DataNascimento.ToString("dd/MM/yyyy"));
                Console.WriteLine("\tIdade: " + advogado.Idade);
                Console.WriteLine("\tCNA: " + advogado.Cna);
                Console.WriteLine("\tEspecialidade: " + advogado.Especialidade);
                Console.WriteLine("\t==========================\n");
            }

            App.Pause();
        }

        public void RelatorioAdvogadoComIdadeDiferenteDe()
        {
            Console.WriteLine("\n\t=== Lista de Advogados com Idade Diferente de ===");
            Console.Write("\n\tDigite a idade: ");
            int idade = int.Parse(Console.ReadLine()!);

            var advogadosFiltrados = advogados.GetAdvogados().Where(advogado => advogado.Idade != idade);

            App.LimparTela();
            foreach (Advogado advogado in advogadosFiltrados)
            {
                Console.WriteLine("\n\t=========== ADVOGADOS ===========");
                Console.WriteLine("\tNome: " + advogado.Nome);
                Console.WriteLine("\tCPF: " + advogado.Cpf);
                Console.WriteLine("\tData de Nascimento: " + advogado.DataNascimento.ToString("dd/MM/yyyy"));
                Console.WriteLine("\tIdade: " + advogado.Idade);
                Console.WriteLine("\tCNA: " + advogado.Cna);
                Console.WriteLine("\tEspecialidade: " + advogado.Especialidade);
                Console.WriteLine("\t==========================\n");
            }

            App.Pause();
        }

        public void RelatorioAdvogadoComIdadeMaiorOuIgualA()
        {
            Console.WriteLine("\n\t=== Lista de Advogados com Idade Maior ou Igual a ===");
            Console.Write("\n\tDigite a idade: ");
            int idade = int.Parse(Console.ReadLine()!);

            var advogadosFiltrados = advogados.GetAdvogados().Where(advogado => advogado.Idade >= idade);

            App.LimparTela();
            foreach (Advogado advogado in advogadosFiltrados)
            {
                Console.WriteLine("\n\t=========== ADVOGADOS ==========="); 
                Console.WriteLine("\tNome: " + advogado.Nome);
                Console.WriteLine("\tCPF: " + advogado.Cpf);
                Console.WriteLine("\tData de Nascimento: " + advogado.DataNascimento.ToString("dd/MM/yyyy"));
                Console.WriteLine("\tIdade: " + advogado.Idade);
                Console.WriteLine("\tCNA: " + advogado.Cna);
                Console.WriteLine("\tEspecialidade: " + advogado.Especialidade);
                Console.WriteLine("\t==========================\n");
            }

            App.Pause();
        }
    }
}