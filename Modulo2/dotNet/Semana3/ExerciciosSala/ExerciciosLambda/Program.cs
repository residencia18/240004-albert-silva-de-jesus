
// Func<int,int,int> sum = (x,y) => x + y;
// Console.WriteLine($"Sum : {sum(10,20)}");

// Action<string> greet = name =>
// {
//     string greeting = $"Hello {name}";
//     Console.WriteLine(greeting);
// };

// string person = Console.ReadLine() ?? "";
// greetPerson();

// Func<string, int , string > is BiggerThan = (string s , int x ) => s.Lenght > x ? "Yes" : "No";
// var size = 5;
// Console.WriteLine($"The text {person} has more than {size} chars ? {isBiggerThan(person,size)}");
string[] people = { "HeNder" , "Nicole" , "Gilvana"};
char letter = 'N';
Console.WriteLine($"People with name started with '{letter}' : {string.Join(",",people.Where(x => x.Contains(letter)))} ");