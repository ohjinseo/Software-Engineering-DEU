package com.sw9.swe.advice;

import com.sw9.swe.controller.response.Response;
import com.sw9.swe.exception.*;
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
    public Response studentNotFoundException(StudentNotFoundException e) {
        return Response.failure(-1000, e.getMessage());
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

    @ExceptionHandler(CourseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response courseNotFoundException(CourseNotFoundException e) {
        return Response.failure(-1003, e.getMessage());
    }

    @ExceptionHandler(CartCourseAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Response cartCourseAlreadyExistsException(CartCourseAlreadyExistsException e) {
        return Response.failure(-1004, e.getMessage() + "은 이미 장바구니에 추가함");
    }

    @ExceptionHandler(CartCourseNotExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Response cartCourseNotExistsException(CartCourseNotExistsException e) {
        return Response.failure(-1005, e.getMessage() + "은 장바구니에 존재하지 않는 교과목입니다.");
    }
}
