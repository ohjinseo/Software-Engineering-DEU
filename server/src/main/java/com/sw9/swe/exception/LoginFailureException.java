package com.sw9.swe.exception;

public class LoginFailureException extends RuntimeException{
    public LoginFailureException(String message) {
        super(message);
    }
}
