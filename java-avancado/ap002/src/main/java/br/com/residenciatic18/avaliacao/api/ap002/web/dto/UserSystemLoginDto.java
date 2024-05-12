package br.com.residenciatic18.avaliacao.api.ap002.web.dto;

import br.com.residenciatic18.avaliacao.api.ap002.validation.ValidPassword;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSystemLoginDto {

    @NotNull
    @Email(message = "Formato do e-mail está inválido")
    private String username;

    @ValidPassword
    private String password;

    @Column(name = "active", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean active;

    public UserSystemLoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
