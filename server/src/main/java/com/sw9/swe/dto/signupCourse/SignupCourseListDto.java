package com.sw9.swe.dto.signupCourse;

import com.sw9.swe.domain.signupCourse.SignupCourse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupCourseListDto {
    private List<SignupCourse> signupCourseList;
}
