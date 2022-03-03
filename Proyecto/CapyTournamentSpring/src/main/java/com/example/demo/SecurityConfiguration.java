package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 @Override
 protected void configure(HttpSecurity http) throws Exception {

 // Public pages
 http.authorizeRequests().antMatchers("/").permitAll();
 http.authorizeRequests().antMatchers("/login").permitAll();
 http.authorizeRequests().antMatchers("/loginerror").permitAll();
 http.authorizeRequests().antMatchers("/logout").permitAll();
 http.authorizeRequests().antMatchers("/register").permitAll();
 http.authorizeRequests().antMatchers("/home").permitAll();
 http.authorizeRequests().antMatchers("/teams_list").permitAll();
 http.authorizeRequests().antMatchers("/tournaments_list").permitAll();
 http.authorizeRequests().antMatchers("/players_list").permitAll();
 http.authorizeRequests().antMatchers("/champions_list").permitAll();
 http.authorizeRequests().antMatchers("/team").permitAll();
 http.authorizeRequests().antMatchers("/tournament").permitAll();
 http.authorizeRequests().antMatchers("/player").permitAll();
 http.authorizeRequests().antMatchers("/champions_list").permitAll();
 http.authorizeRequests().antMatchers("/resources/*").permitAll();

 
 // Private pages (all other pages)
 http.authorizeRequests().anyRequest().authenticated();
 // Login form
 http.formLogin().loginPage("/login");
 http.formLogin().usernameParameter("username");
 http.formLogin().passwordParameter("password");
 http.formLogin().defaultSuccessUrl("/home");
 http.formLogin().failureUrl("/loginerror");
 // Logout
 http.logout().logoutUrl("/logout");
 http.logout().logoutSuccessUrl("/");

 // Disable CSRF at the moment
 http.csrf().disable();
 }
}
