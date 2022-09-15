package com.example.employeemanagementsystem.service;
import com.example.employeemanagementsystem.dto.EmployeeDto;
import com.example.employeemanagementsystem.exception.EmsException;
import com.example.employeemanagementsystem.exception.EmsException404;
import com.example.employeemanagementsystem.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;

import java.util.List;
public interface EmployeeService {
Employee saveEmployee(EmployeeDto employeeDto) throws EmsException404;
   Employee getEmployeeById(int empId) throws EmsException;
    void deleteEmployeeById(int empId) throws EmsException404;
    List<Employee> getEmployeeByManager(String empManager);

    Employee updateEmployee(EmployeeDto employeeDto) throws EmsException404;

    Page<Employee> getEmployee(Authentication authentication,int pageNumber,int pageSize, String field, String direction, int empId, String empName, String empMail,String department);
}
