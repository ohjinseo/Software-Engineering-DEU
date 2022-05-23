package com.sw9.swe.service.sign;

import com.sw9.swe.domain.cart.Cart;
import com.sw9.swe.domain.student.Student;
import com.sw9.swe.dto.sign.CreateStudentRequest;
import com.sw9.swe.dto.sign.SignInRequest;
import com.sw9.swe.exception.LoginFailureException;
import com.sw9.swe.exception.StudentRegistrationNumberAlreadyExistsException;
import com.sw9.swe.repository.cart.CartRepository;
import com.sw9.swe.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class SignService {
    private final StudentRepository studentRepository;
    private final CartRepository cartRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void createStudent(CreateStudentRequest request) {
        validateCreateStudent(request);
        Cart cart = Cart.builder().courses(Collections.emptyList()).build();
        cartRepository.save(cart);
        studentRepository.save(CreateStudentRequest.toEntity(request, cart, passwordEncoder));
    }

    @Transactional(readOnly = true)
    public void signIn(SignInRequest request) {
        Student student = studentRepository.findByRegistrationNumber(request.getRegistrationNumber()).orElseThrow(()->new LoginFailureException("존재하지 않는 ID입니다."));
        validatePassword(request, student);
    }

    private void validatePassword(SignInRequest request, Student student) {
        if (!passwordEncoder.matches(request.getPassword(), student.getPassword())) {
            throw new LoginFailureException("비밀번호가 맞지 않습니다.");
        }
    }

    private void validateCreateStudent(CreateStudentRequest request) {
        if (studentRepository.existsByRegistrationNumber(request.getRegistrationNumber())) {
            throw new StudentRegistrationNumberAlreadyExistsException(request.getRegistrationNumber());
        }
    }
}
