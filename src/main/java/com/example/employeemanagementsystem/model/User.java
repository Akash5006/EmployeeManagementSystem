package com.example.employeemanagementsystem.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

@Document(collection = "user")
public class User  {
    @MongoId
    private String username;
    private String password;

    public User(){

    }
    public User(String username, String password) {
        this.username=username;
        this.password=password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

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
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
