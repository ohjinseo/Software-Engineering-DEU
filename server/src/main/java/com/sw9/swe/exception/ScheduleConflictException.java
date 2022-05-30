package com.sw9.swe.exception;

public class ScheduleConflictException extends RuntimeException {
    public ScheduleConflictException(String message) {
        super(message);
    }
}
