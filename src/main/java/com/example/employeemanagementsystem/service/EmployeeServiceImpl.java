package com.example.employeemanagementsystem.service;
import com.example.employeemanagementsystem.dto.EmployeeDto;
import com.example.employeemanagementsystem.exception.EmsException;
import com.example.employeemanagementsystem.exception.EmsException404;
import com.example.employeemanagementsystem.exception.ErrorCode;
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
    public List<Employee> getEmployeeByManager(String empManager){
        return employeeRepo.findByManager(empManager);
    }

    @Override
    public Employee updateEmployee(EmployeeDto empdto) throws EmsException404 {
        Employee updateEmp = employeeRepo.findById(empdto.getEmpId()).orElse(null);
        if (updateEmp == null) {
            throw new EmsException404(ErrorCode.EMPLOYEE_NOT_FOUND);
        }
        updateEmp.setEmpId(empdto.getEmpId());
        updateEmp.setEmpName(empdto.getEmpName());
        updateEmp.setEmpMail(empdto.getEmpMail());
        updateEmp.setDepartment(empdto.getDepartment());
        updateEmp.setManager(empdto.getManager());
        employeeRepo.save(updateEmp);
        return updateEmp;

    }

    @Override
    public Employee saveEmployee(EmployeeDto empdto) {
        Employee employee = new Employee();
        employee.setEmpId(empdto.getEmpId());
        employee.setEmpName(empdto.getEmpName());
        employee.setEmpMail(empdto.getEmpMail());
        employee.setDepartment(empdto.getDepartment());
        employee.setManager(empdto.getManager());

        employeeRepo.save(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return employeeRepo.findById(empId).orElse(null);
    }
    @Override
    public void deleteEmployeeById(int empId) throws EmsException404{
        Employee deleteEmp = employeeRepo.findById(empId).orElse(null);
        if (deleteEmp == null) {
            throw new EmsException404(ErrorCode.EMPLOYEE_NOT_FOUND);
        }
        employeeRepo.deleteById(empId);

    }
}
