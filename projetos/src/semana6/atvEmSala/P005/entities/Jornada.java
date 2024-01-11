package semana6.atvEmSala.P005.entities;

public class Jornada {
  
  private Trajeto trajeto;
  private Veiculo veiculo;
  private Motorista motorista;
  private Cobrador cobrador;

  public Jornada(){
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

  @Override
  public String toString() {
    return ("\n\tTrajeto: " + trajeto + "\n\tVeiculo: " + veiculo + "\n\tMotorista: " + motorista + "\n\tCobrador: " + cobrador);
  }
  
  
}
