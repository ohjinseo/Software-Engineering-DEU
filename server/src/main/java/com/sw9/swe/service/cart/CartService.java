package com.sw9.swe.service.cart;

import com.sw9.swe.domain.cart.Cart;
import com.sw9.swe.domain.course.Course;
import com.sw9.swe.domain.student.Student;
import com.sw9.swe.dto.cart.*;
import com.sw9.swe.dto.course.CourseListDto;
import com.sw9.swe.exception.CartCourseAlreadyExistsException;
import com.sw9.swe.exception.CartCourseNotExistsException;
import com.sw9.swe.exception.StudentNotFoundException;
import com.sw9.swe.repository.cart.CartRepository;
import com.sw9.swe.repository.course.CourseRepository;
import com.sw9.swe.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
@Service
public class CartService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CartDto read(CartReadRequest request) {
        Student student = studentRepository.findByRegistrationNumber(request.getStudentId()).orElseThrow(StudentNotFoundException::new);
        return CartDto.toDto(student.getCart());
    }

    @Transactional
    public void add(CartAddCourseRequest request) {
        Course course = courseRepository.findById(request.getCourseId()).orElseThrow(StudentNotFoundException::new);
        Student student = studentRepository.findByRegistrationNumber(request.getStudentId()).orElseThrow(StudentNotFoundException::new);

        if(student.getCart().getCourses().contains(course)){
            throw new CartCourseAlreadyExistsException(course.getCourseName());
        }
        student.getCart().addCourse(course);
    }

    @Transactional
    public void delete(CartDeleteCourseRequest request) {
        Course course = courseRepository.findById(request.getCourseId()).orElseThrow(StudentNotFoundException::new);
        Student student = studentRepository.findByRegistrationNumber(request.getStudentId()).orElseThrow(StudentNotFoundException::new);

        if (!student.getCart().getCourses().contains(course)) {
            throw new CartCourseNotExistsException(course.getCourseName());
        }

        student.getCart().deleteCourse(course);
    }

    @Transactional
    public void deleteAll(CartDeleteAllCourseRequest request) {
        Student student = studentRepository.findByRegistrationNumber(request.getStudentId()).orElseThrow(StudentNotFoundException::new);

        if (student.getCart().getCourses().isEmpty()) {
            throw new CartCourseNotExistsException();
        }

        student.getCart().deleteAllCourse();
    }
}
