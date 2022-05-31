package com.sw9.swe.repository.signupCourse;

import com.sw9.swe.domain.course.Course;
import com.sw9.swe.domain.signupCourse.SignupCourse;
import com.sw9.swe.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SignupCourseRepository extends JpaRepository<SignupCourse, Long> {
    List<SignupCourse> findByStudent(Student student);

    SignupCourse findByStudentAndCourse(Student student, Course course);
}
