package com.sw9.swe.exception;

public class CartCourseNotExistsException extends RuntimeException {
    public CartCourseNotExistsException() {
        super();
    }

    public CartCourseNotExistsException(String message) {
        super(message);
    }
}
