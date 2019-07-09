package com.searchhouse.searchhouse.configuration;

import com.searchhouse.searchhouse.UrlAuthenticationSuccessHandler;
import com.searchhouse.searchhouse.UserPrincipalDetailsService;
import com.searchhouse.searchhouse.service.UserService;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserPrincipalDetailsService userPrincipalDetailsService;

    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService){
        this.userPrincipalDetailsService = userPrincipalDetailsService;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // The pages does not require login
        http.authorizeRequests()
                .antMatchers("/", "/register**", "/about", "/contact", "/logements", "/favicon.ico", "/js/**", "/css/**", "/images/**", "/webjars/**")
                .permitAll()
                .antMatchers("/user/**").authenticated() // For USERS only.
                .antMatchers("/agent/**").hasRole("AGENT") // For AGENTS only.
                .antMatchers("/admin/**").hasRole("ADMIN") // For ADMIN only.
                .and() // Config for Login Form
                .formLogin()
                .loginPage("/login")
                .successHandler(searchhouseAuthenticationSuccessHandler())
        // When the user has logged in as XXXXX.
        // But access a page that requires role YYYYY,
        // AccessDeniedException will be thrown.
                .and().exceptionHandling().accessDeniedPage("/403");

    }

    @Bean
    public AuthenticationSuccessHandler searchhouseAuthenticationSuccessHandler(){
        return new UrlAuthenticationSuccessHandler();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
