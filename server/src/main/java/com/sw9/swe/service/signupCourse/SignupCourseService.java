package com.sw9.swe.service.signupCourse;

import com.sw9.swe.config.security.PrincipalDetails;
import com.sw9.swe.domain.course.Course;
import com.sw9.swe.domain.signupCourse.SignupCourse;
import com.sw9.swe.domain.student.Student;
import com.sw9.swe.dto.signupCourse.CreateSignupCourseRequest;
import com.sw9.swe.dto.signupCourse.SignupCourseListDto;
import com.sw9.swe.exception.CartCourseEmptyException;
import com.sw9.swe.exception.CartCourseNotExistsException;
import com.sw9.swe.exception.CourseNotFoundException;
import com.sw9.swe.exception.StudentNotFoundException;
import com.sw9.swe.repository.course.CourseRepository;
import com.sw9.swe.repository.signupCourse.SignupCourseRepository;
import com.sw9.swe.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SignupCourseService {
    private final SignupCourseRepository signupCourseRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public void createCourse(CreateSignupCourseRequest request) {
        Student student = studentRepository.findByRegistrationNumber(request.getStudentId()).orElseThrow(StudentNotFoundException::new);
        Course course = courseRepository.findById(request.getCourseId()).orElseThrow(CourseNotFoundException::new);

        if (!student.getCart().getCourses().contains(course)) {
            throw new CartCourseNotExistsException(course.getCourseName());
        }

        signupCourseRepository.save(CreateSignupCourseRequest.toEntity(student, course));
        student.getCart().deleteCourse(course);
    }

    @Transactional
    public void createAllCourse(PrincipalDetails principalDetails) {
        Student student = studentRepository.findByRegistrationNumber(principalDetails.getRegistrationNumber()).orElseThrow(StudentNotFoundException::new);

        if (student.getCart().getCourses().isEmpty()) {
            throw new CartCourseEmptyException();
        }

        List<Course> courses = student.getCart().getCourses();
        signupCourseRepository.saveAll(SignupCourse.toEntities(student, courses));
        student.getCart().deleteAllCourse();
    }

    @Transactional
    public void delete(Long courseId, PrincipalDetails principalDetails) {
        Student student = studentRepository.findByRegistrationNumber(principalDetails.getRegistrationNumber()).orElseThrow(StudentNotFoundException::new);
        Course course = courseRepository.findById(courseId).orElseThrow(CourseNotFoundException::new);

        if (!student.getCart().getCourses().contains(course)) {
            throw new CartCourseNotExistsException(course.getCourseName());
        }

        signupCourseRepository.delete(SignupCourse.builder()
                .student(student)
                .course(course)
                .build());
    }

    public SignupCourseListDto read(PrincipalDetails principalDetails) {
        Student student = studentRepository.findByRegistrationNumber(principalDetails.getRegistrationNumber()).orElseThrow(StudentNotFoundException::new);
        return new SignupCourseListDto(signupCourseRepository.findByStudent(student));
    }
}
