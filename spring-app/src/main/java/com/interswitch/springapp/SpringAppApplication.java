package com.interswitch.springapp;

import com.interswitch.springapp.model.Greeting;
import com.interswitch.springapp.service.Greet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@SpringBootApplication
public class SpringAppApplication implements ApplicationRunner {

	private final Greeting greeting;

	private final Greet greet;
	@Value(value = "${spring.application.name:spring-service-app}")
	private String appName;

	public SpringAppApplication(@Autowired @Qualifier("myGreeting") Greeting greeting,
								 Greet greet) {
		this.greeting = greeting;
		this.greet = greet;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(greeting.sayHello("Students"));
		greet.greeting();
		System.out.println(appName);
	}

	@RequestMapping(name = "/")
	public String getAppName() {
		return "Started running ".concat(appName)
				.concat(" at ")
				.concat(LocalDateTime.now().toString());
	}
}
