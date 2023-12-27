package semana6.atvEmSala.P005.entities;

public class Passageiro {
  
  private String nome;
  private String cpf;
  private String tipoCartao;
  private String pontoEmbarque;

  public Passageiro() {
  }

  public Passageiro(String nome, String cpf, String tipoCartao, String pontoEmbarque) {
    this.nome = nome;
    this.cpf = cpf;
    this.tipoCartao = tipoCartao;
    this.pontoEmbarque = pontoEmbarque;
  }

  public String getNome() {
    return this.nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public String getTipoCartao() {
    return this.tipoCartao;
  }

  public String getPontoEmbarque() {
    return this.pontoEmbarque;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setTipoCartao(String tipoCartao) {
    this.tipoCartao = tipoCartao;
  }

  public void setPontoEmbarque(String pontoEmbarque) {
    this.pontoEmbarque = pontoEmbarque;
  }

  @Override
  public String toString() {
    return "{" +
        " nome='" + getNome() + "'" +
        ", cpf='" + getCpf() + "'" +
        ", tipoCartao='" + getTipoCartao() + "'" +
        ", pontoEmbarque='" + getPontoEmbarque() + "'" +
        "}";
  }
}