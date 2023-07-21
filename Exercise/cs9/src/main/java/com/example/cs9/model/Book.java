package com.example.cs9.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String img;
    private String name;
    private int quantity;
    @Value("0")
    private int quantityBorrow;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "book")
    private Set<UserBook> ubSet;

    public Book() {
    }

    public Book(int id, String img, String name, int quantity, int quantityBorrow, Category category, Set<UserBook> ubSet) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.quantity = quantity;
        this.quantityBorrow = quantityBorrow;
        this.category = category;
        this.ubSet = ubSet;
    }

    public int getQuantityBorrow() {
        return quantityBorrow;
    }

    public void setQuantityBorrow(int quantityBorrow) {
        this.quantityBorrow = quantityBorrow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<UserBook> getUbSet() {
        return ubSet;
    }

    public void setUbSet(Set<UserBook> ubSet) {
        this.ubSet = ubSet;
    }
}
