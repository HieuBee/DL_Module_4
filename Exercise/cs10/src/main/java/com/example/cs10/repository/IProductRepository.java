package com.example.cs10.repository;

import com.example.cs10.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
