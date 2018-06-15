package pl.coderslab.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Drink;
import pl.coderslab.repository.DrinkRepository;

import javax.validation.Valid;

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
        return "drink/list";
    }
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("drink", new Drink());
        return "drink/form";
    }

    @PostMapping("/add")
    public String perform(@ModelAttribute @Valid Drink drink, BindingResult result) {
        if (result.hasErrors()) {
            return "drink/form";
        }
        drinkRepository.save(drink);
        return "redirect:/drink/list";
    }

    @GetMapping("/update/{id}")
    public String showForm(Model model, @PathVariable long id) {
        Drink b = drinkRepository.findOne(id);
        model.addAttribute("drink", b);
        return "drink/form";
    }


    @PostMapping("/update")
    public String performUpdate(@ModelAttribute Drink drink) {
        drinkRepository.save(drink);
        return "redirect:/drink/list";
    }
}
