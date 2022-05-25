package com.sw9.swe.controller.sign;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sw9.swe.dto.sign.CreateStudentRequest;
import com.sw9.swe.dto.sign.SignInRequest;
import com.sw9.swe.exception.LoginFailureException;
import com.sw9.swe.exception.StudentRegistrationNumberAlreadyExistsException;
import com.sw9.swe.service.sign.SignService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.sw9.swe.factory.dto.CreateStudentRequestFactory.createStudentCreateRequest;
import static com.sw9.swe.factory.dto.SignInRequestFactory.createSignInRequest;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) // Controller, Service, JPA 통합 테스트
@AutoConfigureMockMvc
class SignControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    SignService signService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void signUpTest() throws Exception{
        // given
        CreateStudentRequest request = createStudentCreateRequest(11111111L, "1234");

        // when, then
        mockMvc.perform(post("/api/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }

    @Test
    void signInTest() throws Exception {
        // given
        Long id = 12345678L;
        String password = "12345678";
        signService.createStudent(createStudentCreateRequest(id, password));
        SignInRequest request = createSignInRequest(id, password);

        // when, then
        mockMvc.perform(post("/api/sign-in")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void signInExceptionAdviceTest() throws Exception {
        // given
        Long id = anyLong();
        String password = anyString();
        SignInRequest request = createSignInRequest(id, password);

        // when, then
        mockMvc.perform(post("/api/sign-in")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(jsonPath("$.code").value(-1002));
    }

}