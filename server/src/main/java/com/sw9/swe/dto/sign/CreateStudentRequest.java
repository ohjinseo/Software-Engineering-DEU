package com.sw9.swe.dto.sign;

import com.sw9.swe.domain.cart.Cart;
import com.sw9.swe.domain.student.Student;
import lombok.Data;

@Data
public class CreateStudentRequest {
    private String username;

    private Long registrationNumber;

    private String password;

    private String department;

    public static Student toEntity(CreateStudentRequest request, Cart cart) {
        return Student.builder()
                .username(request.getUsername())
                .registrationNumber(request.getRegistrationNumber())
                .department(request.getDepartment())
                .password(request.password)
                .cart(cart).build();
    }
}
