package com.example.cs9.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private Set<UserBook> ubSet;

    public User() {
    }

    public User(int id, String name, String phoneNumber, Set<UserBook> ubSet) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.ubSet = ubSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<UserBook> getUbSet() {
        return ubSet;
    }

    public void setUbSet(Set<UserBook> ubSet) {
        this.ubSet = ubSet;
    }
}
