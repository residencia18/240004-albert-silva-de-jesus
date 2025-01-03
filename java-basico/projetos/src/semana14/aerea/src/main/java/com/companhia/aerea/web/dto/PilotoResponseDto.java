package com.companhia.aerea.web.dto;

import com.companhia.aerea.entities.AbstractEntity;
import com.companhia.aerea.entities.Piloto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PilotoResponseDto extends AbstractEntity {

    private String nome;
    private String numBreve;

    public PilotoResponseDto(Piloto piloto) {
        setId(piloto.getId());
        this.nome = piloto.getNome();
        this.numBreve = piloto.getNumBreve();
    }
}
