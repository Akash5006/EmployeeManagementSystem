package com.example.employeemanagementsystem.service;
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
    public void saveUser(User user) {
        userRepo.save(user);
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
