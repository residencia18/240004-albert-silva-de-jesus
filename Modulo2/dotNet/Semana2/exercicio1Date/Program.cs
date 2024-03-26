string dataStr = "25/10/2023";
string[] strings = dataStr.Split('/');

foreach (var item in strings)
{
    System.Console.WriteLine(item);
}
