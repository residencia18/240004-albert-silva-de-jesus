package semana2.exercicios.exemplodejavaec;

public class Main {
    
    public static void main(String[] args){

        Conta conta = new Conta();

        conta.inicializa("Conta Corrente", 100);
        System.out.println("\n\tNome: "+ conta.getNome());
    }
}
