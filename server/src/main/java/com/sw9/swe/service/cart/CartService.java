package com.sw9.swe.service.cart;

import com.sw9.swe.domain.course.Course;
import com.sw9.swe.dto.course.CourseListDto;
import com.sw9.swe.exception.StudentNotFoundException;
import com.sw9.swe.repository.cart.CartRepository;
import com.sw9.swe.repository.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CourseRepository courseRepository;

    public void add(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(StudentNotFoundException::new);

    }
}
