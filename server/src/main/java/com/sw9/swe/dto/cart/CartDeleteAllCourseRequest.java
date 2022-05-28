package com.sw9.swe.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDeleteAllCourseRequest {
    @Nullable
    private Long studentId;
}
