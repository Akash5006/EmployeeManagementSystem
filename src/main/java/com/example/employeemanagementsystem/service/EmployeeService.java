package com.example.employeemanagementsystem.service;
import com.example.employeemanagementsystem.dto.EmployeeDto;
import com.example.employeemanagementsystem.exception.EmsException;
import com.example.employeemanagementsystem.exception.EmsException404;
import com.example.employeemanagementsystem.model.Employee;
import java.util.List;
public interface EmployeeService {
Employee saveEmployee(EmployeeDto employeeDto);
   Employee getEmployeeById(int empId) throws EmsException;
    void deleteEmployeeById(int empId) throws EmsException404;
    List<Employee> getEmployeeByManager(String empManager);

    Employee updateEmployee(EmployeeDto employeeDto) throws EmsException404;
}
