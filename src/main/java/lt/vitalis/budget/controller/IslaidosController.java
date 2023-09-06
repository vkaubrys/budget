package lt.vitalis.budget.controller;

import lt.vitalis.budget.repository.model.Islaidos;
import lt.vitalis.budget.service.IslaidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/islaidos")
// http://localhost:8080/islaidos

public class IslaidosController {
    @Autowired
    private IslaidosService islaidosService;

    // http://localhost:8080/islaidos/all
    @GetMapping(path = "/all")
    public @ResponseBody List<Islaidos> generateDummyIslaidos(){
        return islaidosService.getAll();
    }

}
