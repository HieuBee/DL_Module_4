package com.exercise.cs2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {

    @GetMapping("/sandwich")
    public String showCheck(){
        return "sandwich";
    }

    @PostMapping("/save")
    public String save(@RequestParam String[] condiment, Model model) {
        model.addAttribute("listCondiment", condiment);
        return "sandwich";
    }
}
