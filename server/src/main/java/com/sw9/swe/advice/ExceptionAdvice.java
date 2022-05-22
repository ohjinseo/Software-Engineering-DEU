package com.sw9.swe.advice;

import com.sw9.swe.controller.response.Response;
import com.sw9.swe.exception.StudentNotFoundException;
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
}
