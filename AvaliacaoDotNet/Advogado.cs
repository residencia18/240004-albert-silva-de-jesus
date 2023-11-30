using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AvaliacaoDotNet
{
    public class Advogado : Pessoa
    {
        public string Cna { get; set; }
        public string Especialidade { get; set; }

        public Advogado(string nome, DateTime dataNascimento,int idade, string cpf, string cna, string especialidade) 
        : base(nome, dataNascimento, cpf, idade)
        {
            Cna = cna;
            Especialidade = especialidade;
        }
    }
}