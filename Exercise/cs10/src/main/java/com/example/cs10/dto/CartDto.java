package com.example.cs10.dto;

import com.example.cs10.model.Product;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            //update value + 1
            Integer currentValue = productMap.get(productDto);
            productMap.put(productDto, currentValue + 1);
            productMap.replace(productDto, currentValue + 1);
        } else {
            productMap.put(productDto, 1); //Lan dau dc them vao
        }
    }

    public void plus(ProductDto product){
        productMap.put(product,productMap.get(product) + 1);
    }

    public void minus(ProductDto product){
        if (productMap.get(product) >= 2){
            productMap.put(product,productMap.get(product) - 1);
        }else {
            productMap.put(product, 1);
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return productMap.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
