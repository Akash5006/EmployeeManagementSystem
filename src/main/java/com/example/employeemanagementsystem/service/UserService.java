package com.example.employeemanagementsystem.service;
import com.example.employeemanagementsystem.model.User;
public interface UserService {
    void saveUser(User user);
    User getUserByUsername(String username);
}
