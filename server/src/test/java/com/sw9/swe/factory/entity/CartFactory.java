package com.sw9.swe.factory.entity;

import com.sw9.swe.domain.cart.Cart;
import com.sw9.swe.domain.course.Course;
import com.sw9.swe.domain.student.Student;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CartFactory {
    public static Cart createCart() {
        return Cart.builder().courses(Collections.emptyList()).build();
    }

    public static Cart createCart(List<Course> courses) {
        return Cart.builder().courses(courses).build();
    }
}
