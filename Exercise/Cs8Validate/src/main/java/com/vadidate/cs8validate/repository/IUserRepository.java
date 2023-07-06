package com.vadidate.cs8validate.repository;

import com.vadidate.cs8validate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
