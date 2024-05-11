package br.com.residenciatic18.avaliacao.api.ap002.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({ ElementType.METHOD,
    ElementType.FIELD,
    ElementType.ANNOTATION_TYPE,
    ElementType.CONSTRUCTOR,
    ElementType.PARAMETER,
    ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

  String message() default "Invalid password";

  int maxLength() default 15;

  int minLength() default 8;

  String messageMinLength() default "A senha deve conter pelo menos {minLength} caracteres";

  String messageMaxLength() default "A senha não deve conter mais de {maxLength} caracteres";

  String messageMissingUpperCase() default "A senha deve conter pelo menos uma letra maiúscula";

  String messageMissingLowerCase() default "A senha deve conter pelo menos uma letra minúscula";

  String messageMissingSpecialCharacter() default "A senha deve conter pelo menos um caractere especial";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
