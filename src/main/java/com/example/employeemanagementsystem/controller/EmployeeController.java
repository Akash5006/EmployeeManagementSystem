package com.example.employeemanagementsystem.controller;
import com.example.employeemanagementsystem.dto.EmployeeDto;
import com.example.employeemanagementsystem.dto.ResponseDto;
import com.example.employeemanagementsystem.dto.UserDto;
import com.example.employeemanagementsystem.exception.EmsException;
import com.example.employeemanagementsystem.exception.EmsException404;
import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;
    @PostMapping("/addEmployee")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto addEmployee(@RequestBody EmployeeDto employeeDto) {

        Employee employee = employeeServiceImpl.saveEmployee(employeeDto);
        return new ResponseDto(employee, HttpStatus.CREATED.value());
    }

    @GetMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto getEmployee(@PathVariable("id") Integer id) throws EmsException {
        Employee employee = employeeServiceImpl.getEmployeeById(id);
        return new ResponseDto(employee, HttpStatus.OK.value());
    }

    @GetMapping("/allEmployee")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto allEmployee(Authentication authentication) {
        List<Employee> list = employeeServiceImpl.getEmployeeByManager(authentication.getName());
        return new ResponseDto(list, HttpStatus.OK.value());
    }
    @PutMapping("/updateEmployee")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto updateEmployee(@RequestBody EmployeeDto empdto) throws EmsException404{
          Employee list= employeeServiceImpl.updateEmployee(empdto);
          return new ResponseDto(list, HttpStatus.OK.value());
    }
    @DeleteMapping("/deleteEmployee/{empId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto deleteEmployee(@PathVariable("empId") Integer empId) throws EmsException404 {
       // Employee employee=employeeServiceImpl.getEmployeeById(empId);
      employeeServiceImpl.deleteEmployeeById(empId);
        return new ResponseDto(null, HttpStatus.OK.value());
    }
}
