package com.sw9.swe.controller.course;

import com.sw9.swe.controller.response.Response;
import com.sw9.swe.dto.course.CourseCreateRequest;
import com.sw9.swe.dto.course.CourseReadCondition;
import com.sw9.swe.service.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/api/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Response create(@RequestBody CourseCreateRequest request) {
        courseService.create(request);
        return Response.success();
    }

    @DeleteMapping("/api/courses/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public Response delete(@PathVariable Long courseId) {
        courseService.delete(courseId);
        return Response.success();
    }

    @GetMapping("/api/courses")
    @ResponseStatus(HttpStatus.OK)
    public Response readAllByCondition(CourseReadCondition condition) {
        System.out.println(condition);
        return Response.success(courseService.readAllByCondition(condition));
    }
}
