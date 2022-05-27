package com.sw9.swe.service.course;

import com.sw9.swe.dto.course.CourseCreateRequest;
import com.sw9.swe.dto.course.CourseDto;
import com.sw9.swe.exception.CourseNotFoundException;
import com.sw9.swe.repository.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Transactional
    public void create(CourseCreateRequest request) {
        courseRepository.save(CourseCreateRequest.toEntity(request));
    }

    public CourseDto read(Long courseId) {
        return CourseDto.toDto(courseRepository.findById(courseId).orElseThrow(CourseNotFoundException::new));
    }
}
