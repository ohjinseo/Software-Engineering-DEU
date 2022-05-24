package com.sw9.swe.service.StudentService;

import com.sw9.swe.domain.student.Student;
import com.sw9.swe.dto.member.StudentDto;
import com.sw9.swe.exception.StudentNotFoundException;
import com.sw9.swe.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentDto read(Long registrationNumber) {
        return StudentDto.toDto(studentRepository.findByRegistrationNumber(registrationNumber)
                .orElseThrow(StudentNotFoundException::new));
    }

    @Transactional
    public void delete(Long registrationNumber) {
        Student student = studentRepository.findByRegistrationNumber(registrationNumber)
                .orElseThrow(StudentNotFoundException::new);
        studentRepository.delete(student);
    }
}
