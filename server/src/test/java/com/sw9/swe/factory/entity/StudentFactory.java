package com.sw9.swe.factory.entity;

import com.sw9.swe.domain.cart.Cart;
import com.sw9.swe.domain.student.Student;

public class StudentFactory {
    public static Student createStudent() {
        return Student.builder().username("test")
                .department("ComputerScience")
                .password("1234")
                .registrationNumber(12345678L)
                .cart(null).build();
    }

    public static Student createStudent(Cart cart) {
        return Student.builder().username("test")
                .department("ComputerScience")
                .password("1234")
                .registrationNumber(12345678L)
                .cart(cart).build();
    }
}
