package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.AppTestCase;
import com.example.employeemanagementsystem.dto.UserDto;
import com.example.employeemanagementsystem.exception.EmsException;
import com.example.employeemanagementsystem.exception.EmsException401;
import com.example.employeemanagementsystem.model.User;
import com.example.employeemanagementsystem.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserServiceImpl userServiceImpl;
    @MockBean
    UserRepo userRepo;
    User expectedUser = AppTestCase.expectedUser;
    User actualUser = AppTestCase.actualUser;

    @Test
    public void saveUserSuccessTest() {
        UserDto userDto = new UserDto("akash", "IIT(BHU)");
        when(userRepo.save(actualUser)).thenReturn(actualUser);
        try {
            assertThat(expectedUser.equals(userServiceImpl.saveUser(userDto))).isEqualTo(true);

        } catch (EmsException401 ex) {
            assertThat(ex.getMessage()).isNotEmpty();
        }
    }
}