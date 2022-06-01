package com.sw9.swe.repository.course;

import com.sw9.swe.dto.course.CourseDto;
import com.sw9.swe.dto.course.CourseReadCondition;

import java.util.List;

public interface CustomCourseRepository {
    List<CourseDto> findAllByCondition(CourseReadCondition condition);
}
