package com.swprojects.ithaseverything.exception;

public class PasswordInvalidException extends RuntimeException {

    public PasswordInvalidException(String message) {
        super(message);
    }
}
