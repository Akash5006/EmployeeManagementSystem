package com.example.employeemanagementsystem.service;
import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public void saveEmployee(Employee employee){
        employeeRepo.save(employee);
    }
    @Override
    public List<Employee> getEmployeeByManager(String empManager){
        return employeeRepo.findByManager(empManager);
    }
    @Override
    public Employee getEmployeeById(int empId){
        return employeeRepo.findById(empId).get();
    }
    @Override
    public void deleteEmployeeById(int empId){
        employeeRepo.deleteById(empId);
    }
}
