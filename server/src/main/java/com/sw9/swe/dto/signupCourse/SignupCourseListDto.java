package com.sw9.swe.dto.signupCourse;

import com.sw9.swe.domain.signupCourse.SignupCourse;
import com.sw9.swe.dto.course.CourseDto;
import com.sw9.swe.dto.course.CourseListDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupCourseListDto {
    private List<SignupCourse> signupCourseList;

    public static CourseListDto toCourseListDto(List<SignupCourse> signupCourseList) {
        List<CourseDto> courseDtoList = signupCourseList.stream()
                .map(sc -> CourseDto.toDto(sc.getCourse())).toList();

        return CourseListDto.toDto(courseDtoList);
    }
}
