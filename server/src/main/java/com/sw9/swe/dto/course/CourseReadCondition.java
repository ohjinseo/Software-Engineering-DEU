package com.sw9.swe.dto.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseReadCondition {
    private String type;
    private String division;
    private String courseName;
    private Long courseNumber;
    private String professor;
}
