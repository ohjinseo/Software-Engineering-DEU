package com.sw9.swe.domain.cart;

import com.sw9.swe.domain.BaseTimeEntity;
import com.sw9.swe.domain.course.Course;
import com.sw9.swe.domain.schedule.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Cart extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Course> courses;

    @Builder
    public Cart(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course, List<Course> signupCourses) {
        Schedule schedule = new Schedule(courses, signupCourses); // 시간표 생성
        schedule.isConflictSchedule(course);
        courses.add(course);
    }

    public void deleteCourse(Course course) {
        courses.remove(course);
    }

    public void deleteAllCourse() {
        courses.clear();
    }
}
