package com.andersen.maks.service;



public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
