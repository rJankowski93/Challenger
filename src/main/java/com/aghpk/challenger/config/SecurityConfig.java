package com.aghpk.challenger.config;

import com.aghpk.challenger.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

//    @Override
//    public void configure(WebSecurity webSecurity) throws Exception{
//        webSecurity
//                    .ignoring()
//                    .antMatchers("/**");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/")
                .access("hasRole('USER')")
                .anyRequest().permitAll()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                .and()
                    .logout()
                    .logoutSuccessUrl("/login?logout")
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/403")
                .and()
                    .csrf();
    }
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService);
    }
}