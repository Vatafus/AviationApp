package com.example.aviation.configuration;

import com.example.aviation.filter.JWTRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Autowired
    private JWTRequestFilter authFilter;

    private static final String[] AUTH_PERMIT_ALL = {
            "/booking/get-all-bookings/{userId}",
            "/booking/{userId}/flights/{flightId}",
            "/booking/{bookingId}/boarding-passes",
            "/booking/user/{userId}",
            "/user/login",
            "/user/register"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors().and().csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(AUTH_PERMIT_ALL).permitAll()
                .requestMatchers("/flights/all-flights","/admin/delete/flight/{id}","/admin/create/flight","/admin/update/flight/{id}").hasAuthority("ADMIN")
                .requestMatchers("/flights/find/flight/{id}","/flights/find/{leavingfrom}/{arrivingat}/{leavingdate}").hasAnyAuthority("ADMIN","USER")
                .anyRequest().authenticated().and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
