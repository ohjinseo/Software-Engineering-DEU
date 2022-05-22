package com.sw9.swe.repository.student;

import com.sw9.swe.domain.cart.Cart;
import com.sw9.swe.domain.student.Student;
import com.sw9.swe.exception.StudentNotFoundException;
import com.sw9.swe.repository.cart.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.sw9.swe.factory.entity.StudentFactory.createStudent;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// fix : @DataJpaTest는 내장 DB 사용하는 반면 Mysql연결 시도하여 난 오류 
    // -> 설정을 통해 내장 DB를 사용하지 않게 바꿈
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CartRepository cartRepository;
    @PersistenceContext
    EntityManager entityManager;

    @Test
    void studentDateTest() {
        // given
        Student student = createStudent();

        // when
        studentRepository.save(student);
        clear();

        // then
        Student foundStudent = studentRepository.findById(student.getId()).orElseThrow(StudentNotFoundException::new);
        assertThat(foundStudent.getCreatedAt()).isNotNull();
        assertThat(foundStudent.getModifiedAt()).isNotNull();
        assertThat(foundStudent.getCreatedAt()).isEqualTo(foundStudent.getModifiedAt());
    }

    @Test
    void studentAndCartCascadeTest() {
        // given
        Student student = createStudent();

        // when
        studentRepository.save(student);

    }


    private void clear() {
        entityManager.flush();
        entityManager.clear();
    }
}