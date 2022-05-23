package com.sw9.swe.factory.dto;

import com.sw9.swe.dto.sign.SignInRequest;

public class SignInRequestFactory {
    public static SignInRequest createSignInRequest() {
        return new SignInRequest(12345678L, "12345678");
    }

    public static SignInRequest createSignInRequest(Long registrationNumber, String password) {
        return new SignInRequest(registrationNumber, password);
    }
}
