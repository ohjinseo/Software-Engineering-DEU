package com.sw9.swe.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Null;

@Data
@AllArgsConstructor
public class CartReadRequest {
    @Null
    private Long studentId;
}
