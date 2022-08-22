package com.example.employeemanagementsystem;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.annotation.Documented;

@Entity

public class Login {
@Id

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" + "username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }
}
