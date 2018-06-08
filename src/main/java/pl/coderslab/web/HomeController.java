package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Drink;
import pl.coderslab.repository.DrinkRepository;

@Controller
public class HomeController {


    private DrinkRepository drinkRepository;

    public HomeController(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }


    @GetMapping("/")
    public String hello(){
        Drink drink = Drink.builder().name("wodka2222").volume(123).color("red").build();
        drinkRepository.save(drink);
        return "hello";
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello2(){
        Drink drink = Drink.builder().name("wodka2222").volume(123).color("red").build();
        drinkRepository.save(drink);
        return "hello";
    }
}
