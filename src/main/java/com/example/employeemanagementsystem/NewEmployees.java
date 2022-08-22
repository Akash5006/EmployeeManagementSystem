package com.example.employeemanagementsystem;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
@Document(collection = "Employee")
public class NewEmployees {



    @MongoId
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String empname;
    private String empmail;
    private String department;
    private String manager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }


    public String getEmpmail() {
        return empmail;
    }

    public void setEmpmail(String empmail) {
        this.empmail = empmail;
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
        return "NewEmployees{" +
                "id=" + id +
                ", empname='" + empname + '\'' +
                ", empmail='" + empmail + '\'' +
                ", department='" + department + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }


}
