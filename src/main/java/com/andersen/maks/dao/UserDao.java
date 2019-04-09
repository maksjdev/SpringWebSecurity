package com.andersen.maks.dao;

import com.andersen.maks.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
