package com.sw9.swe.exception;

public class StudentRegistrationNumberAlreadyExistsException extends RuntimeException {
    public StudentRegistrationNumberAlreadyExistsException(Long registrationNumber) {
        super(String.valueOf(registrationNumber));
    }
}
