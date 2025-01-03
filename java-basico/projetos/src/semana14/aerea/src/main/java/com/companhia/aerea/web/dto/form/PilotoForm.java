package com.companhia.aerea.web.dto.form;

// import com.companhia.aerea.entities.Piloto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PilotoForm {

  private String nome;
  private String numBreve;
  private Integer registro;

  // public Piloto toUsuario() {
  //   Piloto piloto = new Piloto();
  //   piloto.setNome(nome);
  //   piloto.setNumBreve(numBreve);
  //   piloto.setRegistro(registro);
  //   return piloto;
  // }
}