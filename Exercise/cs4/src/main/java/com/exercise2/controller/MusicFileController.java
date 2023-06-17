package com.exercise2.controller;

import com.exercise.model.EmailConfiguration;
import com.exercise.service.IEmailConfigurationService;
import com.exercise2.model.MusicFIle;
import com.exercise2.service.IMusicFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class MusicFileController {
    @ModelAttribute("categories")
    public String[] getCategories(){
        return new String[]{"K-POP", "V-POP"};
    }

    @Autowired
    private IMusicFileService service;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("list", service.display());
        return "home";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("musicFile", new MusicFIle());
        return "add";
    }

    /*.wav, .ogg, .m4p*/
    @PostMapping("/add")
    public String doUpdate(@ModelAttribute MusicFIle musicFIle, Model model) throws Exception {
        String[] words = musicFIle.getFile().split("\\.");
        for (String w : words) {
            if (w.equals("mp3") || w.equals("wav") || w.equals("ogg") || w.equals("m4p")){
                service.add(musicFIle);
                model.addAttribute("list", service.display());
            } else {
                String error = "The file format is not suitable so the song cannot be added!";
                model.addAttribute("error", error);
                model.addAttribute("list", service.display());
            }
        }
        return "home";
    }
}
