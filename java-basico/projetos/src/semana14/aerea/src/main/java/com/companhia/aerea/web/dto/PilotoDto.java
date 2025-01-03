package com.companhia.aerea.web.dto;

import com.companhia.aerea.entities.AbstractEntity;
import com.companhia.aerea.entities.Piloto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PilotoDto extends AbstractEntity {

    private String nome;
    private String numBreve;

    public PilotoDto(Piloto piloto) {
        setId(piloto.getId());
        this.nome = piloto.getNome();
        this.numBreve = piloto.getNumBreve();
    }

    public String getNome() {
        return nome;
    }

    public String getNumBreve() {
        return numBreve;
    }
}