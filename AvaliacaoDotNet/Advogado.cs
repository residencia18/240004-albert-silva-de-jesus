using System.Globalization;

namespace AvaliacaoDotNet
{
    public class Advogado : Pessoa
    {
        public int Cna { get; set; }
        public string Especialidade { get; set; }

        public Advogado(string nome, DateTime dataNascimento, string cpf, int cna, string especialidade)
        : base(nome, dataNascimento, cpf, idade: 0)
        {
            Cna = cna;
            Especialidade = especialidade;
            // Calcular a idade ao criar o objeto
            Idade = CalcularIdade(dataNascimento);
        }

        public static bool IsCpfUnico(string cpf, List<Advogado> advogados)
        {
            // Verifica se o CPF é válido antes de proceder
            if (!IsValidCPF(cpf))
            {
                throw new ArgumentException("\n\tOps, CPF inválido!...");
            }

            // Verifica se o CPF já existe na lista de pacientes
            return !advogados.Any(advogado => advogado.Cpf == cpf);
        }

        public static bool IsValidCPF(string cpf)
        {
            // Remover caracteres não numéricos
            string numbersOnly = new string(cpf.Where(char.IsDigit).ToArray());

            // Verificar se o CPF possui 11 dígitos
            if (numbersOnly.Length != 11)
            {
                return false;
            }

            // Calcular os dígitos verificadores
            int[] cpfDigits = numbersOnly.Select(c => int.Parse(c.ToString())).ToArray();
            int sum = 0;

            for (int i = 0; i < 9; i++)
            {
                sum += cpfDigits[i] * (10 - i);
            }

            int firstDigit = 11 - (sum % 11);
            if (firstDigit > 9)
            {
                firstDigit = 0;
            }

            sum = 0;
            for (int i = 0; i < 10; i++)
            {
                sum += cpfDigits[i] * (11 - i);
            }

            int secondDigit = 11 - (sum % 11);
            if (secondDigit > 9)
            {
                secondDigit = 0;
            }

            // Verifica se os dígitos calculados correspondem aos dígitos informados no CPF
            return cpfDigits[9] == firstDigit && cpfDigits[10] == secondDigit;
        }

        public static int ValidarEntradaCNA(string mensagem)
        {
            int valor;

            do
            {
                App.LimparTela();
                Console.WriteLine("\n\t========== GESTÃO DE ADVOCACIA ========== ");
                Console.Write($"\t{mensagem}: ");

                string input = Console.ReadLine()!;

                try
                {
                    // Remova espaços em branco e verifique se o comprimento é válido
                    input = input.Replace(" ", "").Trim();

                    if (input.Length != 6)
                    {
                        throw new FormatException("\n\tOps, entrada inválida! O CNA deve ter 6 caracteres.");
                    }

                    valor = Int32.Parse(input);

                    if (valor <= 0)
                    {
                        throw new OverflowException("\n\tOps, entrada inválida! O valor não pode ser menor ou igual a zero.");
                    }

                    return valor;
                }
                catch (FormatException)
                {
                    App.LimparTela();
                    Console.WriteLine($"\n\tOps, entrada inválida. Por favor, insira um CNA válido (6 dígitos).");
                    App.Pause();
                }
                catch (OverflowException ex)
                {
                    App.LimparTela();
                    Console.WriteLine(ex.Message);
                    App.Pause();
                }

            } while (true);
        }

        public static string ConvertePrimeiraLetraParaMaiuscula(string palavra)
        {
            string palavraComMaiuscula = "";
            bool converteu = true;

            do
            {
                // Verifica se a string não está vazia
                if (!string.IsNullOrEmpty(palavra))
                {
                    // Verifica se todos os caracteres na palavra são letras
                    if (palavra.All(char.IsLetter))
                    {
                        // Converte a primeira letra para maiúscula
                        palavraComMaiuscula = char.ToUpper(palavra[0]) + palavra.Substring(1);
                        converteu = false;
                    }
                    else
                    {
                        Console.WriteLine("\n\tA string deve conter apenas letras.");
                        Console.Write("\tPressione Enter para continuar... ");
                        Console.ReadLine();
                        App.LimparTela();

                        Console.Write("\n\tInforme o nome do Paciente: ");
                        palavra = Console.ReadLine()!;
                    }
                }
                else
                {
                    Console.WriteLine("\n\tA string está vazia.");
                    Console.Write("\tPressione Enter para continuar... ");
                    Console.ReadLine();
                    App.LimparTela();

                    Console.Write("\n\tInforme o nome do Paciente: ");
                    palavra = Console.ReadLine()!;
                }
            } while (converteu);

            return palavraComMaiuscula;
        }

        public static DateTime ObterDataDeNascimento()
        {
            string inputDataNascimento;
            DateTime dataNascimento;

            do
            {
                Console.Write("\n\tDigite a data de nascimento do advogado (no formato dd/MM/yyyy): ");
                inputDataNascimento = Console.ReadLine()!;

            } while (!TentarObterDataValida(inputDataNascimento, out dataNascimento));

            return dataNascimento;
        }

        public int CalcularIdade(DateTime dataNascimento)
        {
            int idade = DateTime.Now.Year - dataNascimento.Year;

            // Verificar se o aniversário já ocorreu neste ano
            if (dataNascimento.Date > DateTime.Now.Date.AddYears(-idade))
            {
                idade--;
            }

            return idade;
        }

        public static bool TentarObterDataValida(string input, out DateTime data)
        {
            if (DateTime.TryParseExact(input, "dd/MM/yyyy", CultureInfo.InvariantCulture, DateTimeStyles.None, out data)
                && data.Date <= DateTime.Now.Date)
            {
                return true;
            }

            // Se a conversão falhar ou a data for no futuro, retorne false
            Console.WriteLine("\n\tFormato de data inválido ou data no futuro. Digite novamente.");
            return false;
        }

    }
}