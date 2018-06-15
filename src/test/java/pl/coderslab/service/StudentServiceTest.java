package pl.coderslab.service;

import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.coderslab.repository.StudentRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@Log
public class StudentServiceTest {

//    private static final Logger log = LoggerFactory.getLogger(StudentServiceTest.class);

    private StudentService service;
    private StudentRepository repository;
    @Before
    public void setUp() {
        repository = mock(StudentRepository.class);
        service = new StudentServiceImpl(repository);
    }

    @Test
    public void listAllStudents() throws Exception {
        log.info("jakies info");
    }

    @Test
    public void findByFirstName() throws Exception {
    }

    @Test
    public void addStudent() throws Exception {
    }

}