package com.sw9.swe.controller.course;

import com.sw9.swe.controller.response.Response;
import com.sw9.swe.dto.course.CourseCreateRequest;
import com.sw9.swe.service.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/api/course")
    @ResponseStatus(HttpStatus.CREATED)
    public Response create(@RequestBody CourseCreateRequest request) {
        courseService.create(request);
        return Response.success();
    }



}
