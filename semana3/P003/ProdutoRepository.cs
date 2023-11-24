using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Globalization;

namespace P003
{
    public interface ProdutoRepository
    {
        void Cadastrar();

        void Listar();

        void Editar();

        void Excluir();

        void Pesquisar();

        static int ObterOpcaoMenuPrincipal()
        {
            int opcao = -1;
            do
            {
                LimparTela();
                DataHoraAtual();
                Console.WriteLine("\t===== MENU PRINCIPAL =====");
                Console.WriteLine("\t[1] - CADASTRAR");
                Console.WriteLine("\t[2] - LISTAR");
                Console.WriteLine("\t[3] - EDITAR");
                Console.WriteLine("\t[4] - REMOVER");
                Console.WriteLine("\t[5] - PESQUISAR");
                Console.WriteLine("\t[6] - ESTATÍSTICAS");
                Console.WriteLine("\t[0] - SAIR");
                Console.Write("\tENTRADA -> ");
                string userInput = Console.ReadLine()!;

                if (!string.IsNullOrEmpty(userInput) && Int32.TryParse(userInput, out opcao))
                {
                    // A conversão foi bem-sucedida
                    if (opcao < 0 || opcao > 6)
                    {
                        Console.WriteLine("\n\tOpção inválida. Por favor, escolha uma opção de 0 a 6.");
                        Pause();
                    }
                }
                else
                {
                    Console.WriteLine("\n\tEntrada inválida. Por favor, insira um número válido.");
                    Pause();
                }

            } while (opcao > 6 || opcao < 0);

            return opcao;
        }

        static void MenuProduto(Produto produto)
        {
            int opcao = 0;
            do
            {
                opcao = ObterOpcaoMenuPrincipal();
                switch (opcao)
                {
                    case 1:
                        LimparTela();
                        produto.Cadastrar();
                        break;

                    case 2:
                        LimparTela();
                        produto.Listar();
                        break;

                    case 3:
                        LimparTela();
                        produto.Editar();
                        break;

                    case 4:
                        LimparTela();
                        produto.Excluir();
                        break;

                    case 5:
                        LimparTela();
                        produto.Pesquisar();
                        break;

                    case 6:
                        LimparTela();
                        // produto.Estatisticas();
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

        static void DataHoraAtual()
        {

            var data = DateTime.Now;
            var formatada = string.Format("\n\t{0:f}", data);
            Console.WriteLine(formatada);
            Console.WriteLine("\tFalta " + (365 - data.DayOfYear) + " dias para o fim do ano.\n");
        }
        static void LimparTela()
        {
            // Limpar a tela no Windows ou Linux
            if (Environment.OSVersion.Platform == PlatformID.Win32NT)
            {
                Console.Clear(); // Windows
            }
            else
            {
                Console.Write("\u001b[2J\u001b[1;1H"); // Linux
            }
        }
        static void Pause()
        {
            Console.Write("\n\tPressione Enter para continuar...");
            Console.ReadLine();
        }
    }
}