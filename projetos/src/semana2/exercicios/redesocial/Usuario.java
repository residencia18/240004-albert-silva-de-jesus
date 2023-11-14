package semana2.exercicios.redesocial;

import java.util.ArrayList;

public class Usuario {

    private String nome;
    private String email;
    private String nacionalidade;
    private ArrayList<String> postagens;

    public Usuario() {
        postagens = new ArrayList<String>();
    }

    public Usuario(String nome, String email, String nacionalidade) {
        this.nome = nome;
        this.email = email;
        this.nacionalidade = nacionalidade;
        postagens = new ArrayList<String>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public ArrayList<String> getPostagens() {
        return postagens;
    }

    public void setPostagens(ArrayList<String> postagens) {
        this.postagens = postagens;
    }

    public void adicionaPostagem(String postagem){
        this.postagens.add(postagem);
    }

    public void imprimePostagens(){
        for(int i = 0; i < postagens.size(); i++){

            System.out.println("Postagens: "+ postagens.get(i));
        }
    }

    @Override
    public String toString() {
        return String.format("\n\tNome: %s\n\tEmail: %s\n\tNacionalidade: %s\n", nome, email, nacionalidade);
    }

}
