package com.sw9.swe.dto.student;

import com.sw9.swe.domain.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;

    private String username;

    private Long registrationNumber;

    private String department;

    public static StudentDto toDto(Student student) {
        return new StudentDto(student.getId(), student.getUsername(), student.getRegistrationNumber(), student.getDepartment());
    }
}
