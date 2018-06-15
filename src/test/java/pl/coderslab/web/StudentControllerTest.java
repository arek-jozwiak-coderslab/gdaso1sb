package pl.coderslab.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.entity.Student;
import pl.coderslab.service.StudentService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = StudentController.class)
public class StudentControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private StudentService studentService;

    @Before
    public void setUp() {

        mockMvc = webAppContextSetup(webApplicationContext).build();

        List<Student> students = Arrays.asList(new Student("Jan"),
                new Student("Janek"), new Student("Janusz"));

        when(this.studentService.listAllStudents()).thenReturn(students);
    }

    private final String STUDENT_LIST_ACTION_VIEW = "student/studentList";

    @Test
    public void test_listAction_contains_model_list() throws Exception {
        assertThat(this.studentService).isNotNull();

        mockMvc.perform(get("/students/list"))
                .andExpect(model().attributeExists("list"))
                .andExpect(model().attribute("list", hasSize(3)))
                .andExpect(model().attribute("list",
                        hasItem(anyOf(hasProperty("firstName"), is("Jan")))))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(content().string(containsString("Janek")))
                .andExpect(view().name(STUDENT_LIST_ACTION_VIEW))
                .andDo(print());
    }
}