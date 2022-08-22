package com.example.employeemanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
public class LoginController {
    @Autowired
   LoginRepo loginRepo;
 @Autowired
 EmployeeRepo employeeRepo;
    @RequestMapping("/")
    public String loginPages() {
        return "loginPage";
    }

    @PostMapping("/home")
    public String logoutmethod() {
        return "loginPage";
    }

    @PostMapping("/newuser")
    public Login Newuser(@RequestBody Login login) {
        if (!login.getPassword().isEmpty()&&(!login.getUsername().isEmpty())){
        loginRepo.save(login);
    }
       return login;
    }

    @PostMapping("/profile")
    public List<NewEmployees> getprofile(@RequestBody Login login) {
        Login login1=loginRepo.findById(login.getUsername()).orElse(null);
      if(login==null || (!login.getPassword().equals(login1.getPassword())))
           return null;
       List<NewEmployees> list= employeeRepo.findByManager(login.getUsername());
       return list;

    }

    @PostMapping("/save") // add employee
    public List<NewEmployees> add(@RequestBody EmployeeDto empdto)
    {
        NewEmployees employee=new NewEmployees();
        employee.setId(empdto.getEmpid());
        employee.setEmpname(empdto.getEmpname());
        employee.setEmpmail(empdto.getEmpmail());
        employee.setDepartment(empdto.getDepartment());
        employee.setManager(empdto.getManager());
       employeeRepo.save(employee);
        List<NewEmployees> list= employeeRepo.findByManager(empdto.getManager());
        return list;
    }

    @GetMapping("/allemployee")
    public List<NewEmployees> all(@RequestBody Login login)
    {
        List<NewEmployees> list= employeeRepo.findByManager(login.getUsername());
        return list;
    }

    @PutMapping("/updateemployee")
    public List<NewEmployees> update(@RequestBody EmployeeDto empdto)
    {
        NewEmployees empupdate = employeeRepo.findById(empdto.getEmpid()).orElse(null);
        empupdate.setId(empdto.getEmpid());
        empupdate.setEmpname(empdto.getEmpname());
        empupdate.setEmpmail(empdto.getEmpmail());
        empupdate.setDepartment(empdto.getDepartment());
        empupdate.setManager(empdto.getManager());
        employeeRepo.save(empupdate);
        List<NewEmployees> list= employeeRepo.findByManager(empdto.getManager());
         return list;

    }

    @DeleteMapping("/deleteemployee")
    public List<NewEmployees> delete(@RequestBody EmployeeDto empdto)
    {
        employeeRepo.deleteById(empdto.getEmpid());
        List<NewEmployees> list= employeeRepo.findByManager(empdto.getManager());
        return list;
    }

}
