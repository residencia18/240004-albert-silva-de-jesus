package com.companhia.aerea.web.dto;

import com.companhia.aerea.entities.AbstractEntity;
import com.companhia.aerea.entities.Aeroporto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AeroportoResponseDto extends AbstractEntity {

  private String icao;

  public AeroportoResponseDto(Aeroporto aeroporto) {
    setId(aeroporto.getId());
    this.icao = aeroporto.getIcao();
   
  }

}