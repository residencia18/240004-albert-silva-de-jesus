package semana6.atvEmSala.P005.entities;

public class Cobrador {

  private String nome;
  private String matricula;

  public Cobrador() {
  }

  public Cobrador(String nome, String matricula) {
    this.nome = nome;
    this.matricula = matricula;
  }

  public String getNome() {
    return this.nome;
  }

  public String getmatricula() {
    return this.matricula;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setmatricula(String matricula) {
    this.matricula = matricula;
  }

  @Override
  public String toString() {
    return ("\n\tNome: " + getNome() + "\n\tMatricula: " + getmatricula());
  }

}
