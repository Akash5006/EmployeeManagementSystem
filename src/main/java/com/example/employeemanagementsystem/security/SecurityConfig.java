package com.example.employeemanagementsystem.security;

import com.example.employeemanagementsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public  UserDetailsService userDetailsService(){
        return new UserServiceImpl();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
        {
               AuthenticationProvider authenticationProvider = new AppAuthProvider(userDetailsService());
            http  .authorizeRequests()
                    .antMatchers("/login","/newuser").permitAll().anyRequest().authenticated();
            http .httpBasic();
            http.csrf().disable();
             http  .authenticationProvider(authenticationProvider);
        return http.build();
    }

}

