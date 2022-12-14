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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public  UserDetailsService userDetailsService(){
        return new UserServiceImpl();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationProvider authenticationProvider = new AppAuthProvider(userDetailsService());
        http
                .cors()
                .and()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests().antMatchers("/login", "/newUser").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2) throws IOException, ServletException {
                        System.out.println("***onLogoutSuccess***");
                    }
                })
                .clearAuthentication(true)
                .invalidateHttpSession(true);
//                .permitAll()
//                .clearAuthentication(true)
//                .deleteCookies("JSESSIONID");
        http
                .httpBasic();
        http
                .csrf().disable();
        http.authenticationProvider(authenticationProvider);
        return http.build();
    }

}

