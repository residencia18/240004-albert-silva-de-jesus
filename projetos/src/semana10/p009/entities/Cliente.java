package semana10.p009.entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends AbstractEntity {

  private String nome;
  private String cpf;
  private List<Imovel> imoveis;

  public Cliente() {
    this.imoveis = new ArrayList<>();
  }

  public Cliente(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
    this.imoveis = new ArrayList<>();
  }

  public Cliente(Integer id, String nome, String cpf) {
    super(id);
    this.nome = nome;
    this.cpf = cpf;
    this.imoveis = new ArrayList<>();
  }

  public void addImovel(Imovel imovel) {
    imoveis.add(imovel);
    imovel.setCliente(this); // Estabelece a relação bidirecional
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

  public List<Imovel> getImoveis() {
    return this.imoveis;
  }

  public void setImoveis(List<Imovel> imoveis) {
    this.imoveis = imoveis;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Cliente other = (Cliente) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (cpf == null) {
      if (other.cpf != null)
        return false;
    } else if (!cpf.equals(other.cpf))
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n\tNome: ").append(nome);
    sb.append("\n\tCPF : ").append(cpf);
    sb.append("\n\tImóveis:");

    for (Imovel imovel : imoveis) {
      sb.append("\n\tMatrícula: ").append(imovel.getMatricula());
      sb.append("\n\tEndereço : ").append(imovel.getEndereco());
    }

    return sb.toString();
  }

}