package com.sw9.swe.repository.student;

import com.sw9.swe.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByRegistrationNumber(Long registrationNumber);

    boolean existsByRegistrationNumber(Long registrationNumber);
}
