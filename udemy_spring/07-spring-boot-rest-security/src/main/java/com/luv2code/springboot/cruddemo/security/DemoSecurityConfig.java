package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails john= User.builder()
                .username("John")
                .password("{noop}Test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary= User.builder()
                .username("Mary")
                .password("{noop}Test123")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails susan= User.builder()
                .username("Susan")
                .password("{noop}Test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,susan);
    }
}
