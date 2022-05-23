package com.sw9.swe.factory.dto;

import com.sw9.swe.dto.sign.CreateStudentRequest;

public class CreateStudentRequestFactory {
    public static CreateStudentRequest createStudentCreateRequest() {
        return new CreateStudentRequest("name", 12345678L, "password", "department");
    }
}
