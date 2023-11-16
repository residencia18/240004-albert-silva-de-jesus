using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace P002
{
    public class Tarefa
    {
        private static int proximoId = 1;
        private int id;
        private string titulo;
        private string descricao;
        private DateTime dataCriacao;
        private bool concluida;
        private List<Tarefa> tarefas;

        public Tarefa()
        {
            tarefas = new List<Tarefa>();
        }
        public Tarefa(string titulo, string descricao)
        {
            this.id = proximoId++;
            this.titulo = titulo;
            this.descricao = descricao;
            this.dataCriacao = DateTime.Now;
            tarefas = new List<Tarefa>();
        }

        public string getTitulo()
        {
            return this.titulo;
        }

        public void setTitulo(string titulo)
        {
            this.titulo = titulo;
        }

        public int getId()
        {
            return this.id;
        }

        public string getDescricao()
        {
            return this.descricao;
        }

        public void setDescricao(string descricao)
        {
            this.descricao = descricao;
        }

        public DateTime getDataCriacao()
        {
            return this.dataCriacao;
        }

        public void setDataCriacao(DateTime dataCriacao)
        {
            this.dataCriacao = dataCriacao;
        }

        public bool getConcluida()
        {
            return this.concluida;
        }

        public void setConcluida(bool concluida)
        {
            this.concluida = concluida;
        }

        public List<Tarefa> GetTarefas()
        {
            return tarefas;
        }

        public void SetTarefas(List<Tarefa> novaListaDeTarefas)
        {
            tarefas = novaListaDeTarefas;
        }

        public void adicionar()
        {

            Console.WriteLine("\n\t========== CADASTRAR TAREFA ==========");
            Console.Write("\n\tInforme o Título: ");
            string? titulo = Console.ReadLine();

            Console.Write("\n\tInforme a Descrição: ");
            string? descricao = Console.ReadLine();

            Tarefa tarefa = new Tarefa(titulo, descricao);

            tarefas.Add(tarefa);
            Console.Write("\n\tTarefa cadastrada com sucesso, pressione Enter para continuar... ");
            Console.ReadLine();
        }

        public void listar()
        {
            int opcao = 0;

            if (tarefas.Count == 0)
            {
                Console.WriteLine("\n\tOps, nenhuma tarefa cadastrada!");
                Console.Write("\n\tPressione Enter para continuar... ");
                Console.ReadLine();
            }
            else
            {
                Console.Write("\n\tDeseja listar as tarefas concluídas ou não concluídas?\n\n\t[1] - CONCLUÍDAS\n\t[2] - NÃO CONCLUÍDAS\n\t[0] - VOLTAR\n\tENTRADA -> ");
                opcao = Int32.Parse(Console.ReadLine());
                LimparTela();

                if (opcao == 0)
                {
                    return;
                }
                else
                {
                    if (opcao != 1 && opcao != 2)
                    {
                        Console.WriteLine("\n\tOpção inválida, pressione Enter para continuar... ");
                        Console.ReadLine();
                        return;
                    }
                    else
                    {
                        if (opcao == 1)
                        {
                            // Verificar se há pelo menos uma tarefa concluída na lista
                            bool temTarefaConcluida = tarefas.Any(tarefa => tarefa.concluida);

                            if (temTarefaConcluida == false)
                            {
                                Console.WriteLine("\n\tOps, nenhuma tarefa concluída!");
                                Console.Write("\n\tPressione Enter para continuar... ");
                                Console.ReadLine();
                                return;
                            }

                            Console.WriteLine("\n\t========== LISTAR TAREFAS CONCLUÍDAS ==========");

                            foreach (Tarefa tarefa in tarefas)
                            {
                                if (tarefa.getConcluida())
                                {
                                    Console.WriteLine("\n\tID: " + tarefa.getId());
                                    Console.WriteLine("\tTítulo: " + tarefa.getTitulo());
                                    Console.WriteLine("\tDescrição: " + tarefa.getDescricao());
                                    Console.WriteLine("\tData de Criação: " + tarefa.getDataCriacao());
                                    Console.WriteLine("\tConcluída: Sim");
                                }
                            }
                            Console.WriteLine("\t====================================");
                            Console.Write("\tPressione Enter para continuar... ");
                            Console.ReadLine();
                        }
                        else
                        {

                            if (opcao == 2)
                            {
                                Console.WriteLine("\n\t========== LISTAR TAREFAS NÃO CONCLUÍDAS ==========");

                                foreach (Tarefa tarefa in tarefas)
                                {
                                    if (!tarefa.getConcluida())
                                    {
                                        Console.WriteLine("\n\tID: " + tarefa.getId());
                                        Console.WriteLine("\tTítulo: " + tarefa.getTitulo());
                                        Console.WriteLine("\tDescrição: " + tarefa.getDescricao());
                                        Console.WriteLine("\tData de Criação: " + tarefa.getDataCriacao());
                                        Console.WriteLine("\tConcluída: Não");
                                    }
                                }
                                Console.WriteLine("\t====================================");
                                Console.Write("\tPressione Enter para continuar... ");
                                Console.ReadLine();
                            }
                        }
                    }
                }
            }
        }

        public void editar()
        {

            Console.WriteLine("\n\t========== EDITAR TAREFA ==========");

            Console.Write("\n\tInforme o ID da tarefa que deseja editar: ");
            int id = Int32.Parse(Console.ReadLine());

            Tarefa tarefa = tarefas.Find(t => t.getId() == id);

            if (tarefa != null)
            {
                Console.Write("\n\tInforme o novo Título: ");
                string? titulo = Console.ReadLine();

                Console.Write("\n\tInforme a nova Descrição: ");
                string? descricao = Console.ReadLine();

                tarefa.setTitulo(titulo);
                tarefa.setDescricao(descricao);

                Console.WriteLine("\n\tTarefa editada com sucesso!");
                Console.Write("\n\tPressione Enter para continuar... ");
                Console.ReadLine();
            }
            else
            {
                Console.WriteLine("\n\tOps, nenhuma tarefa encontrada com o ID informado!");
                Console.Write("\n\tPressione Enter para continuar... ");
                Console.ReadLine();
            }
        }

        public void excluir()
        {

            Console.WriteLine("\n\t========== EXCLUIR TAREFA ==========");

            Console.Write("\n\tInforme o ID da tarefa que deseja excluir: ");
            int id = Int32.Parse(Console.ReadLine());

            Tarefa tarefa = tarefas.Find(t => t.getId() == id);

            if (tarefa != null)
            {
                tarefas.Remove(tarefa);
                Console.WriteLine("\n\tTarefa excluída com sucesso!");
                Console.Write("\n\tPressione Enter para continuar... ");
                Console.ReadLine();
            }
            else
            {
                Console.WriteLine("\n\tOps, nenhuma tarefa encontrada com o ID informado!");
                Console.Write("\n\tPressione Enter para continuar... ");
                Console.ReadLine();
            }
        }

        public void marcarTarefaComoConcluida()
        {

            Console.WriteLine("\n\t========== MARCAR TAREFA COMO CONCLUÍDA ==========");

            Console.Write("\n\tInforme o ID da tarefa que deseja marcar como concluída: ");
            int id = Int32.Parse(Console.ReadLine());

            Tarefa tarefa = tarefas.Find(t => t.getId() == id);

            if (tarefa != null)
            {

                tarefa.setConcluida(true);
                Console.WriteLine("\n\tTarefa marcada como concluída com sucesso!");
                Console.Write("\n\tPressione Enter para continuar... ");
                Console.ReadLine();
            }
            else
            {

                Console.WriteLine("\n\tOps, nenhuma tarefa encontrada com o ID informado!");
                Console.Write("\n\tPressione Enter para continuar... ");
                Console.ReadLine();
            }
        }

        public void pesquisar()
        {

            Console.WriteLine("\n\t========== PESQUISAR TAREFA ==========");

            Console.Write("\n\tInforme o id da tarefa que deseja pesquisar: ");
            int id = Int32.Parse(Console.ReadLine());

            Tarefa tarefa = tarefas.Find(t => t.getId() == id);

            if (tarefa != null)
            {
                LimparTela();
                Console.WriteLine("\n\t========== TAREFA ENCONTRADA ==========");
                Console.WriteLine("\n\tID: " + tarefa.getId());
                Console.WriteLine("\tTítulo: " + tarefa.getTitulo());
                Console.WriteLine("\tDescrição: " + tarefa.getDescricao());
                Console.WriteLine("\tData de Criação: " + tarefa.getDataCriacao());
                Console.WriteLine("\tConcluída: " + tarefa.getConcluida());
                Console.WriteLine("\t====================================");
                Console.Write("\tPressione Enter para continuar... ");
                Console.ReadLine();
            }
            else
            {
                LimparTela();
                Console.WriteLine("\n\tOps, nenhuma tarefa encontrada com o Título informado!");
                Console.Write("\n\tPressione Enter para continuar... ");
                Console.ReadLine();
            }
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

    }
}