package com.sw9.swe.controller.course;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sw9.swe.dto.course.CourseCreateRequest;
import com.sw9.swe.repository.student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.sw9.swe.factory.dto.CourseCreateRequestFactory.createCourseCreateRequest;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CourseControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    StudentRepository studentRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void createTest() throws Exception {
        // given
        CourseCreateRequest request = createCourseCreateRequest();

        mockMvc.perform(post("/api/course")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteTest() throws Exception {
        // given

    }
}