package com.example.employeemanagementsystem.controller;
import com.example.employeemanagementsystem.dto.UserDto;
import com.example.employeemanagementsystem.model.User;
import com.example.employeemanagementsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @RequestMapping("/")
    public String loginPages() {
        return "loginPage";
    }
    @PostMapping("/home")
    public String logoutMethod() {
        return "loginPage";
    }
    @PostMapping("/newuser")
    public User newUser(@RequestBody UserDto userDto) {
        User user = new User();
        if (!userDto.getPassword().isEmpty() && (!userDto.getUsername().isEmpty())) {
            user.setUsername(userDto.getUsername());
            user.setPassword((userDto.getPassword()));
            userServiceImpl.saveUser(user);
        }
        return user;
    }
    @PostMapping("/login")
    public User getProfile(@RequestBody UserDto userDto) {
        User user = userServiceImpl.getUserByUsername(userDto.getUsername());
        if (userDto == null || (!userDto.getPassword().equals(user.getPassword())))
            return null;
       return user;
    }
}
