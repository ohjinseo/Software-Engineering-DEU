package com.sw9.swe.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("학생을 찾지 못하였습니다");
    }
}
