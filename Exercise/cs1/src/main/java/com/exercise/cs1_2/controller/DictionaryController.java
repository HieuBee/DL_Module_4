package com.exercise.cs1_2.controller;

import com.exercise.cs1.service.ICalculator;
import com.exercise.cs1_2.service.IDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionary service;

    @GetMapping("/dictionary")
    public String index() {
        return "dictionary";
    }

    @PostMapping("/US")
    public String submit(@RequestParam String US, Model model) {
        model.addAttribute("VN", service.checkText(US));
        return "dictionary";
    }
}
