package com.sw9.swe.controller.cart;

import com.sw9.swe.config.security.PrincipalDetails;
import com.sw9.swe.controller.response.Response;

import com.sw9.swe.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CartController {
    private final CartService cartService;

    @GetMapping("/api/cart")
    @ResponseStatus(HttpStatus.OK)
    public Response read(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        return Response.success(cartService.read(principalDetails));
    }

    @PostMapping("/api/cart/{courseId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable Long courseId) {
        cartService.add(principalDetails, courseId);
        return Response.success();
    }

    @DeleteMapping("/api/cart/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public Response delete(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable Long courseId) {
        cartService.delete(principalDetails, courseId);
        return Response.success();
    }

    @DeleteMapping("/api/cart/all")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteAll(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        cartService.deleteAll(principalDetails);
        return Response.success();
    }
}
