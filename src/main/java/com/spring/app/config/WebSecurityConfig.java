package com.spring.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http
			.cors().and()
	    	.csrf().disable()
	    	
			.authorizeRequests()
			//.antMatchers("/*").denyAll()
			.antMatchers("/*").authenticated()
			.anyRequest().permitAll()
			.and()
				.formLogin().loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/home")
			.and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
			//.sessionManagement().maximumSessions(2);
		
	}
	
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("admin").password("{noop}admin").roles("ADMIN")
			.and().withUser("user").password("{noop}user").roles("USER");
	}
	
	//@Bean
    //public PasswordEncoder passwordEncoder() {
    //    return new BCryptPasswordEncoder();
    //}
}
