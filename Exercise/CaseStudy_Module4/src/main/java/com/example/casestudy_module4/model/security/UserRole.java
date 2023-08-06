package com.example.casestudy_module4.model.security;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_role_id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "role_id")
    private Role role;

    public UserRole() {
    }

    public UserRole(int user_role_id, User user, Role role) {
        this.user_role_id = user_role_id;
        this.user = user;
        this.role = role;
    }

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}