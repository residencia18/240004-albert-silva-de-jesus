int[] vetorInteiros = new int[10];

for(int i = 0 ; i < 10 ; i++){
    vetorInteiros[i] = i+1;
}

foreach(var i in vetorInteiros){
    System.Console.WriteLine(i);
}