package atvemsala.exemplodejavaec;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        Conta conta = new Conta();

        limparTela();
        conta.inicializa("Conta Corrente", 100);
        System.out.printf("\n\tTipo da Conta: %s\n\tSaldo R$ %.2f\n", conta.getNome(), conta.getSaldo());
        pausa(scan);

        limparTela();
        conta.depositar(100);
        System.out.printf("\n\tApos o deposito de R$100,00 reais, saldo atual R$%.2f", conta.getSaldo());
        pausa(scan);

        limparTela();
        conta.saque(105);
        System.out.printf("\n\tApos o saque de R$105,00 reais, saldo atual R$%.2f", conta.getSaldo());
    }

    public static void limparTela() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            // Trata exceções (pode ser uma exceção de interrupção)
            e.printStackTrace();
        }
    }

    public static void pausa(Scanner scan) {
        System.out.print("\n\tPressione ENTER para continuar...");
        scan.nextLine();
    }
}
