package com.sw9.swe.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
public class CartAddCourseRequest {

    @Nullable
    private Long studentId;

    private Long courseId;

    public CartAddCourseRequest(Long courseId) {
        this.courseId = courseId;
    }
}
