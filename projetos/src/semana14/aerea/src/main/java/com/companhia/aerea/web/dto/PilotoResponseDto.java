package com.companhia.aerea.web.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class PilotoResponseDto {

    private Long id;
    private String nome;
    private String numBreve;
}
