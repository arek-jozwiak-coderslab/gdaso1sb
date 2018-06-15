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
import pl.coderslab.service.StudentService;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test
        .web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)

@WebMvcTest(controllers = PageController.class)
public class PageControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    private final String LIST_ACTION_VIEW = "page/listview";
    @Test
    public void test_page_action() throws Exception {
        mockMvc.perform(get("/page/list"))
                .andExpect(model().attributeExists("pagesList"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(content().string(containsString("Insert title")))
                .andExpect(view().name(LIST_ACTION_VIEW));
    }

}