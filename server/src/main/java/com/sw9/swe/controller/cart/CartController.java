package com.sw9.swe.controller.cart;

import com.sw9.swe.aop.AssignStudentRegistrationNumber;
import com.sw9.swe.controller.response.Response;
import com.sw9.swe.dto.cart.CartAddCourseRequest;
import com.sw9.swe.dto.cart.CartDeleteCourseRequest;
import com.sw9.swe.dto.cart.CartReadRequest;
import com.sw9.swe.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class CartController {
    private final CartService cartService;

    @GetMapping("/api/cart")
    @ResponseStatus(HttpStatus.OK)
    @AssignStudentRegistrationNumber
    public Response read(@Valid @RequestBody CartReadRequest request) {
        System.out.println(request.getStudentId());

        return Response.success();
    }

    @PostMapping("/api/cart")
    @ResponseStatus(HttpStatus.CREATED)
    @AssignStudentRegistrationNumber
    public Response add(@RequestBody CartAddCourseRequest request) {
        cartService.add(request);
        return Response.success();
    }

    @DeleteMapping("/api/cart")
    @ResponseStatus(HttpStatus.OK)
    public Response delete(@RequestBody CartDeleteCourseRequest request) {
        cartService.delete(request);
        return Response.success();
    }
}
