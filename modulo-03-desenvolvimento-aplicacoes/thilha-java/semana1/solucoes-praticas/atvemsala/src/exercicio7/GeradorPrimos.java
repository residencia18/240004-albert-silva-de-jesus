package exercicio7;

public class GeradorPrimos {

    int n;

    public GeradorPrimos(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void divisores(int n) {

        System.out.print("\n\tDivisores de N: ");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.printf("%d,", i);
            }
        }
        System.out.print("\n");
    }

    private int quantDivisores(int n) {

        int quantidadeTotalDivisores = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                quantidadeTotalDivisores++;
            }
        }

        return quantidadeTotalDivisores;
    }

    public boolean ePrimo(int x) {

        if (quantDivisores(x) == 2) {
            return true;
        }

        return false;
    }

    public void numerosPrimos(int x) {

        for(int i = 1; i <= x; i++){

            if(ePrimo(x)){
                System.out.printf("%d, ", x);
                x--;
            }else{
                x--;
            }
        }

    }
}
