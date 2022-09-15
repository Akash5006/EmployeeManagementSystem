package com.example.employeemanagementsystem.service;
import com.example.employeemanagementsystem.dto.UserDto;
import com.example.employeemanagementsystem.exception.EmsException;
import com.example.employeemanagementsystem.exception.EmsException401;
import com.example.employeemanagementsystem.model.User;
public interface UserService {
    User saveUser(UserDto userDto) throws EmsException401;
    User getUserByUsername(String username);
}
