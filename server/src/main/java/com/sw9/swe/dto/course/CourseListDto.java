package com.sw9.swe.dto.course;

import com.sw9.swe.domain.course.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseListDto {
    private Long totalElements;
    private List<Course> courseList;
}
