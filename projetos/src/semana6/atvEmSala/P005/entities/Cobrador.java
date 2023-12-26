package semana6.atvEmSala.P005.entities;

public class Cobrador {

  private String nome;
  private String cpf;

  public Cobrador() {
  }

  public Cobrador(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
  }

  public String getNome() {
    return this.nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  @Override
  public String toString() {
    return "{" +
        " nome='" + getNome() + "'" +
        ", cpf='" + getCpf() + "'" +
        "}";
  }

}
