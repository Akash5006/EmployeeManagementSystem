package com.example.employeemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;


@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class EmployeeManagementSystemApplication {


    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

}
