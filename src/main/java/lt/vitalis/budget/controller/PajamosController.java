package lt.vitalis.budget.controller;

import lt.vitalis.budget.repository.model.Islaidos;
import lt.vitalis.budget.repository.model.Pajamos;
import lt.vitalis.budget.repository.model.SearchDates;
import lt.vitalis.budget.service.PajamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/pajamos")
// http://localhost:8080/pajamos

public class PajamosController {
    @Autowired
    private PajamosService pajamosService;

    // http://localhost:8080/pajamos/all
//    @GetMapping(path = "/all")
//    public @ResponseBody List<Pajamos> generateDummyPajamos() {
//        return pajamosService.getAll();
//    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getPajamos(Model model){
        model.addAttribute("key_pajamos_total", 0.0);
        model.addAttribute("key_dates", new SearchDates());
        model.addAttribute("key_pajamos_list", pajamosService.getAll());
        return "pajamos_list";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String getPajamos(
            Model model,
            @ModelAttribute(value = "key_dates") SearchDates searchDates
    ) {

        List<Pajamos> pajamuSarasas = pajamosService.getPajamosBetweenDates(
                searchDates.getStartDate(),
                searchDates.getEndDate()
        );

        double pajamosTotal = pajamosService.countPajamosMax(pajamuSarasas);
        model.addAttribute("key_pajamos_total", pajamosTotal);
        model.addAttribute("key_dates", searchDates);
        model.addAttribute(
                "key_pajamos_list",
                pajamuSarasas
        );
        return "pajamos_list";
    }

    @GetMapping(value = "/id/{id}")
    public String getPajamos(Model model, @PathVariable int id) {
        Pajamos pajamos = pajamosService.getPajamosById(id);
        model.addAttribute("key_pajamos", pajamos);
        return "pajamos_create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String savePajamos(Model model){
        model.addAttribute("key_pajamos", new Pajamos());
        return "pajamos_create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePajamos(Model model, @ModelAttribute(value = "key_pajamos") Pajamos pajamos) {
        pajamosService.save(pajamos);
        model.addAttribute("key_pajamos", pajamos);
        return "pajamos_create";
    }
}
