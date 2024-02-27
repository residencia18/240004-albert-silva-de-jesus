package com.companhia.aerea.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AeroportoResponseDto {

  private Long id;
  private String icao;

}