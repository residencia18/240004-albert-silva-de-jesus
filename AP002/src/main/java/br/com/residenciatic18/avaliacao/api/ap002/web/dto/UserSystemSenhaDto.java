package br.com.residenciatic18.avaliacao.api.ap002.web.dto;

import br.com.residenciatic18.avaliacao.api.ap002.validation.ValidPassword;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSystemSenhaDto {

    @NotNull
    @ValidPassword(
        messageMinLength = "A senha deve conter pelo menos {minLength} caracteres",
        messageMaxLength = "A senha não deve conter mais de {maxLength} caracteres", 
        messageMissingUpperCase = "A senha deve conter pelo menos uma letra maiúscula", 
        messageMissingLowerCase = "A senha deve conter pelo menos uma letra minúscula", 
        messageMissingSpecialCharacter = "A senha deve conter pelo menos um caractere especial"
    )
    private String currentpassword;

    @ValidPassword(
        messageMinLength = "A senha deve conter pelo menos {minLength} caracteres",
        messageMaxLength = "A senha não deve conter mais de {maxLength} caracteres", 
        messageMissingUpperCase = "A senha deve conter pelo menos uma letra maiúscula", 
        messageMissingLowerCase = "A senha deve conter pelo menos uma letra minúscula", 
        messageMissingSpecialCharacter = "A senha deve conter pelo menos um caractere especial"
    )
    private String newPassword;

    @ValidPassword(
        messageMinLength = "A senha deve conter pelo menos {minLength} caracteres",
        messageMaxLength = "A senha não deve conter mais de {maxLength} caracteres", 
        messageMissingUpperCase = "A senha deve conter pelo menos uma letra maiúscula", 
        messageMissingLowerCase = "A senha deve conter pelo menos uma letra minúscula", 
        messageMissingSpecialCharacter = "A senha deve conter pelo menos um caractere especial"
    )
    private String confirmPassword;

}
