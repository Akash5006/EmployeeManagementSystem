package com.example.employeemanagementsystem.repository;
import com.example.employeemanagementsystem.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

}
