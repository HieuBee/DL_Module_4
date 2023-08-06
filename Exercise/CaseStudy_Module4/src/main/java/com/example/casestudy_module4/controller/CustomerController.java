package com.example.casestudy_module4.controller;

import com.example.casestudy_module4.dto.CustomerDto;
import com.example.casestudy_module4.model.Customer;
import com.example.casestudy_module4.model.CustomerType;
import com.example.casestudy_module4.service.ICustomerService;
import com.example.casestudy_module4.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerTypeService typeService;

    @Autowired
    private ICustomerService service;

    @GetMapping("")
    public String getInformationCustomer(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "")String searchItem,
                                         ModelMap model){
        Pageable pageable = PageRequest.of(page,3);
        Page<Customer> customerPage = service.findAllPageable(pageable, searchItem);

        model.addAttribute("customerPage", customerPage);
        model.addAttribute("searchItem", searchItem);
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerDto", new CustomerDto());
        return "home";
    }
    @GetMapping("/create")
    public String getFormCreate(ModelMap model){
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerType", typeService.getInformation());
        return "create";
    }
    @PostMapping("/create")
    public String createCustomer(@ModelAttribute CustomerDto customerDto, RedirectAttributes redirectAttributes){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        service.add(customer);
        redirectAttributes.addFlashAttribute("mess", "Successful create!");
        redirectAttributes.addFlashAttribute("status", "success");
        return "redirect:/customer";
    }
    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        service.delete(customer);
        redirectAttributes.addFlashAttribute("mess", "Successful delete!");
        redirectAttributes.addFlashAttribute("status", "success");
        return "redirect:/customer";
    }
}
