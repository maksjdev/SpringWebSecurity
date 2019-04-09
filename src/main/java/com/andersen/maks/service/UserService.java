package com.andersen.maks.service;

import com.andersen.maks.model.User;


public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
