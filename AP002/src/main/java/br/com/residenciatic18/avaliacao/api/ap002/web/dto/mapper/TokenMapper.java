package br.com.residenciatic18.avaliacao.api.ap002.web.dto.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import br.com.residenciatic18.avaliacao.api.ap002.entity.Token;
import br.com.residenciatic18.avaliacao.api.ap002.web.dto.TokenResponseDto;

public class TokenMapper {

    public static TokenResponseDto toDto(Token token) {
        PropertyMap<Token, TokenResponseDto> props = new PropertyMap<Token, TokenResponseDto>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setToken(source.getToken());
            }
        };
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);
        return mapper.map(token, TokenResponseDto.class);
    }

}
