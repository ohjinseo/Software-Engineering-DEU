package com.sw9.swe.advice;

import com.sw9.swe.controller.response.Response;
import com.sw9.swe.exception.LoginFailureException;
import com.sw9.swe.exception.StudentNotFoundException;
import com.sw9.swe.exception.StudentRegistrationNumberAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response studentNotFoundException() {
        return Response.failure(-1000, "학생을 찾지 못하였습니다.");
    }

    @ExceptionHandler(StudentRegistrationNumberAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Response studentRegistrationNumberAlreadyExistsException(StudentRegistrationNumberAlreadyExistsException e) {
        return Response.failure(-1001, e.getMessage() + "은 이미 존재하는 학번입니다.");
    }

    @ExceptionHandler(LoginFailureException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Response loginFailureException(LoginFailureException e) {
        return Response.failure(-1002, e.getMessage());
    }
}
