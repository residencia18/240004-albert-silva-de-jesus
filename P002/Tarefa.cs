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
            string titulo = Console.ReadLine();

            Console.Write("\n\tInforme a Descrição: ");
            string descricao = Console.ReadLine();

            Tarefa tarefa = new Tarefa(titulo, descricao);

            tarefas.Add(tarefa);
            Console.Write("\n\tTarefa cadastrada com sucesso, pressione Enter para continuar... ");
            Console.ReadLine();
        }

        public void listar()
        {

            Console.WriteLine("\n\t========== LISTAR TAREFAS ==========");
            if (tarefas.Count == 0)
            {
                Console.WriteLine("\n\tOps, nenhuma tarefa cadastrada!");
                Console.Write("\n\tPressione Enter para continuar... ");
                Console.ReadLine();
            }
            else
            {
                foreach (Tarefa tarefa in tarefas)
                {
                    Console.WriteLine("\n\tID: " + tarefa.getId());
                    Console.WriteLine("\tTítulo: " + tarefa.getTitulo());
                    Console.WriteLine("\tDescrição: " + tarefa.getDescricao());
                    Console.WriteLine("\tData de Criação: " + tarefa.getDataCriacao());

                    if (tarefa.getConcluida())
                    {
                        Console.WriteLine("\tConcluída: Sim");
                    }
                    else
                    {
                        Console.WriteLine("\tConcluída: Não");
                    }
                }
                Console.WriteLine("\n\t====================================");
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

    }
}