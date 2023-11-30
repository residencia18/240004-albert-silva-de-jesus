using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Threading.Tasks;

namespace AvaliacaoDotNet
{
    public class ListaAdvogado
    {
        public List<Advogado> advogados { get; set; }

        public ListaAdvogado()
        {
            advogados = new List<Advogado>();
        }

        public void AdicionarAdvogado(Advogado advogado)
        {
            advogados.Add(advogado);
        }

        public List<Advogado> GetAdvogados()
        {
            return advogados;
        }

         public void Cadastrar()
        {
            Console.Write("\n\tDigite o nome do advogado: ");
            string nome = Console.ReadLine()!;
            nome = Cliente.ConvertePrimeiraLetraParaMaiuscula(nome);

            string cpf;
            do
            {
                Console.Write("\n\tDigite o CPF do advogado: ");
                cpf = Console.ReadLine()!;

                if (!Advogado.IsValidCPF(cpf) || !Advogado.IsCpfUnico(cpf, advogados))
                {
                    Console.WriteLine("\n\tOps, CPF inválido ou já existe no cadastro. Por favor, digite um CPF válido.");
                    App.Pause();
                }

            } while (!Advogado.IsValidCPF(cpf) || !Advogado.IsCpfUnico(cpf, advogados));

            DateTime dataNascimento = Advogado.ObterDataDeNascimento();

            Console.Write("\n\tDigite o CNA do advogado: ");
            string cna = Console.ReadLine()!;

            Console.Write("\n\tDigite a especialidade do advogado: ");
            string especialidades = Console.ReadLine()!;

            AdicionarAdvogado(new Advogado(nome, dataNascimento, 43, cpf, cna, especialidades));

        }

        public void Listar()
        {
            Console.WriteLine("\n\t=== Lista de Pacientes ===");
            foreach (Advogado advogado in advogados)
            {
                Console.WriteLine("\tNome: " + advogado.Nome);
                Console.WriteLine("\tCPF: " + advogado.Cpf);
                Console.WriteLine("\tData de Nascimento: " + advogado.DataNascimento.ToString("dd/MM/yyyy"));
                Console.WriteLine("\tIdade: " + advogado.Idade);
                Console.WriteLine("\tCNA: " + advogado.Cna);
                Console.WriteLine("\tEspecialidade: " + advogado.Especialidade);
                Console.WriteLine("\t==========================\n");
            }
        }
    }
}