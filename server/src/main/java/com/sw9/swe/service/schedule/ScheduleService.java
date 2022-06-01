package com.sw9.swe.service.schedule;

import com.sw9.swe.config.security.PrincipalDetails;
import com.sw9.swe.domain.schedule.Schedule;
import com.sw9.swe.domain.signupCourse.SignupCourse;
import com.sw9.swe.domain.student.Student;
import com.sw9.swe.exception.StudentNotFoundException;
import com.sw9.swe.repository.signupCourse.SignupCourseRepository;
import com.sw9.swe.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ScheduleService {
    private final StudentRepository studentRepository;
    private final SignupCourseRepository signupCourseRepository;

    public Schedule read(PrincipalDetails principalDetails) {
        Student student = studentRepository.findByRegistrationNumber(principalDetails.getRegistrationNumber()).orElseThrow(StudentNotFoundException::new);
        
        // 장바구니에 담은 강의, 수강 신청된 강의
        return new Schedule(student.getCart().getCourses(), SignupCourse.toCourseList(signupCourseRepository.findByStudent(student)));
    }
}
