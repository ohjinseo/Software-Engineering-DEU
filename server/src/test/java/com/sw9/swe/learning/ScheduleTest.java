package com.sw9.swe.learning;

import com.sw9.swe.domain.cart.Cart;
import com.sw9.swe.domain.course.Course;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.sw9.swe.factory.entity.CartFactory.createCart;
import static com.sw9.swe.factory.entity.CourseFactory.createCourseWithTimeInfo;

public class ScheduleTest {
    @Test
    void scheduleMethodTest() {
        Course course1 = createCourseWithTimeInfo("월[1-3], 화[4-5]");
        Course course2 = createCourseWithTimeInfo("수[4-6], 목[2-4]");
        List<Course> courses = List.of(course1);
        Cart cart = createCart(courses);

        Course course3 = createCourseWithTimeInfo("화[1-3], 금[3-4], 목[1-2]");

        cart.addCourse(course3, List.of(course2));
    }
}
