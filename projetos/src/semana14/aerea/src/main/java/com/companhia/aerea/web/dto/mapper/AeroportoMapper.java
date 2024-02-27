package com.companhia.aerea.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.companhia.aerea.entities.Aeroporto;
import com.companhia.aerea.web.dto.AeroportoResponseDto;
import com.companhia.aerea.web.dto.form.AeroportoForm;

public class AeroportoMapper {

  public static Aeroporto toPiloto(AeroportoForm createDto) {
    return new ModelMapper().map(createDto, Aeroporto.class);
  }

  public static AeroportoResponseDto toDto(Aeroporto aeroporto) {
    PropertyMap<Aeroporto, AeroportoResponseDto> props = new PropertyMap<Aeroporto, AeroportoResponseDto>() {
      @Override
      protected void configure() {
        map().setId(source.getId());
        map().setIcao(source.getIcao());
      }
    };
    ModelMapper mapper = new ModelMapper();
    mapper.addMappings(props);
    return mapper.map(aeroporto, AeroportoResponseDto.class);
  }

  public static List<AeroportoResponseDto> toListDto(List<Aeroporto> aeroportos) {
    return aeroportos.stream().map(user -> toDto(user)).collect(Collectors.toList());
  }

}
