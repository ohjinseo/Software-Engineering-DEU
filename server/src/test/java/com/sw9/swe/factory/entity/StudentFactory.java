package com.sw9.swe.factory.entity;

import com.sw9.swe.domain.cart.Cart;
import com.sw9.swe.domain.student.Student;

import static com.sw9.swe.factory.entity.CartFactory.createCart;

public class StudentFactory {
    public static Student createStudent() {
        return Student.builder().username("test")
                .department("ComputerScience")
                .password("1234")
                .registrationNumber(12345678L)
                .cart(createCart()).build();
    }

    public static Student createStudent(Cart cart) {
        return Student.builder().username("test")
                .department("ComputerScience")
                .password("1234")
                .registrationNumber(12345678L)
                .cart(cart).build();
    }

    public static Student createStudent(Long id) {
        return Student.builder().username("test")
                .department("ComputerScience")
                .password("1234")
                .registrationNumber(id)
                .cart(createCart()).build();
    }
}
