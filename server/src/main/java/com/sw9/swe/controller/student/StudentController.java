package com.sw9.swe.controller.student;

import com.sw9.swe.controller.response.Response;
import com.sw9.swe.service.StudentService.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/api/students/{registrationNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Response read(@PathVariable Long registrationNumber) {
        return Response.success(studentService.read(registrationNumber));
    }

//    @GetMapping("/api/students")
//    @ResponseStatus(HttpStatus.OK)
//    public Response readAll() {
//        return Response.success(studentService.readAll());
//    }
    // pageable

    @DeleteMapping("/api/students/{registrationNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Response delete(@PathVariable Long registrationNumber) {
        studentService.delete(registrationNumber);
        return Response.success();
    }
}
