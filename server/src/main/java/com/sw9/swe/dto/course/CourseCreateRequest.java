package com.sw9.swe.dto.course;

import com.sw9.swe.domain.course.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseCreateRequest {
    private String courseName;

    private String college; // 단대

    private Integer distributionClass; // 분반

    private String department; // 학과

    private String type; // 과목 유형 (전공, 교양)

    private String division; // 이수 구분 (공통교양, 자율교양)

    private String lectureInfo;

    private String professor;

    private Integer limitStudent;

    private String timeInfo;

    private Integer limitGrade;

    public static Course toEntity(CourseCreateRequest request) {
        return new Course(request.getCourseName(), request.getCollege(), request.getDistributionClass(), request.getDepartment(),
                request.getType(), request.getDivision(), request.getLectureInfo(), request.getProfessor(), request.getLimitStudent(), request.getTimeInfo(), request.getLimitGrade());
    }
}
