package lt.vitalis.budget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // http://localhost:8080/home
    @GetMapping(path = "/home")
    public String displayHomePage(){
        return "home";

    }


}
