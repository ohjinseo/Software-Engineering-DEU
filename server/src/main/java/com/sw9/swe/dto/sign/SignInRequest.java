package com.sw9.swe.dto.sign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 테스트코드에서 objectMapper로 JSON 변환할 때 필요
@AllArgsConstructor
public class SignInRequest {
    private Long registrationNumber;
    private String password;
}
