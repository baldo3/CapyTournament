package com.example.demo;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public RepositoryPlayerDetailService playerDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(playerDetailService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}
	
	
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
 http.authorizeRequests().antMatchers("/champion").permitAll();
 http.authorizeRequests().antMatchers("/tournament").permitAll();
 http.authorizeRequests().antMatchers("/player").permitAll();
 http.authorizeRequests().antMatchers("/champions_list").permitAll();
 http.authorizeRequests().antMatchers("/resources/*").permitAll();
 
 
 http.authorizeHttpRequests().antMatchers("/create_champion").hasAnyRole("ADMIN");
 http.authorizeHttpRequests().antMatchers("/create_tournament").hasAnyRole("ADMIN");
 http.authorizeHttpRequests().antMatchers("/delete_champion/*").hasAnyRole("ADMIN");
 http.authorizeHttpRequests().antMatchers("/delete_player/*").hasAnyRole("ADMIN");
 http.authorizeHttpRequests().antMatchers("/delete_team/*").hasAnyRole("ADMIN");
 http.authorizeHttpRequests().antMatchers("/play_game/*/*").hasAnyRole("ADMIN");
 http.authorizeHttpRequests().antMatchers("/play_game/*").hasAnyRole("ADMIN");
 
 //http.authorizeHttpRequests().antMatchers("/join_team/*").hasAnyRole("PLAYER");
 //http.authorizeHttpRequests().antMatchers("/join_tournament/*").hasAnyRole("PLAYER");
 //http.authorizeHttpRequests().antMatchers("/create_team").hasAnyRole("PLAYER");

 
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
