package com.sw9.swe.domain.cart;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCart is a Querydsl query type for Cart
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCart extends EntityPathBase<Cart> {

    private static final long serialVersionUID = -777983433L;

    public static final QCart cart = new QCart("cart");

    public final com.sw9.swe.domain.QBaseTimeEntity _super = new com.sw9.swe.domain.QBaseTimeEntity(this);

    public final ListPath<com.sw9.swe.domain.course.Course, com.sw9.swe.domain.course.QCourse> courses = this.<com.sw9.swe.domain.course.Course, com.sw9.swe.domain.course.QCourse>createList("courses", com.sw9.swe.domain.course.Course.class, com.sw9.swe.domain.course.QCourse.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public QCart(String variable) {
        super(Cart.class, forVariable(variable));
    }

    public QCart(Path<? extends Cart> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCart(PathMetadata metadata) {
        super(Cart.class, metadata);
    }

}

