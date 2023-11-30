using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AvaliacaoDotNet
{
    public class Relatorios
    {
        ListaCliente clientes;

        public Relatorios(ListaCliente clientes)
        {
            this.clientes = clientes;
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
                            // RelatorioAdvogadosIdadeEntreDoisValores();
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
                            // RelatorioAdvogadosClientesAniversariantesDoMes();
                            break;

                        case 0:
                            Console.WriteLine("\n\tOps, retornando ao menu prncipal!...");
                            App.Pause();
                            return;

                        default:
                            Console.WriteLine("\n\tOpção inválida. Por favor, escolha uma opção válida.");
                            break;
                    }
                }
                else
                {
                    Console.WriteLine("\n\tPor favor, insira um valor numérico válido.");
                }

            } while (true);
        }

        public void RelatorioClientesIdadeEntreDoisValores()
        {
            Console.WriteLine("\n\t========== RELATÓRIO DE CLIENTES COM IDADE ENTRE DOIS VALORES ==========");
            Console.Write("\n\tDigite o valor mínimo: ");
            int valorMinimo = int.Parse(Console.ReadLine()!);

            Console.Write("\n\tDigite o valor máximo: ");
            int valorMaximo = int.Parse(Console.ReadLine()!);

            var clientesFiltrados = clientes.GetClientes().Where(cliente => cliente.Idade >= valorMinimo && cliente.Idade <= valorMaximo);

            if (clientesFiltrados.Any())
            {
                Console.WriteLine("\n\tCLIENTE ENCONTRADOS:");
                foreach (var cliente in clientesFiltrados)
                {
                    Console.WriteLine($"\n\tNome: {cliente.Nome}");
                    Console.WriteLine($"\tIdade: {cliente.Idade}");
                    Console.WriteLine($"\tCPF: {cliente.Cpf}");
                    Console.WriteLine($"\tData de Nascimento: {cliente.DataNascimento.ToString("dd/MM/yyyy")}");
                    Console.WriteLine($"\tEstado Civil: {cliente.EstadoCivil}");
                    Console.WriteLine($"\tProfissão: {cliente.Profissão}");
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
                Console.WriteLine("\n\tPACIENTES ENCONTRADOS:");
                foreach (var cliente in clientesFiltrados)
                {
                    Console.WriteLine($"\n\tNome: {cliente.Nome}");
                    Console.WriteLine($"\tIdade: {cliente.Idade}");
                    Console.WriteLine($"\tCPF: {cliente.Cpf}");
                    Console.WriteLine($"\tEstado Civil: {cliente.EstadoCivil}");
                    Console.WriteLine($"\tProfissão: {cliente.Profissão}");
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
                Console.WriteLine("\n\tCLIENTES ENCONTRADOS:");
                foreach (var cliente in clientesOrdenados)
                {
                    Console.WriteLine($"\n\tNome: {cliente.Nome}");
                    Console.WriteLine($"\tIdade: {cliente.Idade}");
                    Console.WriteLine($"\tCPF: {cliente.Cpf}");
                    Console.WriteLine($"\tEstado Civil: {cliente.EstadoCivil}");
                    Console.WriteLine($"\tProfissão: {cliente.Profissão}");
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

            var pacientesFiltrados = clientes.GetClientes().Where(cliente => cliente.Profissão.Contains(texto));

            if (pacientesFiltrados.Count() > 0)
            {
                Console.WriteLine("\n\tPACIENTES ENCONTRADOS:");
                foreach (var paciente in pacientesFiltrados)
                {
                    Console.WriteLine($"\n\tNome: {paciente.Nome}");
                    Console.WriteLine($"\tIdade: {paciente.Idade}");
                    Console.WriteLine($"\tCPF: {paciente.Cpf}");
                    Console.WriteLine($"\tEstado Civil: {paciente.EstadoCivil}");
                    Console.WriteLine($"\tProfissão: {paciente.Profissão}");
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
                Console.WriteLine("\n\tPACIENTES ENCONTRADOS:");
                foreach (var cliente in clienteFiltrados)
                {
                    Console.WriteLine($"\n\tNome: {cliente.Nome}");
                    Console.WriteLine($"\tIdade: {cliente.Idade}");
                    Console.WriteLine($"\tCPF: {cliente.Cpf}");
                    Console.WriteLine($"\tEstado Civil: {cliente.EstadoCivil}");
                    Console.WriteLine($"\tProfissão: {cliente.Profissão}");
                }
            }
            else
            {
                Console.WriteLine("\n\tNenhum paciente encontrado.");
            }

            App.Pause();
        }
    }
}