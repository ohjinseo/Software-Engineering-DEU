package com.sw9.swe.exception;

public class CartCourseEmptyException extends RuntimeException {
    public CartCourseEmptyException() {
        super("장바구니가 비어있습니다.");
    }
}
