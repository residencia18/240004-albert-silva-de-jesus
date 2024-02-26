package atvemsala.cliente;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        limparTela();
        System.out.println("\n\t====================");
        System.out.printf("\tInforme o nome: ");
        String nome = scan.nextLine();

        System.out.printf("\n\tInforme o cpf: ");
        String cpf = scan.nextLine();

        Cliente cliente = new Cliente(nome, cpf);

        limparTela();
        System.out.println("\t=========CLIENTE=========");
        System.out.printf("\tNome: %s\n\tcpf: %s", cliente.getNome(), cliente.getCpf());
        System.out.println("\n\t=========================");
        pausa(scan);

        limparTela();
        cliente.setNome("Albert");
        System.out.println("\n\t=====NOME ALTERADO=====");
        System.out.println("\tNome atual: "+ cliente.getNome() + "\n");
        System.out.printf("\tAtributo idade inicializada com %d no construtor", cliente.getIdade());
        System.out.println("\n\t====================");

        limparTela();
        System.out.println("\n\t====================");
        System.out.printf("\n\tInforme a idade: ");
        int idade = scan.nextInt();
        cliente.setIdade(idade);

        limparTela();
        System.out.println("\n\t=====IDADE ALTERADA=====");
        System.out.printf("\n\tA Idade atual de %s é %d.", cliente.getNome(), cliente.getIdade());
        System.out.println("\n\t==============================");

        scan.close();
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
