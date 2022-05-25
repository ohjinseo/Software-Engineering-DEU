package com.sw9.swe.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException() {
        super("학생을 찾지 못하였습니다");
    }
}
