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

import java.util.List;

import static com.sw9.swe.factory.entity.CartFactory.createCart;
import static com.sw9.swe.factory.entity.StudentFactory.createStudent;
import static org.assertj.core.api.Assertions.assertThat;

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
    void studentAndCartCascadeDeleteTest() throws Exception {
        // given
        Cart cart = createCart();
        cartRepository.save(cart);
        Student student = createStudent(cart);
        studentRepository.save(student);
        clear();

        // when
        studentRepository.deleteById(student.getId());
        clear();

        // then
        List<Cart> carts = cartRepository.findAll();
        assertThat(carts.size()).isZero();
    }


    private void clear() {
        entityManager.flush();
        entityManager.clear();
    }
}