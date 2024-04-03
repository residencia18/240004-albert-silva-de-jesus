namespace exercicio5.Pessoa{

public class Pessoa{

    private string nome;
    private int idade;
    private double altura;


    Pessoa(string nome, int idade, double altura){
        this.nome = nome;  
        this.idade = idade;
        this.altura = altura;        
    }

    public void mostraPessoa(){
        System.Console.WriteLine($"Nome : {this.getNome}\nIdade : {this.idade}\nAltura: {this.altura}" );
    }

    public string getNome(){
        return this.nome;
    }

    public int getIdade(){
        this.idade;
    }

    public double getAltura(){
        this.altura;
    }

    public void setNome(string nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    



}

}