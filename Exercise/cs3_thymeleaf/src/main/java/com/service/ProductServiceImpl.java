package com.service;

import com.model.Product;
import com.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean create(Product product) {
        return repository.create(product);
    }

    @Override
    public void update(int id, Product product) {
        repository.update(id, product);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public boolean showDetail(int id) {
        return repository.showDetail(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return repository.searchByName(name);
    }
}
