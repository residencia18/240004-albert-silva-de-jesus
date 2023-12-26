package semana6.atvEmSala.P005.entities;

public class Motorista {

  private String nome;
  private String cnh;

  public Motorista() {
  }

  public Motorista(String nome, String cnh) {
    this.nome = nome;
    this.cnh = cnh;
  }

  public String getNome() {
    return nome;
  }

  public String getCnh() {
    return cnh;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCnh(String cnh) {
    this.cnh = cnh;
  }

  @Override
  public String toString() {
    return "Motoristas [cnh=" + cnh + ", nome=" + nome + "]";
  }
}
