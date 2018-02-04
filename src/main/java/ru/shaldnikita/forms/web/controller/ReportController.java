package ru.shaldnikita.forms.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.shaldnikita.forms.app.HasLogger;
import ru.shaldnikita.forms.backend.models.UserAndHisForms;
import ru.shaldnikita.forms.backend.models.entity.UserAndHisState;
import ru.shaldnikita.forms.backend.repository.DataRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/")
public class ReportController implements HasLogger {

    @Autowired
    DataRepository dataRepository;

    @GetMapping("first")
    public ModelAndView firstReport() {
        Map<String, Object> model = new HashMap<>();
        model.put("reportNumber", 1);

        Collection<UserAndHisForms> usersAndTheirForms = attachFormsToUsers(dataRepository.getUsersAndForms());
        model.put("usersAndTheirForms", usersAndTheirForms);

        return new ModelAndView("first", model);
    }

    @GetMapping("second")
    public ModelAndView secondReport() {
        Map<String, Object> model = new HashMap<>();

        model.put("reportNumber", 2);
        model.put("usersAndState", attachStateToUser(dataRepository.getUsersWithUnfinishedForms()));

        getLogger().info("{}",model.get("usersAndState"));
        return new ModelAndView("second", model);
    }

    private Object attachStateToUser(List<Object[]> usersWithUnfinishedForms) {

        ConcurrentHashMap<String, UserAndHisState> result = new ConcurrentHashMap<>();

        usersWithUnfinishedForms
                .parallelStream()
                .forEach(userAndForm -> {
                    getLogger().info(Arrays.toString(userAndForm));
                    String user = (String) userAndForm[0];
                    String state = (String) userAndForm[1];

                    if (result.contains(user)) {
                        result.get(user).setState(state);
                    } else {
                        UserAndHisState newUser = new UserAndHisState();
                        newUser.setUserId(user);
                        newUser.setState(state);
                        result.put(user, newUser);
                    }
                });

        return result.values();
    }


    @GetMapping("third")
    public ModelAndView thirdReport() {
        Map<String, Object> model = new HashMap<>();
        model.put("reportNumber", 3);
        model.put("topForms", dataRepository.getTopFiveForms());

        return new ModelAndView("third", model);
    }

    private Collection<UserAndHisForms> attachFormsToUsers(List<Object[]> usersAndForms) {

        //List except of Set because we select distinct userId-formId
        ConcurrentHashMap<String, UserAndHisForms> result = new ConcurrentHashMap<>();
        getLogger().info(usersAndForms.get(0) + "");

        usersAndForms
                .parallelStream()
                .forEach(userAndForm -> {
                    getLogger().info(Arrays.toString(userAndForm));
                    String user = (String) userAndForm[0];
                    String form = (String) userAndForm[1];

                    if (result.contains(user)) {
                        result.get(user).getForms().add(form);
                    } else {
                        UserAndHisForms newUser = new UserAndHisForms();
                        newUser.setUserId(user);
                        newUser.getForms().add(form);
                        result.put(user, newUser);
                    }
                });

        return result.values();
    }
}
