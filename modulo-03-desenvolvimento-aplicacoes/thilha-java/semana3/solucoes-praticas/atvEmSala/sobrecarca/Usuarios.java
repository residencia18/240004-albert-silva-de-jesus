package semana5.atvEmSala.sobrecarca;

import java.util.ArrayList;

public class Usuarios {

    private String nome;
    private String cpf;
    private ArrayList<Usuarios> usuarios; // Change the ArrayList type to Usuario

    public Usuarios() {
        usuarios = new ArrayList<>();
    }

    public Usuarios(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Usuarios cadastrarUsuario(Usuarios usuario) {
        if (usuarios == null) {
            usuarios = new ArrayList<>();
        }
        usuarios.add(usuario);
        return usuario;
    }

    public void listarUsuarios() {
        for (Usuarios usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void listarUsuarios(int x) {
        for (int i = x; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i));
        }
    }

    public void listarUsuarios(int x, int y) {
        for (int i = x; i < y && i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i));
        }
    }

    public ArrayList<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
