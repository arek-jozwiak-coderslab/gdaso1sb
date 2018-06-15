package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.service.StudentService;

import java.util.ArrayList;

@Controller
public class StudentController {
    private final StudentService service;


    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping("/students/list")
    public String list(Model model) {
        model.addAttribute("list", service.listAllStudents());
        return "student/studentList";
    }
}
