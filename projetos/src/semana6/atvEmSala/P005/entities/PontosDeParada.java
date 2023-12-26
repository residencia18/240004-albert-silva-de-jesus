package semana6.atvEmSala.P005.entities;

public class PontosDeParada {

  private String nome;
  private String endereco;

  public PontosDeParada() {
  }

  public PontosDeParada(String nome, String endereco) {
    this.nome = nome;
    this.endereco = endereco;
  }

  public String getNome() {
    return this.nome;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  @Override
  public String toString() {
    return "{" +
        " nome='" + getNome() + "'" +
        ", endereco='" + getEndereco() + "'" +
        "}";
  }

}
