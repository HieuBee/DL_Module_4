package com.controller;

import com.model.Product;
import com.service.IProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping("")
    public String display(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("products", service.findAll());
        return "list";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product){
        service.delete(product.getId());
        return "redirect:/product";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product){
        service.update(product.getId(), product);
        return "redirect:/product";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Product product){
        service.create(product);
        return "redirect:/product";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute Product product, Model model){
        List<Product> products = service.searchByName(product.getName());
        model.addAttribute("products", products);
        return "list";
    }
}
