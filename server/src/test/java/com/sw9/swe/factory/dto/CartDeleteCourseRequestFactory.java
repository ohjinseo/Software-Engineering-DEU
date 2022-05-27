package com.sw9.swe.factory.dto;

import com.sw9.swe.dto.cart.CartDeleteCourseRequest;

public class CartDeleteCourseRequestFactory {
    public static CartDeleteCourseRequest createCartDeleteCourseRequest(Long courseId) {
        return new CartDeleteCourseRequest(courseId);
    }
}
