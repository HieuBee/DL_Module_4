package com.example.casestudy_module4.service;

import com.example.casestudy_module4.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    boolean add(Customer customer);
    List<Customer> showList();
    boolean update(Customer customer);
    Customer findById(int id);
    void delete(Customer customer);
    Page<Customer> findAllPageable(Pageable pageable, String item);
}
