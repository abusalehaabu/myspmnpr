package com.example.demo;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class Secu {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/documents","/form-page", "/submit-form","/login").permitAll()  // Public URLs
                .requestMatchers("/register", "/edit", "/view", "/logd","/dele-  doc/**","/upd-d/**","/g-u/**","/edit-form/**","/update-user/**","/g-j/**").authenticated()  // Restrict /register
                .anyRequest().authenticated()
            )
        //.authorizeHttpRequests(auth -> auth
    //.requestMatchers("/", "/documents", "/delete-document/**", "/login").permitAll()
    //.requestMatchers("/register", "/edit", "/view", "/logd").authenticated() // secure your pages
    //.anyRequest().authenticated()
//)

        .formLogin(form -> form
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .successHandler(new SimpleUrlAuthenticationSuccessHandler("/logd"))
            .permitAll()
        )
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")          // 👈 Redirect to home
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .permitAll()
        );

    return http.build();
}

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
