package com.sw9.swe.service.student;

import com.sw9.swe.config.security.PrincipalDetails;
import com.sw9.swe.domain.student.Student;
import com.sw9.swe.dto.student.StudentDto;
import com.sw9.swe.dto.student.StudentListDto;
import com.sw9.swe.exception.StudentNotFoundException;
import com.sw9.swe.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentDto readMe(PrincipalDetails principalDetails) {
        return StudentDto.toDto(studentRepository.findByRegistrationNumber(principalDetails.getRegistrationNumber())
                .orElseThrow(StudentNotFoundException::new));
    }

    public StudentDto read(Long registrationNumber) {
        return StudentDto.toDto(studentRepository.findByRegistrationNumber(registrationNumber)
                .orElseThrow(StudentNotFoundException::new));
    }

    public StudentListDto readAll() {
        List<Student> students = studentRepository.findAll();

        return StudentListDto.toListDto(students);
    }

    @Transactional
    public void delete(Long registrationNumber) {
        Student student = studentRepository.findByRegistrationNumber(registrationNumber)
                .orElseThrow(StudentNotFoundException::new);
        studentRepository.delete(student);
    }
}
