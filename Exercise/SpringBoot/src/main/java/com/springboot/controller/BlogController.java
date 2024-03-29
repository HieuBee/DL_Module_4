package com.springboot.controller;

import com.springboot.dto.BlogDto;
import com.springboot.model.Blog;
import com.springboot.service.IBlogService;
import com.springboot.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blogHome")
public class BlogController {

    @Autowired
    private IBlogService service;

    @Autowired
    private ICategoryService categoryService;

//    @GetMapping("")
//    public String showList(Model model){
//        model.addAttribute("blog", new Blog());
//        model.addAttribute("blogList", service.showList());
//        model.addAttribute("categories", categoryService.findAll());
//        return "home";
//    }

    /*@GetMapping("")
    public String showPage(@RequestParam(defaultValue = "0") int page ,
                           @RequestParam(defaultValue = "")String searchTitle,
                           ModelMap model) {
        Pageable pageable = PageRequest.of(page,5,Sort.by("title").ascending());
        Page<Blog> blogPages = service.findAll(pageable,searchTitle);
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blogPages", blogPages);
        model.addAttribute("searchTitle", searchTitle);
        return "home";
    }*/
    @GetMapping("")
    public String showPage(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "")String searchAuthor,
                           ModelMap model) {
        Pageable pageable = PageRequest.of(page,5);
        Page<Blog> blogPages = service.findAllPageable(pageable, searchAuthor);

        model.addAttribute("blogPages", blogPages);
        model.addAttribute("searchAuthor", searchAuthor);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "home";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int id, @RequestParam int idCategory, Model model){
        model.addAttribute("blog", service.findById(id));
        model.addAttribute("category", categoryService.findById(idCategory));
        return "detail";
    }

    @GetMapping("/category")
    public String blogOfCategory(@RequestParam String id, Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("blogOfCategory", service.blogOfCategory(id));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("category", categoryService.findById(Integer.parseInt(id)));
        return "blog_of_category";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        service.add(blog);
        redirectAttributes.addFlashAttribute("status", "success");
        redirectAttributes.addFlashAttribute("mess", "This is a success alert—check it out!");
        return "redirect:/blogHome";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Blog blog){
        service.delete(blog);
        return "redirect:/blogHome";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, @RequestParam int id){
        service.update(blog);
        return "redirect:/blogHome/detail?id=" + id;
    }
}
