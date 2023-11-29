// See https://aka.ms/new-console-template for more information
using System;
using System.Globalization;

namespace semana2
{
  class Program
  {
    static void Main(string[] args)
    {
      Console.Clear();

      Console.WriteLine("Informe a data de nascimento (formato: dd/MM/yyyy):");
      string inputDataNascimento = Console.ReadLine()!;

      if (DateTime.TryParseExact(inputDataNascimento, "dd/MM/yyyy", null, System.Globalization.DateTimeStyles.None, out DateTime dataNascimento))
      {
        // Validar se a data de nascimento é razoável (não no futuro)
        if (dataNascimento > DateTime.Now)
        {
          Console.WriteLine("A data de nascimento não pode estar no futuro.");
        }
        else
        {
          // Usando uma expressão lambda para calcular a idade
          Func<int, int> calcularIdade = anoNascimento =>
          {
            DateTime dataAtual = DateTime.Now;
            int idade = dataAtual.Year - anoNascimento;

            // Ajuste se a data de aniversário ainda não ocorreu este ano
            if (dataAtual.Month < dataNascimento.Month || (dataAtual.Month == dataNascimento.Month && dataAtual.Day < dataNascimento.Day))
            {
              idade--;
            }

            return idade;
          };

          // Chamar a expressão lambda e exibir a idade
          int idade = calcularIdade(dataNascimento.Year);
          Console.WriteLine($"Sua idade é: {idade} anos");
        }
      }
      else
      {
        Console.WriteLine("Data de nascimento inválida. Certifique-se de usar o formato dd/MM/yyyy.");
      }

      // Pega a data atual do sistema operacional e armazena na variável data.
      var data = DateTime.Now;

      //Imprime a data atual do sistema operacional.
      var formatada = string.Format("{0:yyyy/MM/dd hh:mm:ss}", data);
      Console.WriteLine(formatada);

      //Imprime o mes atual do sistema operacional e o ano.
      formatada = string.Format("{0:y}", data);
      Console.WriteLine(formatada);

      // Imprime o dia da semana com a data atual do sistema operacional e hora.
      formatada = string.Format("{0:f}", data);
      Console.WriteLine(formatada);

      // Imprime a data atual do sistema operacional formatada.
      formatada = string.Format("{0:D}", data);
      Console.WriteLine(formatada);

      // Imprime a data atual do sistema operacional formatada em inglês.
      // formatada = string.Format("{0:r}", data);
      // Console.WriteLine(formatada);

      // formatada = string.Format("{0:s}", data);
      // Console.WriteLine(formatada);

      // formatada = string.Format("{0:u}", data);
      // Console.WriteLine(formatada);

      // Pega a cultura do sistema operacional e armazena na variável atual.
      var pt = new CultureInfo("pt-PT");
      var br = new CultureInfo("pt-BR");
      var en = new CultureInfo("en-US");
      var atual = CultureInfo.CurrentCulture;

      // Imprime a data atual do sistema operacional formatada em português usando ToString.
      Console.WriteLine(DateTime.Now.ToString("D", en));
      Console.WriteLine(DateTime.Now.ToString("D", atual));

      Console.WriteLine(data.AddDays(2));
      Console.WriteLine(data.AddMonths(2));
      Console.WriteLine(data.AddYears(2));

      // Comparação de datas. 
      if (data.Date == DateTime.Now.Date)
      {
        Console.WriteLine("As datas são iguais.");
      }
      else
      {
        Console.WriteLine("As datas são diferentes.");
      }

      // var data = new DateTime(2023, 11, 16, 8, 30, 52);
      // Console.WriteLine(data);
      // Console.WriteLine(data.Year);
      // Console.WriteLine(data.Month);
      // Console.WriteLine(data.Day);
      // Console.WriteLine(data.Hour);
      // Console.WriteLine(data.Minute);
      // Console.WriteLine(data.Second);

      // Pegar o dia do ano.
      Console.WriteLine(data.DayOfYear);

      // Dia da semana em inglês (Monday, Tuesday, etc) e transfroma em um inteiro. 
      // Console.WriteLine((int)data.DayOfWeek);
    }
  }
}
