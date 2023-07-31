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

import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ModelAndView showCart(@SessionAttribute(value = "cart", required = false) CartDto cart){
        return new ModelAndView("cart", "cart", cart);
    }

    @GetMapping("/addQuantity/{id}")
    public String addToCart(@PathVariable long id, @SessionAttribute(value = "cart") CartDto cartDto) {
        Product product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        cartDto.plus(productDto);
        return "redirect:/cart";
    }

    @GetMapping("/deleteQuantity/{id}")
    public String deleteToCart(@PathVariable long id, @SessionAttribute(value = "cart") CartDto cartDto) {
        Product product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        cartDto.minus(productDto);
        return "redirect:/cart";
    }
}
