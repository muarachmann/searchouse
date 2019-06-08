package com.searchhouse.searchhouse.configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Enable jdbc authentification

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth)
        throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
    }

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception{

        JdbcUserDetailsManager jdbcUserDetailsManager= new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);

        return jdbcUserDetailsManager;
    }

    @Override
    protected void configure(HttpSecurity http)
        throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/register", "/about", "/contact", "/logement", "/login/useragent").permitAll()
                    .antMatchers("/favicon.ico").permitAll()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/js/**").permitAll()
                    .antMatchers("/static/**").permitAll()
                    .antMatchers("/images/**").permitAll()
                    .antMatchers("/blog/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/")
                    .permitAll()
                .and()
                .logout()
                    .permitAll();

        http.csrf().disable();
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

}
