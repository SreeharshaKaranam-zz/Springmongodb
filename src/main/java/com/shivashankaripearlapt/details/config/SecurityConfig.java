package com.shivashankaripearlapt.details.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.shivashankaripearlapt.details.service.IUserAuthenticationService;

/**
 * Spring security configuration class extends the
 * {@link WebSecurityConfigurerAdapter} to provide custom security
 * configurations
 * 
 * @Configuration - marks this class as a Configuration class
 * @EnableGlobalMethodSecurity - enables Spring Security global method security
 *                             similar to the xml support.
 * @EnableWebSecurity - on class to have the Spring Security configuration
 *                    defined in any WebSecurityConfigurer or more likely by
 *                    extending the WebSecurityConfigurerAdapter base class and
 *                    overriding individual methods.
 *
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private IUserAuthenticationService userAuthenticationService;

	/**
	 * Configuration to use authentication.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userAuthenticationService).passwordEncoder(passwordEncoder());
	}

	/**
	 * Method to handle http authorization. Only healthCheck url to be allowed
	 * without authentication.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().fullyAuthenticated();
		http.httpBasic();
		http.csrf().disable();
	}

	/**
	 * Password decrypter.
	 * 
	 * @return
	 */
	@Bean
	public  BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * Handler to return a <code>401</code> response code, instead of
	 * <code>302</code>, in case of failed authentication as part of Spring
	 * Security
	 * 
	 * @return
	 */
	@Bean
	public SimpleUrlAuthenticationFailureHandler myFailureHandler() {
		return new SimpleUrlAuthenticationFailureHandler("http://www.thermofisher.com");
	}
}