


var tuple1 = (10,20);
Console.WriteLine(tuple1.Item1 + tuple1.Item2);

var tuple2 = (X:5 , Y:50);
Console.WriteLine($"Tuple 2 : {tuple2.X} , {tuple2.Y}");

var tuple3 = (id:10 , name:"João" , born: new DateTime(1998,7,12));
Console.WriteLine($"Tuple 3 : {tuple3.id} , {tuple3.name} , {tuple3.born}");

List<(int id , string name, DateTime born)> list = new();

list.Add(tuple3);
list.Add((2,"Alemão",new DateTime(1942,10,12)));
list.ForEach(x => Console.WriteLine($"Tuple 4 : {x.id},{x.name},{x.born.ToShortDateString()}"));


