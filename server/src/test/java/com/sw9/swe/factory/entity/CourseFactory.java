package com.sw9.swe.factory.entity;

import com.sw9.swe.domain.cart.Cart;
import com.sw9.swe.domain.course.Course;

import java.util.Collections;

public class CourseFactory {
    public static Course createCourse() {
        return Course.builder().courseName("test")
                .department("Computer Science")
                .college("college")
                .courseName("course")
                .lectureInfo("lecture")
                .distributionClass(1)
                .professor("professor")
                .timeInfo("timeInfo")
                .limitStudent(30).build();
    }
}
