/*Suponha que você tenha uma classe que implementa uma lista de usuários (ArrayList da classe Usuario) e você quer criar o método listar()
com três formas diferentes
listar() → lista todos os usuários
listar(int x) → lista todos os usuários a partir da posição x
listar (int x, int y) → lista todos os usuários entre as posições x e y (mesmo que y seja menor que x) */
package semana5.atvEmSala.sobrecarca;

public class Main {
    
    public static void main(String[] args) throws Exception {

        Usuarios usuario1 = new Usuarios("João", "123.456.789-00");
        Usuarios usuario2 = new Usuarios("Maria", "987.654.321-00");
        Usuarios usuario3 = new Usuarios("José", "456.789.123-00");
        Usuarios usuario4 = new Usuarios("Ana", "654.321.987-00");
        Usuarios usuario5 = new Usuarios("Carlos", "321.654.987-00");
        Usuarios usuario6 = new Usuarios("Mariana", "789.123.456-00");
        Usuarios usuario7 = new Usuarios("Pedro", "321.987.654-00");
        Usuarios usuario8 = new Usuarios("Paula", "789.456.123-00");
        Usuarios usuario9 = new Usuarios("Lucas", "987.321.654-00");
        Usuarios usuario10 = new Usuarios("Luana", "456.789.321-00");

        usuario1.cadastrarUsuario(usuario1);
        usuario1.cadastrarUsuario(usuario2);
        usuario1.cadastrarUsuario(usuario3);
        usuario1.cadastrarUsuario(usuario4);
        usuario1.cadastrarUsuario(usuario5);
        usuario1.cadastrarUsuario(usuario6);
        usuario1.cadastrarUsuario(usuario7);
        usuario1.cadastrarUsuario(usuario8);
        usuario1.cadastrarUsuario(usuario9);
        usuario1.cadastrarUsuario(usuario10);

        usuario1.listarUsuarios();
        System.out.println("=====================================");
        usuario1.listarUsuarios(5);
        System.out.println("=====================================");
        usuario1.listarUsuarios(5, 8);

    }
}
