package lt.vitalis.budget.controller;

import lt.vitalis.budget.repository.model.Pajamos;
import lt.vitalis.budget.service.PajamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping(path = "/pajamos")
// http://localhost:8080/pajamos

public class PajamosController {
    @Autowired
    private PajamosService pajamosService;

    // http://localhost:8080/pajamos/all
    @GetMapping(path = "/all")
    public @ResponseBody List<Pajamos> generateDummyPajamos(){
        return pajamosService.getAll();
    }
}
