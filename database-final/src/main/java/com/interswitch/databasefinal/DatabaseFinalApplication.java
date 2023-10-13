package com.interswitch.databasefinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DatabaseFinalApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DatabaseFinalApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(DatabaseFinalApplication.class, args);
	}
}
