using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Globalization;

namespace AvaliacaoDotNet
{
    public class Cliente : Pessoa
    {
        public string EstadoCivil { get; set; }
        public string Profissao { get; set; }

        public Cliente(string nome, string cpf, DateTime dataNascimento, string estadoCivil = "Não informado", string profissao = "Não informado")
        : base(nome, dataNascimento, cpf, idade: 0)
        {
            this.EstadoCivil = estadoCivil;
            this.Profissao = profissao;
            // Calcular a idade ao criar o objeto
            this.Idade = CalcularIdade(this.DataNascimento);
        }

        public static int LerNumeroInteiro(string mensagem)
        {
            while (true)
            {
                Console.Write(mensagem);

                string input = Console.ReadLine()!;

                if (string.IsNullOrEmpty(input))
                {
                    Console.WriteLine("Entrada inválida. Por favor, insira um valor numérico.");
                    continue;
                }

                if (int.TryParse(input, out int valor))
                {
                    return valor;
                }
                else
                {
                    Console.WriteLine("Entrada inválida. Por favor, insira um valor numérico válido.");
                }
            }
        }
        public static bool IsCpfUnico(string cpf, List<Cliente> clientes)
        {
            // Verifica se o CPF é válido antes de proceder
            if (!IsValidCPF(cpf))
            {
                throw new ArgumentException("\n\tOps, CPF inválido!...");
            }

            // Verifica se o CPF já existe na lista de pacientes
            return !clientes.Any(paciente => paciente.Cpf == cpf);
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
                Console.Write("\n\tDigite a data de nascimento do paciente (no formato dd/MM/yyyy): ");
                inputDataNascimento = Console.ReadLine()!;

            } while (!TentarObterDataValida(inputDataNascimento, out dataNascimento));

            return dataNascimento;
        }

        public static bool estadoCivil(String estadoCivil)
        {

            if (estadoCivil == "Solteiro" || estadoCivil == "Casado" || estadoCivil == "Divorciado" || estadoCivil == "Viúvo")
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        private int CalcularIdade(DateTime dataNascimento)
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