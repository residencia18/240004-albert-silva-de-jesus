package com.companhia.aerea.web.dto;

import com.companhia.aerea.entities.AbstractEntity;
import com.companhia.aerea.entities.ModeloAeronave;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ModeloAeronaveResponseDto extends AbstractEntity{

  private String nome;

  public ModeloAeronaveResponseDto(ModeloAeronave modeloAeronave) {
    setId(modeloAeronave.getId());
    this.nome = modeloAeronave.getNome();
  }
}
