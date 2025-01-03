/*Suponha um método que preenche um array de nomes de pessoas. – Escreva um método que verifica se um nome específico está presente
no array. – Elabore uma versão deste método usando o array e outra convertenddo o array para uma lista – Escreva um método que MODIFICA um 
nome específico no array, se ele existir (gere uma exception caso contrário) – Elabore uma versão deste método usando o array e outra
convertenddo o array para uma lista */
package semana6.atvEmSala.array;

import semana6.atvEmSala.array.entities.ListaNomes;

public class Main {

    public static void main(String[] args) {

        limparTela();
        ListaNomes listaNomes = new ListaNomes(new String[] { "João", "Maria", "José", "Ana", "Pedro", "Paulo",
                "Carlos", "Marta", "Lucas", "Luciana" });

        System.out.println("Imprime os nomes da lista");
        listaNomes.imprimeNomes();
        System.out.println();

        System.out.println("Verifica se o nome está na lista");
        System.out.println(listaNomes.getNomes()[0] + " " + listaNomes.verificaNome("João"));
        System.out.println("Joãozinho"+ " "+ listaNomes.verificaNome("Joãozinho"));
        System.out.println();

        System.out.println("Modifica o nome na lista");
        try {
            listaNomes.modificaNome("João", 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Imprime os nomes da lista");
        listaNomes.imprimeNomes();

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
