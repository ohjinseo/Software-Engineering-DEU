package com.sw9.swe.dto.course;

import com.sw9.swe.domain.course.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private Long courseId;

    private String courseName;

    private String college;

    private Integer distributionClass;

    private String department;

    private String type;

    private String division;

    private String lectureInfo;

    private String professor;

    private Integer limitStudent;

    // 월[2-3], 화[1-2]
    private String timeInfo;

    private Integer limitGrade;


    public static CourseDto toDto(Course course) {
        return new CourseDto(
                course.getId(),
                course.getCourseName(),
                course.getCollege(),
                course.getDistributionClass(),
                course.getDepartment(),
                course.getType(),
                course.getDivision(),
                course.getLectureInfo(),
                course.getProfessor(),
                course.getLimitStudent(),
                course.getTimeInfo(),
                course.getLimitGrade());

    }
}
