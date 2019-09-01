package com.bridge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.bridge.handler.CustomAuthenticationFailureHandler;
import com.bridge.handler.CustomLogoutSuccessHandler;
import com.bridge.web.service.AuthProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	AuthenticationFailureHandler CustomAuthenticationFailureHandler = new CustomAuthenticationFailureHandler();
	LogoutSuccessHandler CustomLogoutSuccessHandler = new CustomLogoutSuccessHandler();

	@Autowired
	AuthProvider authProvider;

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 허용되어야 할 경로들
		web.ignoring().antMatchers("/v2/api-docs",
									"/configuration/ui",
									"/swagger-resources",
									"/configuration/security",
									"/swagger-ui.html",
									"/webjars/**",
									"/swagger-resources/configuration/ui",
									"/swagger-ui.html",
									"/css/**",
									"/script/**",
									"/images/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
					.antMatchers("/",
								"/main",
								"/auth/joinForm**",
								"/auth/loginForm**",
								"/auth/logout**",
								"/resources/**",
								"/id/**",
								"/").permitAll()
					.antMatchers("/admin")
						.hasRole("ADMIN")
						.anyRequest()
						.authenticated()
				.and()
					.formLogin()
					.loginPage("/auth/loginForm")
					.loginProcessingUrl("/auth/loginForm")
					.failureHandler(CustomAuthenticationFailureHandler)
					.usernameParameter("id")
					.passwordParameter("password")
					.defaultSuccessUrl("/main")
					.permitAll()
				.and()
					.logout()
					.logoutUrl("/auth/logout")
					.logoutSuccessHandler(CustomLogoutSuccessHandler)
					.permitAll()
				.and()
					.authenticationProvider(authProvider);
	}
}
