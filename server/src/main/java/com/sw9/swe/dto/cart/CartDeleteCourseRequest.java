package com.sw9.swe.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDeleteCourseRequest {
    @Nullable
    private Long studentId;

    private Long courseId;

    public CartDeleteCourseRequest(Long courseId) {
        this.courseId = courseId;
    }
}
