package com.sw9.swe.factory.dto;

import com.sw9.swe.dto.course.CourseCreateRequest;

public class CourseCreateRequestFactory {
    public static CourseCreateRequest createCourseCreateRequest() {
        return new CourseCreateRequest("courseName", "college", 1,
                "department", "type", "division", "lectureInfo", "professor", 30, "timeInfo", 1, 3);
    }

    public static CourseCreateRequest createCourseCreateRequestWithTimeInfo(String timeInfo) {
        return new CourseCreateRequest("courseName", "college", 1,
                "department", "type", "division", "lectureInfo", "professor", 30, timeInfo, 1, 3);
    }

    public static CourseCreateRequest createCourseCreateRequest(String courseName, String college, Integer distributionClass, String department,
                                                                            String type, String division, String lectureInfo, String professor, Integer limitStudent, String timeInfo, Integer limitGrade, Integer grade) {
        return new CourseCreateRequest(courseName, college, distributionClass, department, type, division, lectureInfo, professor, limitStudent, timeInfo, limitGrade, grade);
    }
}
