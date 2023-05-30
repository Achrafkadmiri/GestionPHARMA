package com.management.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin().loginPage("/login").successForwardUrl("/accueil").permitAll();
        httpSecurity.authorizeHttpRequests().requestMatchers("/webjar/**","/resources/**", "/css/**").permitAll();
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
        return  httpSecurity.build();
    }
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(passwordEncoder.encode("0000")).roles("admin").build()
        );
    }

}
