package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource)
    {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
            "select user_id, pw, active from members where user_id=?"
        );
        //define query to retrieve the authrities/roles for goven username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        
        return jdbcUserDetailsManager;
    }
    
    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager() {
    //     // UserDetails john = User.builder()
    //     //     .username("john")
    //     //     .password("{noop}test123")
    //     //     .roles("Employee")
    //     //     .build();

    //     // UserDetails mary = User.builder()
    //     //     .username("mary")
    //     //     .password("{noop}mary123")
    //     //     .roles("Employee", "Manager", "Admin")
    //     //     .build();

    //     // return new InMemoryUserDetailsManager(john, mary);        

    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("Employee")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("Employee")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("Employee")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("Manager")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees").hasRole("Admin")
                
        );

        //use http basic authentication

        http.httpBasic(Customizer.withDefaults());

        //disable Cross site request forgery
        //not req for statless rest apis
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
