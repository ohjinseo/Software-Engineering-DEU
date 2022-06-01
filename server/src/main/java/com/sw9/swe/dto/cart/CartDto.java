package com.sw9.swe.dto.cart;

import com.sw9.swe.domain.cart.Cart;
import com.sw9.swe.domain.course.Course;
import com.sw9.swe.domain.schedule.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDto {
    private List<Course> courses;

    public static CartDto toDto(Cart cart) {
        return new CartDto(
                cart.getCourses()
        );
    }
}
