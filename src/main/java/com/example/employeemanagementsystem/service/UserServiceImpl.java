package com.example.employeemanagementsystem.service;
import com.example.employeemanagementsystem.dto.UserDto;
import com.example.employeemanagementsystem.exception.EmsException;
import com.example.employeemanagementsystem.exception.EmsException401;
import com.example.employeemanagementsystem.exception.ErrorCode;
import com.example.employeemanagementsystem.model.User;
import com.example.employeemanagementsystem.repository.UserRepo;
import com.example.employeemanagementsystem.security.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Override
    public User saveUser(UserDto userDto) throws EmsException401 {
        if (userDto.getUsername().isEmpty() || userDto.getPassword().isEmpty()) {
            throw new EmsException401(ErrorCode.USER_NOT_VALID);
        }

        if(getUserByUsername(userDto.getUsername())!=null){
            throw new EmsException401(ErrorCode.USER_ALREADY_EXISTS);
       }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        userRepo.save(user);
        return user;
    }
    @Override
    public User getUserByUsername(String username) {
        User user= userRepo.findById(username).orElse(null);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepo.findById(username).orElse(null);
        if(user==null) throw new UsernameNotFoundException("User not found");
        return new UserDetailImpl(user);
    }
}
