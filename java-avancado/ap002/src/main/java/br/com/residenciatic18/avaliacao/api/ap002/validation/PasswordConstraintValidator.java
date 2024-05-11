package br.com.residenciatic18.avaliacao.api.ap002.validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

  private List<String> commonPasswords = Arrays.asList("123456", "password", "12345678");

  private int maxLength;
  private int minLength;
  private String messageMinLength;
  private String messageMaxLength;
  private String messageMissingUpperCase;
  private String messageMissingLowerCase;
  private String messageMissingSpecialCharacter;

  @Override
  public void initialize(ValidPassword constraintAnnotation) {
    maxLength = constraintAnnotation.maxLength();
    minLength = constraintAnnotation.minLength();
    messageMinLength = constraintAnnotation.messageMinLength();
    messageMaxLength = constraintAnnotation.messageMaxLength();
    messageMissingUpperCase = constraintAnnotation.messageMissingUpperCase();
    messageMissingLowerCase = constraintAnnotation.messageMissingLowerCase();
    messageMissingSpecialCharacter = constraintAnnotation.messageMissingSpecialCharacter();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return false;
    }

    if (value.length() < minLength) {
      context.buildConstraintViolationWithTemplate(messageMinLength)
          .addConstraintViolation();
      return false;
    }

    if (value.length() > maxLength) {
      context.buildConstraintViolationWithTemplate(messageMaxLength)
          .addConstraintViolation();
      return false;
    }

    // Verifica se a senha contém pelo menos uma letra maiúscula
    if (!value.matches(".*[A-Z].*")) {
      context.buildConstraintViolationWithTemplate(messageMissingUpperCase)
          .addConstraintViolation();
      return false;
    }

    // Verifica se a senha contém pelo menos uma letra minúscula
    if (!value.matches(".*[a-z].*")) {
      context.buildConstraintViolationWithTemplate(messageMissingLowerCase)
          .addConstraintViolation();
      return false;
    }

    // Verifica se a senha contém pelo menos um caractere especial
    if (!value.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
      context.buildConstraintViolationWithTemplate(messageMissingSpecialCharacter)
          .addConstraintViolation();
      return false;
    }

    // Verifica se a senha contém pelo menos um dígito
    if (!value.matches(".*[0-9].*")) {
      context.buildConstraintViolationWithTemplate("A senha deve conter pelo menos um dígito")
          .addConstraintViolation();
      return false;
    }

    // Verifica se a senha está na lista de senhas comuns
    if (commonPasswords.contains(value)) {
      return false;
    }

    // Senha válida
    return true;

    // return value.length() >= minLength &&
    // value.length() <= maxLength &&
    // value.matches(".*[A-Z].*") &&
    // value.matches(".*[a-z].*") &&
    // value.matches(".*[0-9].*") &&
    // value.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*") &&
    // !commonPasswords.contains(value);
  }
}