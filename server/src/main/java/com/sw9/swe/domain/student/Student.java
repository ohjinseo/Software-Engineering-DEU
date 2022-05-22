package com.sw9.swe.domain.student;

import com.sw9.swe.domain.BaseTimeEntity;
import com.sw9.swe.domain.cart.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Student extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private Long registrationNumber;

    private String password;

    private String department;

    @OneToOne(fetch = FetchType.EAGER)
    private Cart cart;

    @Builder
    public Student(String username, Long registrationNumber, String password, String department, Cart cart) {
        this.username = username;
        this.registrationNumber = registrationNumber;
        this.password = password;
        this.department = department;
        this.cart = cart;
    }
}
