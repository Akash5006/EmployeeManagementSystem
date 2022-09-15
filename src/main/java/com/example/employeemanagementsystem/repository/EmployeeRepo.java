package com.example.employeemanagementsystem.repository;
import com.example.employeemanagementsystem.model.Employee;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EmployeeRepo extends MongoRepository<Employee, Integer> {



    List<Employee> findByManager(String manager);
}
