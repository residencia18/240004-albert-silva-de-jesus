package br.com.residenciatic18.avaliacao.api.ap002.web.dto;

import br.com.residenciatic18.avaliacao.api.ap002.validation.ValidPassword;
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
public class UsuarioAlterarSenhaDto {

    @ValidPassword(
        messageMinLength = "A senha deve conter pelo menos {minLength} caracteres",
        messageMaxLength = "A senha não deve conter mais de {maxLength} caracteres", 
        messageMissingUpperCase = "A senha deve conter pelo menos uma letra maiúscula", 
        messageMissingLowerCase = "A senha deve conter pelo menos uma letra minúscula", 
        messageMissingSpecialCharacter = "A senha deve conter pelo menos um caractere especial"
    )
    private String novaSenha;

    @ValidPassword(
        messageMinLength = "A senha deve conter pelo menos {minLength} caracteres",
        messageMaxLength = "A senha não deve conter mais de {maxLength} caracteres", 
        messageMissingUpperCase = "A senha deve conter pelo menos uma letra maiúscula", 
        messageMissingLowerCase = "A senha deve conter pelo menos uma letra minúscula", 
        messageMissingSpecialCharacter = "A senha deve conter pelo menos um caractere especial"
    )
    private String confirmaSenha;

    private String codigoVerificador;
}
