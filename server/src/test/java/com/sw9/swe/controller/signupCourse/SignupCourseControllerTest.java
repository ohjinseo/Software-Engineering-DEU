package com.sw9.swe.controller.signupCourse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sw9.swe.aop.WithMockCustomUser;
import com.sw9.swe.dto.signupCourse.CreateSignupCourseRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class SignupCourseControllerTest {
    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @WithMockCustomUser
    void securityContextHolderTest() throws Exception {
        mockMvc.perform(
                post("/api/signupCourse/all")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    @WithMockCustomUser
    void createSignupCourseTest() throws Exception {
        // given
        Long courseId = 10L;

        // when, then
        mockMvc.perform(
                post("/api/signupCourse/{courseId}", courseId)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    @WithMockCustomUser
    void createAllSignupCourseTest() throws Exception {
        mockMvc.perform(
                post("/api/signupCourse/all")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }


    @WithMockCustomUser
    @Test
    void readSignupCourseTest() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/signupCourse")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }


}