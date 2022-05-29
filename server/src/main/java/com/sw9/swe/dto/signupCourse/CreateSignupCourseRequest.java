package com.sw9.swe.dto.signupCourse;

import com.sw9.swe.domain.course.Course;
import com.sw9.swe.domain.signupCourse.SignupCourse;
import com.sw9.swe.domain.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSignupCourseRequest {
    @Null
    private Long studentId;

    private Long courseId;

    public CreateSignupCourseRequest(Long courseId) {
        this.courseId = courseId;
    }

    public static SignupCourse toEntity(Student student, Course course) {
        return SignupCourse.builder().student(student).course(course).build();
    }
}
