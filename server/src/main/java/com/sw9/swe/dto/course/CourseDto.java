package com.sw9.swe.dto.course;

import com.sw9.swe.domain.course.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private String courseName;

    private String college;

    private Integer distributionClass;

    private String department;

    private String lectureInfo;

    private String professor;

    private Integer limitStudent;

    private String timeInfo;


    public static CourseDto toDto(Course course) {
        return new CourseDto(course.getCourseName(),
                course.getCollege(),
                course.getDistributionClass(),
                course.getDepartment(),
                course.getLectureInfo(),
                course.getProfessor(),
                course.getLimitStudent(),
                course.getTimeInfo());
    }
}
