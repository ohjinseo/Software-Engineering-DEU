package com.sw9.swe.exception;

public class CartCourseAlreadyExistsException extends RuntimeException{
    public CartCourseAlreadyExistsException(String courseName) {
        super(courseName);
    }
}
