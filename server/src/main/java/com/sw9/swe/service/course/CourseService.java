package com.sw9.swe.service.course;

import com.sw9.swe.domain.course.Course;
import com.sw9.swe.dto.course.CourseCreateRequest;
import com.sw9.swe.dto.course.CourseDto;
import com.sw9.swe.dto.course.CourseListDto;
import com.sw9.swe.dto.course.CourseReadCondition;
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

    @Transactional
    public void delete(Long courseId) {
        // security단에서 권한 검증 추가 예정
        Course course = courseRepository.findById(courseId).orElseThrow(CourseNotFoundException::new);
        courseRepository.delete(course);
    }

    public CourseDto read(Long courseId) {
        return CourseDto.toDto(courseRepository.findById(courseId).orElseThrow(CourseNotFoundException::new));
    }

    public CourseListDto readAllByCondition(CourseReadCondition condition) {
        return CourseListDto.toDto(
                courseRepository.findAllByCondition(condition)
        );
    }
}
