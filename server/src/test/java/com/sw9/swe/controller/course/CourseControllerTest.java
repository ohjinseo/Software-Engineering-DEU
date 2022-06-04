package com.sw9.swe.controller.course;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sw9.swe.aop.WithMockCustomUser;
import com.sw9.swe.dto.course.CourseCreateRequest;
import com.sw9.swe.repository.student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.sw9.swe.factory.dto.CourseCreateRequestFactory.createCourseCreateRequest;
import static com.sw9.swe.factory.dto.CourseCreateRequestFactory.createCourseCreateRequestWithTimeInfo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
    @WithMockCustomUser
    void createCourseTest() throws Exception {

        // given
        CourseCreateRequest request = createCourseCreateRequest("test", "test", 1,
                "화학과", "교양", "균형교양", "상경대[test]", "익명", 50, "목[1-2]", 1, 2);

        mockMvc.perform(post("/api/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteTest() throws Exception {
        // given
        Long courseId = 2L;

        mockMvc.perform(delete("/api/course/{courseId}", courseId)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }


}