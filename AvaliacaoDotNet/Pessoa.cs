namespace AvaliacaoDotNet
{
    public abstract class Pessoa
    {
        public string Nome { get; set; }
        public string Cpf { get; set; }
        public DateTime DataNascimento { get; set; }

        public int Idade { get; set; }

        public Pessoa(string nome, DateTime dataNascimento, string cpf, int idade)
        {
            this.Nome = nome;
            this.DataNascimento = dataNascimento;
            this.Cpf = cpf;
            this.Idade = idade;
        }

    }
}