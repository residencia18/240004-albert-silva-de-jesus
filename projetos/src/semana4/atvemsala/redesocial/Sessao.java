package semana4.atvemsala.redesocial;

import java.time.LocalDateTime;

public class Sessao {

  private LocalDateTime dataHoraInicio;
  private LocalDateTime dataHoraFim;

  // public Sessao(){
  //   dataHoraInicio = LocalDateTime.now();
  // }

  public Sessao(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
    this.dataHoraInicio = LocalDateTime.now(); // Obtém a data e hora atuais;
    this.dataHoraFim = dataHoraFim;
  }

  public LocalDateTime getDataHoraInicio() {
    return dataHoraInicio;
  }

  public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
    this.dataHoraInicio = dataHoraInicio;
  }

  public LocalDateTime getDataHoraFim() {
    return dataHoraFim;
  }

  public void setDataHoraFim(LocalDateTime dataHoraFim) {
    this.dataHoraFim = dataHoraFim;
  }
}