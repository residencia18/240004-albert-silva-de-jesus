package exercicios.redesocial;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Usuario {

    private static final AtomicLong contador = new AtomicLong(1);
    private long id;
    private String nome;
    private String email;
    private String nacionalidade;
    private int quantidadeDePostagens;
    private int pontuacao;
    private ArrayList<String> postagens;

    public Usuario() {
        postagens = new ArrayList<String>();
    }

    public Usuario(String nome, String email, String nacionalidade) {
        this.nome = nome;
        this.email = email;
        this.nacionalidade = nacionalidade;
        this.quantidadeDePostagens = 0;
        this.pontuacao = 0;
        postagens = new ArrayList<String>();
        id = gerarID();
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

    public int getQuantidadeDePostagens() {
        return quantidadeDePostagens;
    }

    public void setQuantidadeDePostagens(int quantidadeDePostagens) {
        this.quantidadeDePostagens = quantidadeDePostagens;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public ArrayList<String> getPostagens() {
        return postagens;
    }

    public void setPostagens(ArrayList<String> postagens) {
        this.postagens = postagens;
    }

    public void adicionaPostagem(String postagem) {
        this.postagens.add(postagem);
        this.quantidadeDePostagens++;
    }

    public long getId() {
        return id;
    }

    public static long gerarID() {
        return contador.getAndIncrement();
    }

    public void imprimePostagens() {
        System.out.println("\n\t==========Postagens==========\n");
        System.out.print("\t");
        for (int i = 0; i < postagens.size(); i++) {
            System.out.print("," + postagens.get(i));
        }
        System.out.println("\n\t==============================");
    }

    public void imprimeUsuario() {
        System.out.println("\n\t==========Usuário==========\n");
        for (int i = 0; i < postagens.size(); i++) {
            System.out.println("\t" + postagens.get(i));
        }
    }

    public void alteraPontuacao(int delta) {

        if ((pontuacao + delta) <= 0) {
            System.out.println("\n\tOps, pontuação não pode ser igual ou menor que zero!");
        } else {
            this.pontuacao += delta;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "\n\tId: %d\n\tNome: %s\n\tEmail: %s\n\tNacionalidade: %s\n\tQuantidade de postagens: %d\n\tPontuação: %d",id, nome,
                email, nacionalidade, quantidadeDePostagens, pontuacao);
    }

}
