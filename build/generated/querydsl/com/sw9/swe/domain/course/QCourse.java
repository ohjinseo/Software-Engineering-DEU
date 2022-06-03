package com.sw9.swe.domain.course;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCourse is a Querydsl query type for Course
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCourse extends EntityPathBase<Course> {

    private static final long serialVersionUID = 271448535L;

    public static final QCourse course = new QCourse("course");

    public final com.sw9.swe.domain.QBaseTimeEntity _super = new com.sw9.swe.domain.QBaseTimeEntity(this);

    public final StringPath college = createString("college");

    public final StringPath courseName = createString("courseName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath department = createString("department");

    public final NumberPath<Integer> distributionClass = createNumber("distributionClass", Integer.class);

    public final StringPath division = createString("division");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lectureInfo = createString("lectureInfo");

    public final NumberPath<Integer> limitGrade = createNumber("limitGrade", Integer.class);

    public final NumberPath<Integer> limitStudent = createNumber("limitStudent", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath professor = createString("professor");

    public final StringPath timeInfo = createString("timeInfo");

    public final StringPath type = createString("type");

    public QCourse(String variable) {
        super(Course.class, forVariable(variable));
    }

    public QCourse(Path<? extends Course> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCourse(PathMetadata metadata) {
        super(Course.class, metadata);
    }

}

