package entities;

import java.util.Scanner;

import exception.DivisaoPorZeroException;

public class Calculadora {

    public static Scanner scan = new Scanner(System.in);
    double num1, num2;

    public static double adicao(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtracao(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiplicacao(double num1, double num2) {
        return num1 * num2;
    }

    public static double divisao(double num1, double num2) throws DivisaoPorZeroException {

        if (num2 == 0) {
            throw new DivisaoPorZeroException("\n\tOps, não é possível dividir por zero!");
        }

        return num1 / num2;
    }

    public static void executar() {
        
        limparTela();
        System.out.println("\n\t====== Calculadora ======");
        System.out.print("\n\tDigite o primeiro número: ");
        double num1 = scan.nextDouble();

        System.out.print("\n\tDigite o segundo número: ");
        double num2 = scan.nextDouble();

        limparTela();   
        System.out.print(
                "\n\tDigite a operação desejada:\n\t+ para adição\n\t- para subtração\n\t* para multiplicação\n\t/ para divisão\n\tEscolha: ");
        String operacao = scan.next();

        limparTela();
        double resultado = 0;

        switch (operacao) {
            case "+":
                resultado = adicao(num1, num2);
                break;

            case "-":
                resultado = subtracao(num1, num2);
                break;

            case "*":
                resultado = multiplicacao(num1, num2);
                break;

            case "/":
                try {
                    resultado = divisao(num1, num2);

                } catch (DivisaoPorZeroException e) {
                    System.out.println(e.getMessage());
                }
                break;

            default:
                System.out.println("\n\tOps, operação inválida!");
                break;
        }

        System.out.println("\n\tO resultado é: " + resultado);
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
}
