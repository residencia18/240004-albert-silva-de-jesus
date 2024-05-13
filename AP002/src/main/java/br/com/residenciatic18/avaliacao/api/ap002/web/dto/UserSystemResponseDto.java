package br.com.residenciatic18.avaliacao.api.ap002.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSystemResponseDto {

    private Long id;
    private String username;
    private String role;
}
