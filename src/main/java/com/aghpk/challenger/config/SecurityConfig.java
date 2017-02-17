package com.aghpk.challenger.config;

import com.aghpk.challenger.service.CustomUserDetailsService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/api/**")
                .access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login?logout")
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/403")
                .and().csrf().disable();
        //TODO csrf configuration
//                .and().csrf().csrfTokenRepository(csrfTokenRepository()). //csrf token for angular
//                and().addFilterAfter(csrfHeaderFilter(), CsrfFilter.class); //filter to store csrf in cookie named 'XSRF-TOKEN' for angular
    }

//    private Filter csrfHeaderFilter() {
//        return new OncePerRequestFilter() {
//            @Override
//            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//                CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//                if (csrf != null) {
//                    Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
//                    String token = csrf.getToken();
//                    if (cookie == null || token != null && !token.equals(cookie.getValue())) {
//                        cookie = new Cookie("XSRF-TOKEN", token);
//                        cookie.setPath("/");
//                        response.addCookie(cookie);
//                    }
//                }
//                filterChain.doFilter(request, response);
//            }
//        };
//    }
//
//    private CsrfTokenRepository csrfTokenRepository() {
//        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//        repository.setHeaderName("X-XSRF-TOKEN");
//        return repository;
//    }

}