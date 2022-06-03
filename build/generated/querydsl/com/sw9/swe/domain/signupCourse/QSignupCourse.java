package com.sw9.swe.domain.signupCourse;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSignupCourse is a Querydsl query type for SignupCourse
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSignupCourse extends EntityPathBase<SignupCourse> {

    private static final long serialVersionUID = -2064968425L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSignupCourse signupCourse = new QSignupCourse("signupCourse");

    public final com.sw9.swe.domain.QBaseTimeEntity _super = new com.sw9.swe.domain.QBaseTimeEntity(this);

    public final com.sw9.swe.domain.course.QCourse course;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final com.sw9.swe.domain.student.QStudent student;

    public QSignupCourse(String variable) {
        this(SignupCourse.class, forVariable(variable), INITS);
    }

    public QSignupCourse(Path<? extends SignupCourse> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSignupCourse(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSignupCourse(PathMetadata metadata, PathInits inits) {
        this(SignupCourse.class, metadata, inits);
    }

    public QSignupCourse(Class<? extends SignupCourse> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new com.sw9.swe.domain.course.QCourse(forProperty("course")) : null;
        this.student = inits.isInitialized("student") ? new com.sw9.swe.domain.student.QStudent(forProperty("student"), inits.get("student")) : null;
    }

}

