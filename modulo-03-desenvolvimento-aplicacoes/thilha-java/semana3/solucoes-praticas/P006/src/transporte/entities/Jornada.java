package transporte.entities;

import java.util.Date;

public class Jornada {
  
  private Trajeto trajeto;
  private Veiculo veiculo;
  private Motorista motorista;
  private Cobrador cobrador;
  private Date dataInicio;

  public Jornada(){
  }

  public Jornada(Date dataInicio) {
    this.dataInicio = dataInicio;
  }

  public Jornada(Trajeto trajeto, Veiculo veiculo, Motorista motorista, Cobrador cobrador) {
    this.trajeto = trajeto;
    this.veiculo = veiculo;
    this.motorista = motorista;
    this.cobrador = cobrador;
  }

  public Trajeto getTrajeto() {
    return trajeto;
  }

  public void setTrajeto(Trajeto trajeto) {
    this.trajeto = trajeto;
  }

  public Veiculo getVeiculo() {
    return veiculo;
  }

  public void setVeiculo(Veiculo veiculo) {
    this.veiculo = veiculo;
  }

  public Motorista getMotorista() {
    return motorista;
  }

  public void setMotorista(Motorista motorista) {
    this.motorista = motorista;
  }

  public Cobrador getCobrador() {
    return cobrador;
  }

  public void setCobrador(Cobrador cobrador) {
    this.cobrador = cobrador;
  }

  public Date getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(Date dataInicio) {
    this.dataInicio = dataInicio;
  }

  public void registrarInicioDoTrajeto(Date dataHoraInicio){
    this.dataInicio = dataHoraInicio;
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n\tInicio da jornada: ");
    sb.append("\n\t" + dataInicio);
    sb.append(trajeto);
    sb.append("\n\t============================");
    sb.append("\n\tVeiculo:");
    sb.append(veiculo);
    sb.append("\n\t============================");
    sb.append("\n\tMotorista:");
    sb.append(motorista);
    sb.append("\n\t============================");
    sb.append("\n\tCobrador:");
    sb.append(cobrador);
    return sb.toString();
  }
  
  
}
