package com.example.casestudy_module4.service;

import com.example.casestudy_module4.model.Customer;
import com.example.casestudy_module4.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerRepository repository;

    @Override
    public boolean add(Customer customer) {
        Customer customer1 = repository.save(customer);
        return customer1 != null;
    }

    @Override
    public List<Customer> showList() {
        return repository.findAll();
    }

    @Override
    public boolean update(Customer customer) {
        Customer customer1 = repository.save(customer);
        return customer1 != null;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void delete(Customer customer) {
        repository.delete(customer);
    }

    @Override
    public Page<Customer> findAllPageable(Pageable pageable, String item) {
        return repository.findAllPageable(pageable, "%" + item + "%");
    }
}
