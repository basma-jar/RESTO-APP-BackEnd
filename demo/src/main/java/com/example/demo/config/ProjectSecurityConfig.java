package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests((requests) ->
                requests
                    .antMatchers("/myAccount").authenticated()
                    .antMatchers("/restaurant").permitAll()
            )
            .formLogin((form) ->
                form
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/myAccount")
            )
            .logout((logout) ->
                logout
                    .logoutSuccessUrl("/login")
            )
            .httpBasic()
            .and()
            .csrf().disable();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
