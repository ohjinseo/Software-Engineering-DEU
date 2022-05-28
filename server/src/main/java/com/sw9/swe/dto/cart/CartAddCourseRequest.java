package com.sw9.swe.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartAddCourseRequest {

    @Nullable
    private Long studentId;

    private Long courseId;

    public CartAddCourseRequest(Long courseId) {
        this.courseId = courseId;
    }
}
