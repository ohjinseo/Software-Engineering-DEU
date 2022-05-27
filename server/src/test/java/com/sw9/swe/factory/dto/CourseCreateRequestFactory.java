package com.sw9.swe.factory.dto;

import com.sw9.swe.dto.course.CourseCreateRequest;

public class CourseCreateRequestFactory {
    public static CourseCreateRequest createCourseCreateRequest() {
        return new CourseCreateRequest("courseName", "college", 1,
                "department", "lectureInfo", "professor", 30, "timeInfo");
    }
}
