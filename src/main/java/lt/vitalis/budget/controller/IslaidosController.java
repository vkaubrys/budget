package lt.vitalis.budget.controller;

import lt.vitalis.budget.repository.model.Islaidos;
import lt.vitalis.budget.repository.model.SearchDates;
import lt.vitalis.budget.service.IslaidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(path = "/islaidos")
// http://localhost:8080/islaidos

public class IslaidosController {
    @Autowired
    private IslaidosService islaidosService;

    // http://localhost:8080/islaidos/all
//    @GetMapping(path = "/all")
//    public @ResponseBody List<Islaidos> generateDummyIslaidos() {
//        return islaidosService.getAll();
//    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getIslaidos(Model model) {
        model.addAttribute("key_islaidos_total", 0.0);
        model.addAttribute("key_dates", new SearchDates());
        model.addAttribute("key_islaidos_list", islaidosService.getAll());
        return "islaidos_list";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String getIslaidos(
            Model model,
            @ModelAttribute(value = "key_dates") SearchDates searchDates
    ) {

        List<Islaidos> islaiduSarasas = islaidosService.getIslaidosBetweenDates(
                searchDates.getStartDate(),
                searchDates.getEndDate()
        );
        double islaidosTotal = islaidosService.countIslaidosMax(islaiduSarasas);
        model.addAttribute("key_islaidos_total", islaidosTotal);
        model.addAttribute("key_dates", searchDates);
        model.addAttribute(
                "key_islaidos_list",
                islaiduSarasas
        );
        return "islaidos_list";
    }

    @GetMapping(value = "/id/{id}")
    public String getIslaidos(Model model, @PathVariable int id) {
        Islaidos islaidos = islaidosService.getIslaidosById(id);
        model.addAttribute("key_islaidos", islaidos);
        return "islaidos_create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveIslaidos(Model model) {
        model.addAttribute("key_islaidos", new Islaidos());
        return "islaidos_create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveIslaidos(Model model, @ModelAttribute(value = "key_islaidos") Islaidos islaidos) {
        islaidosService.save(islaidos);
        model.addAttribute("key_islaidos", islaidos);
        return "islaidos_create";
    }
}
