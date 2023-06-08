package com.exercise.cs1.controller;

import com.exercise.cs1.service.ICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculator service;

    @GetMapping("/calculator")
    public String index() {
        return "calculator";
    }

    @PostMapping("/usd")
    public String submit(@RequestParam Double usd, Model model) {
        model.addAttribute("vnd", service.currency(usd));
        return "calculator";
    }
}
