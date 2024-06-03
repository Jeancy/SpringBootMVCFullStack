package com.jeancy.security;

/**
 *
 * @author Jeancy
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/login").permitAll() // Allow access to root and login without authentication
                .antMatchers("/home").authenticated() // Require authentication for home page
                .antMatchers("/admin").hasRole("ADMIN")// Restrict /admin to users with ADMIN role
                .anyRequest().authenticated()// All other requests require authentication
                .and()
            .formLogin()
                .loginPage("/login")// Specify custom login page
                .defaultSuccessUrl("/home", true) // Redirect to home page on successful login
                .permitAll()// Allow everyone to see the login page
                .and()
            .logout()
                .permitAll();// Allow everyone to logout
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();// Password encoder bean
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}