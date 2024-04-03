class TestClass
{
    static void Main(string[] args)
    {
        for(int i = 0 ; i < 100 ; i++){
            Console.WriteLine(calculaFibonacci(i));
        }
        
    }

    public static int calculaFibonacci(int n){
        return (n == 0 ) ? 0 : (n==1) ? 1 : (calculaFibonacci(n-2)+calculaFibonacci(n-1));
    }
}


