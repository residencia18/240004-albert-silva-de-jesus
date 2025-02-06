package br.com.residenciatic18.avaliacao.api.ap002.web.dto;

import br.com.residenciatic18.avaliacao.api.ap002.validation.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSystemCreateDto {

    @NotNull
    @Email(message = "Formato do e-mail está inválido", regexp = "^[a-zA-Z0-9._%+-]+_?@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String username;

    @ValidPassword(
        messageMinLength = "A senha deve conter pelo menos {minLength} caracteres",
        messageMaxLength = "A senha não deve conter mais de {maxLength} caracteres", 
        messageMissingUpperCase = "A senha deve conter pelo menos uma letra maiúscula", 
        messageMissingLowerCase = "A senha deve conter pelo menos uma letra minúscula", 
        messageMissingSpecialCharacter = "A senha deve conter pelo menos um caractere especial"
    )
    private String password;

}
