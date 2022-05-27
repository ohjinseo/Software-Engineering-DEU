package com.sw9.swe.dto.course;

import com.sw9.swe.domain.course.Course;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseCreateRequest {
    private String courseName;

    private String college;

    private Integer distributionClass;

    private String department;

    private String lectureInfo;

    private String professor;

    private Integer limitStudent;

    private String timeInfo;

    public static Course toEntity(CourseCreateRequest request) {
        return new Course(request.getCourseName(), request.getCollege(), request.getDistributionClass(), request.getDepartment(),
                request.getLectureInfo(), request.getProfessor(), request.getLimitStudent(), request.getTimeInfo());
    }
}
