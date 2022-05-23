package com.sw9.swe.domain.cart;

import com.sw9.swe.domain.BaseTimeEntity;
import com.sw9.swe.domain.course.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Cart extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Course> courses;

    @Builder
    public Cart(List<Course> courses) {
        this.courses = courses;
    }
}
