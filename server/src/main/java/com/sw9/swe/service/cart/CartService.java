package com.sw9.swe.service.cart;

import com.sw9.swe.domain.course.Course;
import com.sw9.swe.dto.cart.CartAddCourseRequest;
import com.sw9.swe.dto.course.CourseListDto;
import com.sw9.swe.exception.StudentNotFoundException;
import com.sw9.swe.repository.cart.CartRepository;
import com.sw9.swe.repository.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CourseRepository courseRepository;

    public void add(CartAddCourseRequest request) {
        log.info(request.getStudentId().toString());
        Course course = courseRepository.findById(request.getCourseId()).orElseThrow(StudentNotFoundException::new);

    }
}
