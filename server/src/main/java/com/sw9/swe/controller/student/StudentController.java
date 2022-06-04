package com.sw9.swe.controller.student;

import com.sw9.swe.config.security.PrincipalDetails;
import com.sw9.swe.controller.response.Response;
import com.sw9.swe.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class StudentController {
    private final StudentService studentService;


    @GetMapping("/api/student")
    @ResponseStatus(HttpStatus.OK)
    public Response readMe(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        return Response.success(studentService.readMe(principalDetails));
    }

    @GetMapping("/api/students/{registrationNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Response read(@PathVariable Long registrationNumber) {

        return Response.success(studentService.read(registrationNumber));
    }

    @GetMapping("/api/students")
    @ResponseStatus(HttpStatus.OK)
    public Response readAll(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        return Response.success(studentService.readAll());
    }

    @DeleteMapping("/api/students/{registrationNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Response delete(@PathVariable Long registrationNumber) {
        studentService.delete(registrationNumber);
        return Response.success();
    }
}
