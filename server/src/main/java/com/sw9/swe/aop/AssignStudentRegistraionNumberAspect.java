package com.sw9.swe.aop;

import com.sw9.swe.config.guard.AuthHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class AssignStudentRegistraionNumberAspect {
    private final AuthHelper authHelper;

    @Before("@annotation(com.sw9.swe.aop.AssignStudentRegistrationNumber)")
    public void assignStudentRegistrationNumber(JoinPoint joinPoint) {
        Arrays.stream(joinPoint.getArgs())
                .forEach(arg->getMethod(arg.getClass(), "setStudentId")
                        .ifPresent(setStudentId->invokeMethod(arg, setStudentId, authHelper.extractStudentRegistrationNumber())));
    }

    private Optional<Method> getMethod(Class<?> clazz, String methodName) {
        try {
            return Optional.of(clazz.getMethod(methodName, Long.class));
        } catch (NoSuchMethodException e) {
            return Optional.empty();
        }
    }

    private void invokeMethod(Object obj, Method method, Object... args) {
        try {
            method.invoke(obj, args);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException();
        }
    }
}
