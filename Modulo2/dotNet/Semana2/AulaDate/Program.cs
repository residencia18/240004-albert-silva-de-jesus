DateTime now =  DateTime.Now;
System.Console.WriteLine($"Currente date and time: {now}");

DateTime hoje = DateTime.Today;
System.Console.WriteLine($"Currente date : {hoje}");

hoje = hoje.AddDays(1);
System.Console.WriteLine($"Currente date : {hoje}");

DateTime specificDate = new DateTime(1998,07,12);
System.Console.WriteLine(specificDate);
System.Console.WriteLine(specificDate.DayOfWeek);
