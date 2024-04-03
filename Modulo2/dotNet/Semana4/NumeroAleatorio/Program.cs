Random aleatorio = new Random();

int numeroSecreto = aleatorio.Next(1,101);
int qtdChutes = 0;


do {
    Console.Write("Digite um número entre 1 e 100: ");
    int chute = int.Parse(Console.ReadLine());

    if(chute == numeroSecreto) {
    break;
    } else if(chute < numeroSecreto) {
    Console.WriteLine("O número é maior.");
    } else {
    Console.WriteLine("O número é menor.");
    }
    qtdChutes++;

} while(true);

Console.WriteLine($"Parabéns! Você acertou o número com {qtdChutes+1} chutes.");
