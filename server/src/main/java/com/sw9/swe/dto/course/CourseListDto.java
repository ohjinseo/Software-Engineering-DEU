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
    private Integer totalElements;
    private List<CourseDto> courseList;

    public static CourseListDto toDto(List<CourseDto> courseList) {
        return new CourseListDto(courseList.size(), courseList);
    }
}
