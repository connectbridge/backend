package com.bridge.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
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
									"/images/**",
									"/auth/**");
	}
}
