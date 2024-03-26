package com.swproject.vendagrocer.exception;

public class PasswordInvalidException extends RuntimeException {

    public PasswordInvalidException(String message) {
        super(message);
    }
}
