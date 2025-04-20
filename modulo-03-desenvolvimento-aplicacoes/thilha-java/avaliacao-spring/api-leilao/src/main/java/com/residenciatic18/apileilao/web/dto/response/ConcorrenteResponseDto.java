package com.residenciatic18.apileilao.web.dto.response;

import com.residenciatic18.apileilao.entities.Concorrente;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConcorrenteResponseDto {

  // private Long id;
  private String nome;

  public ConcorrenteResponseDto(Concorrente concorrente) {
    // setId(concorrente.getId());
    this.nome = concorrente.getNome();
  }
}
