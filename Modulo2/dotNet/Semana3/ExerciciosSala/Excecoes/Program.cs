using System;

public class Example
{
   public static void Main()
   {
      double number1 = 3000;
      double number2 = 0;

      System.Console.WriteLine(divisao(number1, number2));

   }

   public static double divisao(double number1,double number2){
      try {
         return number1/number2;
      }
      catch (DivideByZeroException) {
         Console.WriteLine("Não é possivel dividir por zero.");
         return number1;
      }
      
   }
}
// The example displays the following output:
//        Division of 3000 by zero.