package com.sw9.swe.domain.signupCourse;

import com.sw9.swe.domain.BaseTimeEntity;
import com.sw9.swe.domain.course.Course;
import com.sw9.swe.domain.student.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class SignupCourse extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Student student;

    @OneToOne(fetch=FetchType.LAZY)
    private Course course;

    private String grade;

    @Builder
    public SignupCourse(Student student, Course course, String grade) {
        this.student = student;
        this.course = course;
        this.grade = grade;
    }
}
