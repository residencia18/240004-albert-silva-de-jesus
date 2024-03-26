List<string> list = new List<string> {"Helder","Allana","Valber","João"};

System.Console.WriteLine(list.Any(x => x.Contains("a")));

System.Console.WriteLine(list.First(x=>x.Contains("a")));

list.OrderBy(x=>x);

List<int> listaInteiros = new List<int> {1,2,3,4};

System.Console.WriteLine(listaInteiros.Where(x => x>2).Sum(x=>x));