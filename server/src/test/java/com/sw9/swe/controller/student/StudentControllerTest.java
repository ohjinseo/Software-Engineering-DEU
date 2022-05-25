package com.sw9.swe.controller.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sw9.swe.aop.WithMockCustomUser;
import com.sw9.swe.domain.student.Student;
import com.sw9.swe.exception.StudentNotFoundException;
import com.sw9.swe.repository.student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.sw9.swe.factory.entity.StudentFactory.createStudent;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    StudentRepository studentRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @WithMockCustomUser
    @Test
    void studentReadTest() throws Exception {
        // given
        Long id = 111L;
        studentRepository.save(createStudent(id));

        // when, then
        mockMvc.perform(get("/api/students/{id}", id)
        ).andExpect(status().isOk());
    }

    @Test
    void studentReadExceptionTest() throws Exception{
        // given
        Long id = anyLong();

        // when, then
        mockMvc.perform(get("/api/students/{id}", id)
        ).andExpect(jsonPath("$.code").value(-1000));
    }

    @Test
    void studentReadAllTest() throws Exception {
        // given
        Long id1 = 11111111L;
        Long id2 = 22222222L;
        studentRepository.save(createStudent(id1));
        studentRepository.save(createStudent(id2));

        // when, then
        mockMvc.perform(get("/api/students"))
                .andExpect(status().isOk());
    }

    @Test
    void studentDeleteTest() throws Exception {
        // given
        Long id = 111L;
        studentRepository.save(createStudent(id));

        // when
        mockMvc.perform(delete("/api/students/{id}", id)
        ).andExpect(status().isOk());

        List<Student> students = studentRepository.findAll();
        assertThat(students.size()).isZero();
    }

    @Test
    void studentDeleteExceptionTest() throws Exception {
        // given
        Long id = 111L;

        // when
        mockMvc.perform(delete("/api/students/{id}", id))
                .andExpect(status().isNotFound());
    }
}