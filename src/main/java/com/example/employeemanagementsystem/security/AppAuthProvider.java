 package com.example.employeemanagementsystem.security;

import com.example.employeemanagementsystem.dto.UserDto;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.security.AuthProvider;
import java.util.ArrayList;

@Component
public class AppAuthProvider implements AuthenticationProvider {

   private final UserDetailsService userDetailsService;
   public AppAuthProvider(UserDetailsService userDetailsService){
       this.userDetailsService=userDetailsService;
   }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        UserDetails userDetails=userDetailsService.loadUserByUsername(username);
        if(userDetails.getPassword().equals(password)){
            return new UsernamePasswordAuthenticationToken(username,password,new ArrayList<>());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}


