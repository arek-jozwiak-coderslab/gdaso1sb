package pl.coderslab.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderslab.entity.Student;

import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void find_by_first_name_then_return_student(){
        //given
        Student john = new Student();
        john.setFirstName("John");
        entityManager.persist(john);
        //when
        Student result = studentRepository.findOneByFirstName("John");
        //then
        assertEquals(result.getFirstName(), john.getFirstName());
    }
    @Test
    public void add_one_to_database_then_fund_all_adn_result_equals_one(){
        //given
        Student s = Student.builder().firstName("arek").lastName("jozwiak").build();
        //then
        entityManager.persist(s);
        //then
        List<Student> students = studentRepository.findAll();

        //then
        assertEquals(1, students.size());

    }

    @Test
    public void given_jo_and_john_then_find_jo_should_return_two_elements() {
        // given
        Student jo = entityManager.persistAndFlush(Student.builder().firstName("jo").build());
        Student john = entityManager.persistAndFlush(Student.builder().firstName("john").build());
        // when
        List<Student> result = studentRepository.findBySome("jo");
        // then
        assertThat(result).containsExactly(jo, john);
        assertThat(result).contains(jo, john);
    }
    @Test
    public void given_jo_then_find_jo_should_return_one_element() {
        // given
        Student jo = entityManager.persistAndFlush(Student.builder().firstName("jo").build());
        Student jo2 = entityManager.persistAndFlush(Student.builder().firstName("jon").build());
        // when
        List<Student> result = studentRepository.findBySome("jo");
        // then
        assertEquals(1, result.size());
    }

    @Test
    public void given_jo_and_john_then_find_jo_should_return_two_elements_in_correct_order() {
        // given
        Student jo = entityManager.persistAndFlush(Student.builder().firstName("jo").build());
        Student john = entityManager.persistAndFlush(Student.builder().firstName("john").build());
        // when
        List<Student> result = studentRepository.findBySome("jo");
        // then
        assertThat(result).contains(john, jo);
    }

}