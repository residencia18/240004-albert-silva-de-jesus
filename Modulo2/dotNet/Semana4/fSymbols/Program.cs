// See https://aka.ms/new-console-template for more information

void exibiMensagem(){
    Console.WriteLine("Hᴇʟʟᴏ Wᴏʀʟᴅ");
}



exibiMensagem();

void exibirMenu(){
    Console.WriteLine("1 - Opção 1");
    Console.WriteLine("2 - Opção 2");
    Console.WriteLine("3 - Opção 3");
    Console.WriteLine("4 - Opção 4");
    Console.Write("Sua escolha : ");
    string? opcaoEscolhida = Console.ReadLine();
    int escolhaNumerica = int.Parse(opcaoEscolhida);
    switch(escolhaNumerica){
        case 1:
            Console.WriteLine("Escolha 1");
            break;
        case 2:
            Console.WriteLine("Escolha 2");
            break;
        case 3:
            Console.WriteLine("Escolha 3");
            break;
        case 4:
            Console.WriteLine("Escolha 4");
            break;
        default:
            Console.WriteLine("Escolha Inválida");
            break;
    }
}

int idade = 25;
string nome = "João";
Console.WriteLine("Nome: {0}, Idade: {1}", nome, idade);

Console.WriteLine($"Nome: {nome}, Idade: {idade}");

double preco = 49.99;
DateTime data = DateTime.Now;
Console.WriteLine("Preço: {0:C}, Data: {1:d}", preco, data);
Console.WriteLine($"Preço: {preco}, Data: {data}");

exibirMenu();