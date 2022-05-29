package com.sw9.swe.domain.signupCourse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sw9.swe.domain.BaseTimeEntity;
import com.sw9.swe.domain.course.Course;
import com.sw9.swe.domain.student.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Entity
public class SignupCourse extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private Student student;

    @OneToOne(fetch=FetchType.LAZY)
    private Course course;


    @Builder
    public SignupCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    // 장바구니 모두 신청일 때 saveAll() 메소드 인자로 들어가기 위해 엔티티 집합으로 변환해주는 메소드
    public static List<SignupCourse> toEntities(Student student, List<Course> courses) {
        return courses.stream().map(c -> SignupCourse.builder()
                .student(student)
                .course(c)
                .build()).toList();
    }
}
