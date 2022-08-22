package com.example.employeemanagementsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepo extends MongoRepository<NewEmployees,Integer> {
    List<NewEmployees> findByManager(String manager);
}
