using System.Globalization;

double valor = 3.4589;
byte idade = 32;
double saldo = 3.5784;
string nome = "Maria";
Console.WriteLine("Valor com 3 Casas : " + valor.ToString("F3"));
Console.WriteLine("Valor com 5 Casas : " + valor.ToString("F5"));
Console.WriteLine("Valor com 2 Casas e com delimitado : " + valor.ToString("F5",CultureInfo.InvariantCulture));
Console.WriteLine("{0} tem {1} anos e tem saldo igual a {2:F2} reais",nome,idade,saldo); //Place Holder
Console.WriteLine($"{nome} tem {idade} e tem um saldo igual a {saldo:F2} reais"); // Interpolação
Console.WriteLine(nome + " tem " + idade + " anos e tem um saldo igual a "+ saldo.ToString("F2",CultureInfo.InvariantCulture) + " reais"); // Concatenação
Console.WriteLine("--------------------------------------------");

string produto1 = "Computador";
string produto2 = "Mesa de escritório";
idade=30;
int codigo = 5290;
char genero = 'M';


double preco1 = 2100.0;
double preco2 = 650.50;
double medida = 53.234567;

Console.WriteLine("Produtos:");
Console.WriteLine($"{produto1}, cujo preço é $ {preco1:F2}");
Console.WriteLine($"{produto2}, cujo preço é $ {preco2:F2}");
Console.WriteLine("");

Console.WriteLine($"Registro: {idade} anos de idade, código {codigo} e gênero: {genero}");
Console.WriteLine("");

Console.WriteLine($"Medida com oito casas decimais: {medida:F8}");
Console.WriteLine($"Arredondado (três casas decimais): {medida:F8}");
Console.WriteLine("Separador decimal invariant culture: {0}",medida.ToString("F3",CultureInfo.InvariantCulture));

