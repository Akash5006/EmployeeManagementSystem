package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.AppTestCase;
import com.example.employeemanagementsystem.dto.EmployeeDto;
import com.example.employeemanagementsystem.exception.EmsException401;
import com.example.employeemanagementsystem.exception.EmsException404;
import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeServiceImplTest {
@Autowired
    EmployeeServiceImpl employeeServiceImpl;
@MockBean
    EmployeeRepo employeeRepo;
    Employee expectedEmployee = AppTestCase.expectedEmployee;
    Employee actualEmployee = AppTestCase.actualEmployee;

    @Test
    public void saveEmployeeTest() {
        EmployeeDto employeeDto = new EmployeeDto(1, "ajay", "akash@demo.co", "IT", "akash");
        when(employeeRepo.save(actualEmployee)).thenReturn(actualEmployee);
        try {
            assertThat(expectedEmployee.equals(employeeServiceImpl.saveEmployee(employeeDto))).isEqualTo(true);
         //   assertThat(expectedEmployee).isEqualTo(employeeServiceImpl.saveEmployee(employeeDto));
        } catch (EmsException404 ex) {
            Assertions.assertThat(ex.getMessage()).isNotEmpty();
        }
    }
    @Test
    void updateEmployeeByIdFailure() {

        EmployeeDto employeeDto = new EmployeeDto(1, "amit", "akash@demo.co", "dev", "akash");
        when(employeeRepo.save(actualEmployee)).thenReturn(actualEmployee);
        try {
            Employee updatedEmp = employeeServiceImpl.updateEmployee(employeeDto);
            assertThat(expectedEmployee.equals(updatedEmp)).isEqualTo(true);
            fail();
        } catch (EmsException404 ex) {
           assertThat(ex.getMessage()).isNotEmpty();
        }
    }
 @Test
    void deleteEmployeeByIdFailure(){
        Employee employee = actualEmployee;
      //  when(employeeRepo.findById(1)).thenReturn(Optional.ofNullable(employee));
        doNothing().when(employeeRepo).delete(employee);
        try {
            employeeServiceImpl.deleteEmployeeById(1);
            fail();
        } catch (EmsException404 ex) {
            System.out.println("Ok");
            assertThat(ex.getMessage()).isNotEmpty();
        }
    }
}