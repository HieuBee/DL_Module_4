package com.example.cs10.service;

import com.example.cs10.dto.ProductDto;
import com.example.cs10.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Product findById(long id);

    void save(Product product);
}
