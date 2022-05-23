package com.sw9.swe.service.sign;

import com.sw9.swe.domain.cart.Cart;
import com.sw9.swe.dto.sign.CreateStudentRequest;
import com.sw9.swe.exception.StudentRegistrationNumberAlreadyExistsException;
import com.sw9.swe.repository.cart.CartRepository;
import com.sw9.swe.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class SignService {
    private final StudentRepository studentRepository;
    private final CartRepository cartRepository;

    @Transactional
    public void createStudent(CreateStudentRequest request) {
        validateCreateStudent(request);
        Cart cart = Cart.builder().courses(Collections.emptyList()).build();
        cartRepository.save(cart);
        studentRepository.save(CreateStudentRequest.toEntity(request, cart));
    }

    private void validateCreateStudent(CreateStudentRequest request) {
        if (studentRepository.existsByRegistrationNumber(request.getRegistrationNumber())) {
            throw new StudentRegistrationNumberAlreadyExistsException(request.getRegistrationNumber());
        }
    }
}
