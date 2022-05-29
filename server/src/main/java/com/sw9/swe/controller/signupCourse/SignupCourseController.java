package com.sw9.swe.controller.signupCourse;

import com.sw9.swe.aop.AssignStudentRegistrationNumber;
import com.sw9.swe.config.security.PrincipalDetails;
import com.sw9.swe.controller.response.Response;
import com.sw9.swe.dto.signupCourse.CreateSignupCourseRequest;
import com.sw9.swe.service.signupCourse.SignupCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class SignupCourseController {
    private final SignupCourseService signupCourseService;

    @PostMapping("/api/signupCourse")
    @ResponseStatus(HttpStatus.OK)
    @AssignStudentRegistrationNumber
    public Response createSignupCourse(@Valid @RequestBody CreateSignupCourseRequest request) {
        signupCourseService.createCourse(request);
        return Response.success();
    }

    @PostMapping("/api/signupCourse/all")
    @ResponseStatus(HttpStatus.OK)
    public Response createAllSignupCourse(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        signupCourseService.createAllCourse(principalDetails);
        return Response.success();
    }

    @DeleteMapping("/api/signupCourse/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public Response delete(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable Long courseId) {
        signupCourseService.delete(courseId, principalDetails);
        return Response.success();
    }

    @GetMapping("/api/signupCourse")
    @ResponseStatus(HttpStatus.OK)
    public Response read(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        return Response.success(signupCourseService.read(principalDetails));
    }
}
