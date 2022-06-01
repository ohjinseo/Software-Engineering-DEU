package com.sw9.swe.repository.course;

import antlr.StringUtils;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sw9.swe.domain.course.Course;
import com.sw9.swe.domain.course.QCourse;
import com.sw9.swe.dto.course.CourseDto;
import com.sw9.swe.dto.course.CourseReadCondition;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;

import static com.querydsl.core.types.Projections.constructor;
import static com.sw9.swe.domain.course.QCourse.course;

@Transactional(readOnly = true)
public class CustomCourseRepositoryImpl extends QuerydslRepositorySupport implements CustomCourseRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public CustomCourseRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Course.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<CourseDto> findAllByCondition(CourseReadCondition condition) {
        return jpaQueryFactory
                .select(constructor(CourseDto.class, course.courseName,
                        course.college,
                        course.distributionClass,
                        course.department,
                        course.type,
                        course.division,
                        course.lectureInfo,
                        course.professor,
                        course.limitStudent,
                        course.timeInfo))
                .from(course)
                .where(eqType(condition.getType()), eqCourseName(condition.getCourseName())
                        , eqDivision(condition.getDivision()), eqCourseNumber(condition.getCourseNumber()),
                        eqProfessor(condition.getProfessor())).fetch();
    }

    private BooleanExpression eqType(String type) {
        if (type != null) {
            return course.type.eq(type);
        }
        return null;
    }

    private BooleanExpression eqDivision(String division) {
        if (division != null) {
            return course.division.eq(division);
        }
        return null;
    }

    private BooleanExpression eqCourseName(String courseName) {
        if (courseName != null) {
            return course.courseName.eq(courseName);
        }
        return null;
    }

    private BooleanExpression eqCourseNumber(Long courseNumber) {
        if (courseNumber != null) {
            return course.id.eq(courseNumber);
        }
        return null;
    }

    private BooleanExpression eqProfessor(String professor) {
        if (professor != null) {
            return course.professor.eq(professor);
        }
        return null;
    }
}
