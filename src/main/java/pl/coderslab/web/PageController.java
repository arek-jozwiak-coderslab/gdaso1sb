package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class PageController {
    @GetMapping("/page/list")
    public String page(Model model) {
        model.addAttribute("pagesList", "aaa");
        return "page/listview";
    }
 }
