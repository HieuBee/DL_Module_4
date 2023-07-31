package com.example.cs10.controller;

import com.example.cs10.dto.CartDto;
import com.example.cs10.dto.ProductDto;
import com.example.cs10.model.Product;
import com.example.cs10.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto setupCart() {
        return new CartDto();
    }

    @GetMapping("")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable long id,@SessionAttribute(value = "cart")CartDto cart) {
        Product product = productService.findById(id);
        if (product!=null){
            ProductDto  productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}
