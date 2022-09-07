package com.example.employeemanagementsystem.controller;
import com.example.employeemanagementsystem.dto.ResponseDto;
import com.example.employeemanagementsystem.dto.UserDto;
import com.example.employeemanagementsystem.exception.AppExceptionHandler;
import com.example.employeemanagementsystem.exception.EmsException;
import com.example.employeemanagementsystem.exception.EmsException401;
import com.example.employeemanagementsystem.model.User;
import com.example.employeemanagementsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
    @PostMapping("/logout")
    public void logoutMethod(Authentication authentication) {

    }
    @PostMapping("/newUser")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto newUser(@RequestBody  UserDto userDto) throws EmsException401 {
        userServiceImpl.saveUser(userDto);
        return new ResponseDto(null, HttpStatus.CREATED.value());
    }
    @PostMapping("/login")
    public ResponseDto login(Authentication authentication) {
        if(authentication.isAuthenticated()){
            return new ResponseDto(null, HttpStatus.OK.value());
        }
      return  new ResponseDto(null, HttpStatus.UNAUTHORIZED.value());
    }
}
