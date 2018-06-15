package pl.coderslab.service;

import pl.coderslab.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> listAllStudents();

    Student findByFirstName(String firstName);

    Student addStudent(Student student);

}
