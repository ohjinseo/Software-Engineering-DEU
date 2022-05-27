package com.sw9.swe.controller.cart;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sw9.swe.aop.WithMockCustomUser;
import com.sw9.swe.domain.cart.Cart;
import com.sw9.swe.dto.cart.CartAddCourseRequest;
import com.sw9.swe.dto.cart.CartDeleteCourseRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.sw9.swe.factory.dto.CartAddCourseRequestFactory.createCartAddCourseRequest;
import static com.sw9.swe.factory.dto.CartDeleteCourseRequestFactory.createCartDeleteCourseRequest;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class CartControllerTest {
    @Autowired
    WebApplicationContext context;
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    void beforeEach() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();

    }

    @WithMockCustomUser
    @Test
    void addCourse() throws Exception{
        // given
        Long courseId = 2L;
        CartAddCourseRequest request = createCartAddCourseRequest(courseId);

        //when, then
        mockMvc.perform(
                post("/api/cart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpect(status().isCreated());
    }

    @WithMockCustomUser
    @Test
    void deleteCourse() throws Exception {
        // given
        Long courseId = 2L;
        CartDeleteCourseRequest request = createCartDeleteCourseRequest(courseId);

        // when, then
        mockMvc.perform(
                delete("/api/cart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpect(status().isOk());
    }
}