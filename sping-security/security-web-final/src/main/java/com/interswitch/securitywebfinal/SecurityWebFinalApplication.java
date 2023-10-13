package com.interswitch.securitywebfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SecurityWebFinalApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SecurityWebFinalApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SecurityWebFinalApplication.class, args);
	}

}
