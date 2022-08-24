package com.example.employeemanagementsystem;
import com.example.employeemanagementsystem.dto.EmployeeDto;
import com.example.employeemanagementsystem.dto.UserDto;
import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;
    @PostMapping("/addemployee")
    public List<Employee> addEmployee(@RequestBody EmployeeDto empdto) {
        Employee employee = new Employee();
        employee.setEmpId(empdto.getEmpId());
        employee.setEmpName(empdto.getEmpName());
        employee.setEmpMail(empdto.getEmpMail());
        employee.setDepartment(empdto.getDepartment());
        employee.setManager(empdto.getManager());
        employeeServiceImpl.saveEmployee(employee);
        List<Employee> list = employeeServiceImpl.getEmployeeByManager(empdto.getManager());
        return list;
    }
    @GetMapping("/allemployee")
    public List<Employee> allEmployee(@RequestBody UserDto userDto) {
        List<Employee> list = employeeServiceImpl.getEmployeeByManager(userDto.getUsername());
        return list;
    }
    @PutMapping("/updateemployee")
    public List<Employee> updateEmployee(@RequestBody EmployeeDto empdto) {
        Employee empUpdate = employeeServiceImpl.getEmployeeById(empdto.getEmpId());
        empUpdate.setEmpId(empdto.getEmpId());
        empUpdate.setEmpName(empdto.getEmpName());
        empUpdate.setEmpMail(empdto.getEmpMail());
        empUpdate.setDepartment(empdto.getDepartment());
        empUpdate.setManager(empdto.getManager());
        employeeServiceImpl.saveEmployee(empUpdate);
        List<Employee> list = employeeServiceImpl.getEmployeeByManager(empdto.getManager());
        return list;
    }
    @DeleteMapping("/deleteemployee")
    public List<Employee> deleteEmployee(@RequestBody EmployeeDto empdto) {
        employeeServiceImpl.deleteEmployeeById(empdto.getEmpId());
        List<Employee> list = employeeServiceImpl.getEmployeeByManager(empdto.getManager());
        return list;
    }
}
