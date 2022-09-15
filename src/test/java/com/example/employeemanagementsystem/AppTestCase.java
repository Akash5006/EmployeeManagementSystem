package com.example.employeemanagementsystem;
import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.model.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppTestCase {
    public static User expectedUser = new User("akash", "IIT(BHU)");
    public static User actualUser = new User("akash", "IIT(BHU)");

    public static Employee expectedEmployee =
            new Employee(1, "ajay", "akash@demo.co", "IT", "akash");
    public static Employee actualEmployee =
            new Employee(1, "ajay", "akash@demo.co", "IT", "akash");
}
