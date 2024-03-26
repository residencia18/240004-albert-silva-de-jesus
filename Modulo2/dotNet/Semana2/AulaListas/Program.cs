// Código relacionado a exercicio com listas

List<int> numbers = new List<int>();

for(int i = 1 ; i < 25 ; i+=2){
    numbers.Add(i);
}

numbers.Remove(21);


foreach(int i in numbers){
    Console.WriteLine(i);
}
