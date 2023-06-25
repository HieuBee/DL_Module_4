package com.picture.controller;

import com.picture.model.Feedback;
import com.picture.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private IPictureService pictureService;

    private PictureController(IPictureService pictureService) {
        this.pictureService = pictureService;
    }

    @ModelAttribute("feedbacks")
    public List<Feedback> getFeedbackList() {
        return pictureService.showList();
    }

    @GetMapping("")
    public String display(Model model) {
        Feedback feedback = new Feedback();
        model.addAttribute("feedback", feedback);
        return "list";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Feedback feedback, Model model) {
        if (!pictureService.add(feedback)) {
            String errorMsg = "Adding new failed!";
            model.addAttribute("error", errorMsg);
            return "list";
        }
        return "redirect:/picture";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Feedback feedback) {
        int id = feedback.getId();
        pictureService.update(id);
        return "redirect:/picture";
    }
}
