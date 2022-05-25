package com.sw9.swe.factory.dto;

import com.sw9.swe.dto.cart.CartAddCourseRequest;

public class CartAddCourseRequestFactory {
    public static CartAddCourseRequest createCartAddCourseRequest(Long courseId) {
        return new CartAddCourseRequest(courseId);
    }
}
