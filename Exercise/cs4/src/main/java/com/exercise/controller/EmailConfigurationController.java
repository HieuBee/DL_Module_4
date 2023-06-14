package com.exercise.controller;

import com.exercise.model.EmailConfiguration;
import com.exercise.service.IEmailConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class EmailConfigurationController {

    @ModelAttribute("languages")
    public String[] getLanguages(){
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("pageSize")
    public int[] getPageSize(){
        return new int[]{ 5, 10, 15, 25, 50, 100};
    }

    @Autowired
    private IEmailConfigurationService service;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("list", service.display());
        return "showList";
    }

    @GetMapping("/update")
    public String showUpdate(Model model, @RequestParam int id){
        EmailConfiguration emailConfiguration = service.findById(id);
        model.addAttribute("emailConfiguration", emailConfiguration);
        return "update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute EmailConfiguration emailConfiguration, Model model) throws Exception {
        service.update(emailConfiguration);
        model.addAttribute("list", service.display());
        return "showList";
    }
}
