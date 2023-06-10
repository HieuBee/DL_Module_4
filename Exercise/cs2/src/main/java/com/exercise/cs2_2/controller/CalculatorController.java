package com.exercise.cs2_2.controller;

import com.exercise.cs2_2.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService service;
    @GetMapping("/calculator")
    public String showCheck(){
        return "calculator";
    }

    @PostMapping("/result")
    public String save(@RequestParam float firstNumber,@RequestParam float secondNumber,@RequestParam char operator, Model model) {
//        System.out.println(fistNumber);
        float result = service.calculator(firstNumber, secondNumber, operator);
        model.addAttribute("result", result);
        return "calculator";
    }
}
