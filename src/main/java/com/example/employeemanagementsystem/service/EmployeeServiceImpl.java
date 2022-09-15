package com.example.employeemanagementsystem.service;
import com.example.employeemanagementsystem.dto.EmployeeDto;
import com.example.employeemanagementsystem.exception.EmsException404;
import com.example.employeemanagementsystem.exception.ErrorCode;
import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.model.User;
import com.example.employeemanagementsystem.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    MongoTemplate mongoTemplate;

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
    public Page<Employee> getEmployee(Authentication authentication, int pageNumber, int pageSize, String field, String direction, int empId, String empName, String empMail, String department) {

        Query query=new Query();
        if(empId!=0){
            query.addCriteria(Criteria.where("empId").is(empId));
        }
        if(empName!=""){
            query.addCriteria(Criteria.where("empName").regex(empName));
        }
        if(empMail!=""){
            query.addCriteria(Criteria.where("empMail").regex(empMail));
        }
        if(department!=""){
            query.addCriteria(Criteria.where("department").regex(department));
        }
        query.addCriteria(Criteria.where("manager").is(authentication.getName()));
        Sort sort=direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(field).ascending() : Sort.by(field).descending();
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
        query.with(pageable);
        Page<Employee> page= PageableExecutionUtils.getPage(mongoTemplate.find(query,Employee.class),pageable,()->mongoTemplate.count(query.skip(0).limit(0),Employee.class));
        return page;
    }
    @Override
    public Employee saveEmployee(EmployeeDto empdto) throws EmsException404{

        if (employeeRepo.existsById(empdto.getEmpId())) {
            throw new EmsException404(ErrorCode.EMPLOYEE_NOT_FOUND);
        }
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
    /*
    public Page<Employee> getEmployees(int pageNumber, int pageSize, int sortBy) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize,Sort.by("sortBy"));
        Page<Employee> list=employeeRepo.findAll(pageable);
        return list;
    }
*/

}
