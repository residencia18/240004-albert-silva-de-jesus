package semana7.atvsala.filmes.entities;

import java.util.ArrayList;
import java.util.List;

public class Filme {
    
    private String titulo;
    private int ano;
    private String genero;
    private List<String> atores = new ArrayList<>();

    public void addAtor(String ator) {
        atores.add(ator);
    }

    public Filme() {
    }

    public Filme(String titulo, int ano, String genero) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<String> getAtores() {
        return atores;
    } 

    @Override
    public String toString() {
        return "Filmes [titulo=" + titulo + ", ano=" + ano + ", genero=" + genero + "]";
    }

}
