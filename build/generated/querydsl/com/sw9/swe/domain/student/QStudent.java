package com.sw9.swe.domain.student;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = 75265937L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudent student = new QStudent("student");

    public final com.sw9.swe.domain.QBaseTimeEntity _super = new com.sw9.swe.domain.QBaseTimeEntity(this);

    public final com.sw9.swe.domain.cart.QCart cart;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath department = createString("department");

    public final NumberPath<Integer> grade = createNumber("grade", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath password = createString("password");

    public final NumberPath<Long> registrationNumber = createNumber("registrationNumber", Long.class);

    public final StringPath username = createString("username");

    public QStudent(String variable) {
        this(Student.class, forVariable(variable), INITS);
    }

    public QStudent(Path<? extends Student> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudent(PathMetadata metadata, PathInits inits) {
        this(Student.class, metadata, inits);
    }

    public QStudent(Class<? extends Student> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cart = inits.isInitialized("cart") ? new com.sw9.swe.domain.cart.QCart(forProperty("cart")) : null;
    }

}

