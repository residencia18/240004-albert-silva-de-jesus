package atvemsala.redesocial;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

        cadastrarUsuario(scan, listaUsuarios);

        listarUsuarios(scan, listaUsuarios);

        editarUsuario(scan, listaUsuarios);

        listarUsuarios(scan, listaUsuarios);

        excluiUsuario(scan, listaUsuarios);

        listarUsuarios(scan, listaUsuarios);

        scan.close();

    }

    public static void cadastrarUsuario(Scanner scan, ArrayList<Usuario> listaUsuarios) {

        String opcao;

        do {

            limparTela();
            System.out.println("\n\t==============CADASTRAR USUÁRIO==============");

            System.out.printf("\n\tDigite seu nome: ");
            String nome = scan.nextLine();

            System.out.printf("\n\tDigite seu email: ");
            String email = scan.nextLine();

            System.out.printf("\n\tDigite sua nacionalidade: ");
            String nacionalidade = scan.nextLine();

            Usuario usuario = new Usuario(nome, email, nacionalidade);
            listaUsuarios.add(usuario);

            System.out.printf("\n\tDeseja cadastrar outro usuário? (S/N): ");
            opcao = scan.nextLine();

            if (opcao.equalsIgnoreCase("n")) {
                break;
            }

        } while (opcao != "n");

    }

    public static void listarUsuarios(Scanner scan, ArrayList<Usuario> listaUsuarios) {

        limparTela();
        System.out.println("\n\t==============LISTAR USUÁRIOS==============");

        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println(listaUsuarios.get(i));
        }
        pausa(scan);

    }

    public static void editarUsuario(Scanner scan, ArrayList<Usuario> listaUsuarios) {

        limparTela();
        System.out.println("\n\t==============EDITAR USUÁRIO==============");

        System.out.printf("\n\tDigite o ID do usuário que deseja editar: ");
        long id = scan.nextLong();
        scan.nextLine();

        for (int i = 0; i < listaUsuarios.size(); i++) {

            if (listaUsuarios.get(i).getId() == id) {

                System.out.printf("\n\tDigite o novo nome: ");
                String nome = scan.nextLine();

                System.out.printf("\n\tDigite o novo email: ");
                String email = scan.nextLine();

                System.out.printf("\n\tDigite a nova nacionalidade: ");
                String nacionalidade = scan.nextLine();

                listaUsuarios.get(i).setNome(nome);
                listaUsuarios.get(i).setEmail(email);
                listaUsuarios.get(i).setNacionalidade(nacionalidade);

                System.out.println("\n\tUsuário editado com sucesso!");
                pausa(scan);
                break;
            }
        }

    }

    public static void excluiUsuario(Scanner scan, ArrayList<Usuario> listaUsuarios) {

        limparTela();
        System.out.println("\n\t==============EXCLUIR USUÁRIO==============");

        System.out.printf("\n\tDigite o ID do usuário que deseja excluir: ");
        long id = scan.nextLong();
        scan.nextLine();

        for (int i = 0; i < listaUsuarios.size(); i++) {

            if (listaUsuarios.get(i).getId() == id) {

                listaUsuarios.remove(i);

                System.out.println("\n\tUsuário excluído com sucesso!");
                pausa(scan);
                break;
            }
        }

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
