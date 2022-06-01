package com.sw9.swe.domain.course;

import com.sw9.swe.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Getter
@NoArgsConstructor
@Entity
public class Course extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private String college;

    private Integer distributionClass;

    private String department;

    private String type;

    private String division;

    private String lectureInfo;

    private String professor;

    private Integer limitStudent;

    private Integer limitGrade;

    // 월[2-3], 화[1-2]
    private String timeInfo;

    @Builder
    public Course(String courseName, String college, Integer distributionClass, String department,
                  String type, String division, String lectureInfo, String professor, Integer limitStudent, String timeInfo, Integer limitGrade) {
        this.courseName = courseName;
        this.college = college;
        this.distributionClass = distributionClass;
        this.department = department;
        this.type = type;
        this.division = division;
        this.lectureInfo = lectureInfo;
        this.professor = professor;
        this.limitStudent = limitStudent;
        this.timeInfo = timeInfo;
        this.limitGrade = limitGrade;
    }
}
