using System;
using System.IO;
using System.Collections.Generic;

namespace AvaliacaoDotNet
{
    public static class App
    {
        public static bool menuClienteOuAdvogado()
        {
            int opcao = -1;
            do
            {
                // LimparTela();
                DataHoraAtual();
                Console.WriteLine("\t===== GESTÃO ESCRITÓRIO DE ADVOCACIA =====");
                Console.WriteLine("\t[1] - CLIENTE");
                Console.WriteLine("\t[2] - ADVOGADO");
                Console.WriteLine("\t[0] - SAIR");
                Console.Write("\tENTRADA -> ");
                string userInput = Console.ReadLine()!;

                if (!string.IsNullOrEmpty(userInput) && Int32.TryParse(userInput, out opcao))
                {
                    // A conversão foi bem-sucedida
                    if (opcao < 0 || opcao > 2)
                    {
                        Console.WriteLine("\n\tOpção inválida. Por favor, escolha uma opção de 0 a 2.");
                        Pause();
                    }
                }
                else
                {
                    Console.WriteLine("\n\tEntrada inválida. Por favor, insira um número válido.");
                    Pause();
                }

            } while (opcao > 2 || opcao < 0);

            if (opcao == 1)
            {
                return true;
            }
            else
            {
                return false;
            }

        }
        public static int ObterOpcaoMenuPrincipal()
        {
            int opcao = -1;
            do
            {
                LimparTela();
                DataHoraAtual();
                Console.WriteLine("\t===== GESTÃO DO ESCRITÓRIO =====");
                Console.WriteLine("\t[1] - CADASTRAR");
                Console.WriteLine("\t[2] - LISTAR");
                Console.WriteLine("\t[3] - EDITAR");
                Console.WriteLine("\t[4] - REMOVER");
                Console.WriteLine("\t[5] - PESQUISAR");
                Console.WriteLine("\t[6] - RELATÓRIOS");
                Console.WriteLine("\t[7] - RETORNAR AO MENU PRINCIPAL");
                Console.WriteLine("\t[0] - SAIR");
                Console.Write("\tENTRADA -> ");
                string userInput = Console.ReadLine()!;


                if (!string.IsNullOrEmpty(userInput) && Int32.TryParse(userInput, out opcao))
                {
                    // A conversão foi bem-sucedida
                    if (opcao < 0 || opcao > 7)
                    {
                        Console.WriteLine("\n\tOpção inválida. Por favor, escolha uma opção de 0 a 7.");
                        Pause();
                    }
                }
                else
                {
                    Console.WriteLine("\n\tEntrada inválida. Por favor, insira um número válido.");
                    Pause();
                }

            } while (opcao > 7 || opcao < 0);

            return opcao;
        }
        public static void MenuGestaoDeEscritorio(ListaCliente clientes, ListaAdvogado advogados, Persistencia persistencia)
        {
            int opcao = 0;
            Relatorios relatorios = new Relatorios(clientes, advogados);
            persistencia.CarregarArquivosCliente(clientes);
            // persistencia.CarregarArquivosAdvogado(clientes, advogados);

            if (menuClienteOuAdvogado())
            {
                do
                {
                    opcao = ObterOpcaoMenuPrincipal();

                    switch (opcao)
                    {
                        case 1:
                            LimparTela();
                            clientes.Cadastrar();
                            persistencia.SalvarArquivosCliente(clientes);
                            break;

                        case 2:
                            LimparTela();
                            clientes.Listar();
                            Pause();
                            break;

                        case 3:
                            LimparTela();
                            clientes.editar();
                            break;

                        case 4:
                            LimparTela();
                            clientes.excluir();
                            break;

                        case 5:
                            LimparTela();
                            clientes.Pesquisar();
                            break;

                        case 6:
                            LimparTela();
                            relatorios.MenuRelatorios();
                            break;

                        case 7:
                            LimparTela();
                            MenuGestaoDeEscritorio(clientes, advogados, persistencia);
                            break;

                        case 0:
                            Console.WriteLine("\n\tSaindo...");
                            break;

                        default:
                            Console.WriteLine("\n\tOpção inválida!");
                            break;
                    }
                } while (opcao != 0);
            }
            else
            {
                do
                {
                    opcao = ObterOpcaoMenuPrincipal();

                    switch (opcao)
                    {
                        case 1:
                            LimparTela();
                            advogados.Cadastrar();
                            persistencia.SalvarArquivosAdvogado(advogados);
                            break;

                        case 2:
                            LimparTela();
                            advogados.Listar();
                            Pause();
                            break;

                        case 3:
                            LimparTela();
                            advogados.Editar();
                            Pause();
                            break;

                        case 4:
                            LimparTela();
                            advogados.Excluir();
                            break;

                        case 5:
                            LimparTela();
                            advogados.Pesquisar();
                            break;

                        case 6:
                            LimparTela();
                            relatorios.MenuRelatorios();
                            break;

                        case 7:
                            LimparTela();
                            MenuGestaoDeEscritorio(clientes, advogados, persistencia);
                            break;

                        case 0:
                            Console.WriteLine("\n\tSaindo...");
                            break;

                        default:
                            Console.WriteLine("\n\tOpção inválida!");
                            break;
                    }
                } while (opcao != 0);
            }
        }
        public static void DataHoraAtual()
        {
            var data = DateTime.Now;
            var formatada = string.Format("\n\t{0:f}", data);
            Console.WriteLine(formatada);
            Console.WriteLine("\tFalta " + (365 - data.DayOfYear) + " dias para o fim do ano.\n");
        }
        public static void LimparTela()
        {
            // Console.Clear(); // Windows

            if (Environment.OSVersion.Platform != PlatformID.Win32NT)
            {
                Console.Write("\u001b[2J\u001b[1;1H"); // Linux
            }
        }
        public static void Pause()
        {
            Console.Write("\n\tPressione Enter para continuar...");
            Console.ReadLine();
        }
    }
}