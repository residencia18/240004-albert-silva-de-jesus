/*Suponha que você tenha uma classe que implementa uma lista de usuários (ArrayList da classe Usuario) e você quer criar o método listar()
com três formas diferentes
listar() → lista todos os usuários
listar(int x) → lista todos os usuários a partir da posição x
listar (int x, int y) → lista todos os usuários entre as posições x e y (mesmo que y seja menor que x) */
package semana5.atvEmSala.sobrecarca;

public class Main {

    public static void main(String[] args) throws Exception {

        limparTela(); 
        Usuarios usuario = new Usuarios();  

        usuario.cadastrarUsuario(new Usuarios("João", "123.456.789-00"));
        usuario.cadastrarUsuario(new Usuarios("José", "456.789.123-00"));
        usuario.cadastrarUsuario(new Usuarios("Ana", "654.321.987-00"));
        usuario.cadastrarUsuario(new Usuarios("Carlos", "321.654.987-00"));
        usuario.cadastrarUsuario(new Usuarios("Mariana", "789.123.456-00"));
        usuario.cadastrarUsuario(new Usuarios("Pedro", "321.987.654-00"));
        usuario.cadastrarUsuario(new Usuarios("Paula", "789.456.123-00"));
        usuario.cadastrarUsuario(new Usuarios("Lucas", "987.321.654-00"));
        usuario.cadastrarUsuario(new Usuarios("Luana", "456.789.321-00"));

        usuario.listarUsuarios();
        System.out.println("=====================================");
        // usuario1.listarUsuarios(2);
        System.out.println("=====================================");
        usuario.listarUsuarios(2, 5);
        System.out.println("=====================================");
        usuario.listarUsuarios(3);

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
