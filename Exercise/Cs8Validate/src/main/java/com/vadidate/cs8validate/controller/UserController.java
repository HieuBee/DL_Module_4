package com.vadidate.cs8validate.controller;

import com.vadidate.cs8validate.dto.UserDto;
import com.vadidate.cs8validate.model.User;
import com.vadidate.cs8validate.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/sign_up")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("")
    public String findAll(){
        return "list";
    }

    @GetMapping("/save")
    public String showForm(Model model){
        model.addAttribute("userDto", new UserDto());
        return "form_sign_up";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()){
            return "form_sign_up";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        service.create(user);
        redirectAttributes.addFlashAttribute("status", "success");
        redirectAttributes.addFlashAttribute("mess", "This is a success alert—check it out!");
        return "redirect:/sign_up";
    }

}
