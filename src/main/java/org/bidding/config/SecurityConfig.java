package org.bidding.config;

import org.bidding.utils.filters.CsrfTokenResponseHeaderBindingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

/**
 * Spring Security Configuration.
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("admin").password("admin").roles("ADMIN").and()
				.withUser("seller").password("seller").roles("USER").and()
				.withUser("bidder").password("bidder").roles("USER");
	}
	
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http
				.antMatcher("/api/**")
				.authorizeRequests()
					.anyRequest().hasRole("ADMIN")
					.and()
				.httpBasic();
			
			http.addFilterAfter(new CsrfTokenResponseHeaderBindingFilter(), CsrfFilter.class);
		}
	}
	
//	@Order(2)
//	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http
//				.authorizeRequests()
//					.antMatchers("/resources/views/public/**").permitAll()
//					.antMatchers("/resources/views/protected/**").hasRole("USER")
//					.anyRequest().authenticated()
//					.and()
//				.httpBasic();
//		}
//	}
}
