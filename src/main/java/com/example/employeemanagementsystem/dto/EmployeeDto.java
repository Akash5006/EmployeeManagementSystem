package com.example.employeemanagementsystem.dto;
import org.springframework.stereotype.Component;
@Component
public class EmployeeDto {
    private Integer empId;
    private String empName;
    private String empMail;
    private String department;
    private String manager;
    public Integer getEmpId() {
        return empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
    public String getEmpMail() {
        return empMail;
    }
    public void setEmpMail(String empMail) {
        this.empMail = empMail;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getManager() {
        return manager;
    }
    public void setManager(String manager) {
        this.manager = manager;
    }
    @Override
    public String toString() {
        return "EmployeeDto{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empMail='" + empMail + '\'' +
                ", department='" + department + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
