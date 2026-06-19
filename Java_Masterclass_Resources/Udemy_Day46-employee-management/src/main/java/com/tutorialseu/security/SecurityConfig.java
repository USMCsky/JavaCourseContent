package com.tutorialseu.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/employee/profile").hasRole("EMPLOYEE")  // Only EMPLOYEE role can access profile
                        .requestMatchers("/admin/employee-list").hasRole("ADMIN")  // Only ADMIN role can access employee list
                        .anyRequest().authenticated()  // All other requests require authentication
                )
                .formLogin(withDefaults())  // Enable form-based login
                .httpBasic(withDefaults());  // Enable basic authentication

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Using BCrypt hashed passwords
        UserDetails employee = User.withUsername("employee")
                .password(passwordEncoder().encode("employee123"))  // BCrypt hashed password for EMPLOYEE
                .roles("EMPLOYEE")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin123"))  // BCrypt hashed password for ADMIN
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(employee, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCrypt for password hashing
    }
}
