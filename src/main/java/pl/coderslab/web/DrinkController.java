package pl.coderslab.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.repository.DrinkRepository;

@Controller
@RequestMapping("/drink")
public class DrinkController {

    private DrinkRepository drinkRepository;

    public DrinkController(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("drinks", drinkRepository.findAll());
        return "list";
    }
    @GetMapping("/form")
    public String form(Model model){
        return "form";
    }
}
