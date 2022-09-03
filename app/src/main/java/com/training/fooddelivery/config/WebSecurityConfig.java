package com.training.fooddelivery.config;

import com.training.fooddelivery.security.HeaderUsernamePasswordAuthenticationFilter;
import com.training.fooddelivery.security.MyAuthenticationProvider;
import com.training.fooddelivery.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .authorizeRequests()
                .antMatchers("/h2-console/**", "/swagger-ui/", "/login").permitAll()
                .antMatchers("/foodservice/**", "/orderservice/**", "/main").authenticated()
                .and()
                .authenticationProvider(authenticationProvider)
                .exceptionHandling()
                .and()
                .addFilterBefore(new HeaderUsernamePasswordAuthenticationFilter(new AntPathRequestMatcher("/login", "POST"), authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutSuccessUrl("/");
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public static PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
}
