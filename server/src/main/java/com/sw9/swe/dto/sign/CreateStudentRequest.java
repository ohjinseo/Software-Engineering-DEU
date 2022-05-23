package com.sw9.swe.dto.sign;

import com.sw9.swe.domain.cart.Cart;
import com.sw9.swe.domain.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@AllArgsConstructor
public class CreateStudentRequest {
    private String username;

    private Long registrationNumber;

    private String password;

    private String department;

    public static Student toEntity(CreateStudentRequest request, Cart cart, PasswordEncoder passwordEncoder) {
        return Student.builder()
                .username(request.getUsername())
                .registrationNumber(request.getRegistrationNumber())
                .department(request.getDepartment())
                .password(passwordEncoder.encode(request.password))
                .cart(cart).build();
    }
}
