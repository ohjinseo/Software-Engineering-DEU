package com.sw9.swe.controller.sign;

import com.sw9.swe.controller.response.Response;
import com.sw9.swe.dto.sign.CreateStudentRequest;
import com.sw9.swe.dto.sign.SignInRequest;
import com.sw9.swe.service.sign.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.sw9.swe.controller.response.Response.success;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class SignController {
    private final SignService signService;

    @PostMapping("/api/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public Response createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        signService.createStudent(createStudentRequest);
        return success();
    }

    @GetMapping("/api/test")
    public Response test() {
        return success();
    }

    @PostMapping("/api/sign-in")
    @ResponseStatus(HttpStatus.OK)
    public Response signIn(@RequestBody SignInRequest signInRequest) {
        signService.signIn(signInRequest);
        return success();
    }
}
