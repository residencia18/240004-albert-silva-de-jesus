package br.com.residenciatic18.avaliacao.api.ap002.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TokenResponseDto {
    
    private Long id;
    private String token;
    private UsuarioResponseDto usuario;
}
