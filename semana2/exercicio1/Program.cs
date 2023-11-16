// See https://aka.ms/new-console-template for more information
using System;
using System.Globalization;

namespace exercicio1
{
    class Program
    {
        static void Main(string[] args)
        {
            LimparTela();
            Console.WriteLine("\n\t========== EXERCICIO 1 ==========");
            for (int i = 0; i < 30; i++)
            {
                if (i % 3 == 0)
                {
                    Console.WriteLine("\tDivisiveis por 3, entre 0 e 30: " + i);
                }
            }
            Console.WriteLine("\t==================================");
            Pause();

            LimparTela();
            Console.WriteLine("\n\t========== EXERCICIO 1 ==========");
            for (int i = 0; i < 30; i++)
            {
                if (i % 4 == 0)
                {
                    Console.WriteLine("\tDivisiveis por 4, entre 0 e 30: " + i);
                }
            }
            Console.WriteLine("\t==================================");
            Pause();

            LimparTela();
            Console.WriteLine("\n\t========== EXERCICIO 2 ==========");

            string serieFibonacci = "";
            int anterior = 0;
            int atual = 1;

            Console.Write(anterior);
            while (atual <= 100)
            {
                serieFibonacci += atual + " ";
                int proximo = anterior + atual;
                anterior = atual;
                atual = proximo;
            }
            Console.WriteLine("A série de Fibonacci até 100: " + serieFibonacci);


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
