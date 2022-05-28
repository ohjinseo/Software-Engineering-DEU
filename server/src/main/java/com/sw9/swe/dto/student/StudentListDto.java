package com.sw9.swe.dto.student;

import com.sw9.swe.domain.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentListDto {
    private List<StudentDto> studentList;

    public static StudentListDto toListDto(List<Student> students) {
        return new StudentListDto(
                students.stream().map(
                        StudentDto::toDto
                ).collect(Collectors.toList())
        );
    }
}
