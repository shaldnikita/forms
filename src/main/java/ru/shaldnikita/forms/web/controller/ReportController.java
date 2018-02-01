package ru.shaldnikita.forms.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.shaldnikita.forms.backend.repository.DataRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ReportController {

    @Autowired
    DataRepository dataRepository;

    @GetMapping("first")
    public ModelAndView firstReport() {
        Map<String, Object> model = new HashMap<>();
        model.put("reportNumber", 1);

        LocalDateTime before = LocalDateTime.now().minusHours(1);
        LocalDateTime now = LocalDateTime.now();
        model.put("usersAndForms", dataRepository.getUsersAndForms(before, now));

        return new ModelAndView("first", model);
    }

    @GetMapping("second")
    public ModelAndView secondReport() {
        Map<String, Object> model = new HashMap<>();
        model.put("reportNumber", 2);
        model.put("usersAndState", dataRepository.findAll());

        return new ModelAndView("second", model);
    }

    @GetMapping("third")
    public ModelAndView thirdReport() {
        Map<String, Object> model = new HashMap<>();
        model.put("reportNumber", 3);
        model.put("topForms", dataRepository.getTopFiveForms());

        return new ModelAndView("third", model);
    }
}
