using System;
int divisores;
double limite;
for(int i = 2 ; i < 10000000 ; i++){
    divisores=0;
    limite = Math.Sqrt(i)+1;
    for(int j = 2 ; j < limite ; j++){
        if(i%j == 0){
            divisores++;
            break;
        }
    }
    if(divisores==0){
        Console.WriteLine($"{i}");
    }
}
