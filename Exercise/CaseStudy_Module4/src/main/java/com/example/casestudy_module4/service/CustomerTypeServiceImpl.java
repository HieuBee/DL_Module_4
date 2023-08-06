package com.example.casestudy_module4.service;

import com.example.casestudy_module4.model.CustomerType;
import com.example.casestudy_module4.repository.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService{

    @Autowired
    private ICustomerTypeRepository repository;


    @Override
    public List<CustomerType> getInformation() {
        return repository.findAll();
    }
}
