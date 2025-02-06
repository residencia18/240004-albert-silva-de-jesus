package br.com.residenciatic18.avaliacao.api.ap002.exception;

public class PasswordInvalidException extends RuntimeException {

    public PasswordInvalidException(String message) {
        super(message);
    }
}
