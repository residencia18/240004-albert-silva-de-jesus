string texto = "Texto para ser manipulado";
Console.WriteLine(texto.ToUpper());
Console.WriteLine(texto.ToLower());
Console.WriteLine(texto.Length);
string[] nameSplited = texto.Split(" ");

foreach(string teste in nameSplited){
    Console.WriteLine(teste);
}

Console.WriteLine(texto.Trim());

Console.WriteLine(string.IsNullOrWhiteSpace(texto));