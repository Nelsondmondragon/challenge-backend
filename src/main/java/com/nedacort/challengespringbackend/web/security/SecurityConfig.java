package com.nedacort.challengespringbackend.web.security;
//
//import com.nedacort.challengespringbackend.domain.service.UserDetailService;
//import com.nedacort.challengespringbackend.web.security.filter.JwtFilterRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
////@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailService userDetailService;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    private JwtFilterRequest jwtFilterRequest;
//
//
////    @Override
////    public void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(authProvider());
//    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable().authorizeRequests().antMatchers("/**/auth/**",
////                "/v2/api-docs", "/configuration/ui",
////                "/swagger-resources/**", "/configuration/security",
////                "/swagger-ui.html", "/webjars/**").permitAll()
////                .anyRequest().authenticated().and().sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
////    }
//
//
////    @Override
////    @Bean
////    public AuthenticationManager authenticationManagerBean() throws Exception {
////        return super.authenticationManagerBean();
////    }
////
////    @Bean
////    public DaoAuthenticationProvider authProvider() {
////        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
////        authProvider.setUserDetailsService(userDetailService);
////        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
////        return authProvider;
////    }
//
////}
