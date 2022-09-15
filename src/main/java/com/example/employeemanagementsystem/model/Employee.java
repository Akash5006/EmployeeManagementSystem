package com.example.employeemanagementsystem.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

@Document(collection = "Employee")
public class Employee {
    private Integer empId;
    private String empName;
    private String empMail;
    private String department;
    private String manager;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(empId, employee.empId) && Objects.equals(empName, employee.empName) && Objects.equals(empMail, employee.empMail) && Objects.equals(department, employee.department) && Objects.equals(manager, employee.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, empMail, department, manager);
    }

    public Employee(){
    }
    public Employee(int empId, String empName, String empMail, String department, String manager) {
        this.empId=empId;
        this.empName=empName;
        this.empMail=empMail;
        this.department=department;
        this.manager=manager;
    }

    @MongoId
    public Integer getEmpId() {
        return empId;
    }
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
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
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empMail='" + empMail + '\'' +
                ", department='" + department + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
