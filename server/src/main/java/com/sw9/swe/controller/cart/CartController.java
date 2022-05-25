package com.sw9.swe.controller.cart;

import com.sw9.swe.controller.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CartController {

    @GetMapping("/api/cart/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Response read(Long studentId) {

        return Response.success();
    }

    @PostMapping("/api/cart/{courseId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(Long courseId) {

        return Response.success();
    }
}
