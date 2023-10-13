package com.danielkpobari.formvalidationapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormValidationAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FormValidationAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int x;
		x = 15;
		System.out.println(x);
	}
}
