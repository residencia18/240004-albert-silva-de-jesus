package com.companhia.aerea.web.dto.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.companhia.aerea.entities.Piloto;
import com.companhia.aerea.web.dto.PilotoResponseDto;
import com.companhia.aerea.web.dto.form.PilotoForm;

import java.util.List;
import java.util.stream.Collectors;

public class PilotoMapper {

    public static Piloto toPiloto(PilotoForm createDto) {
        return new ModelMapper().map(createDto, Piloto.class);
    }

    public static PilotoResponseDto toDto(Piloto piloto) {
        PropertyMap<Piloto, PilotoResponseDto> props = new PropertyMap<Piloto, PilotoResponseDto>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setNome(source.getNome());
                map().setNumBreve(source.getNumBreve());
            }
        };
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);
        return mapper.map(piloto, PilotoResponseDto.class);
    }

    public static List<PilotoResponseDto> toListDto(List<Piloto> pilotos) {
        return pilotos.stream().map(user -> toDto(user)).collect(Collectors.toList());
    }

}