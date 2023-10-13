package com.interswitch.services;

import com.interswitch.services.model.Salary;
import com.interswitch.services.repository.DepartmentRepository;
import com.interswitch.services.repository.SalaryRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import com.interswitch.services.model.Department;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info =
	@Info(title = "Salary API", version = "1.0", description = "Documentation Salary API v1.0")
)
public class SalaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalaryApplication.class, args);
	}
	
	@Bean
    DepartmentRepository repository() {
		DepartmentRepository repository = new DepartmentRepository();
		repository.add(new Department(1L, "Development"));
		repository.add(new Department(1L, "Operations"));
		repository.add(new Department(2L, "Development"));
		repository.add(new Department(2L, "Operations"));		
		return repository;
	}

	@Bean
	SalaryRepository salaryRepository() {
		LocalDateTime firstDate = getDate("2012-02-11T02:06");
		LocalDateTime secondDate = getDate("2012-02-12T06:06");
		LocalDateTime thirdDate = getDate("2012-02-20T09:06");
		SalaryRepository salaryRepository = new SalaryRepository();
		salaryRepository.add(new Salary(1L, BigDecimal.valueOf(1000L), firstDate, 1L));
		salaryRepository.add(new Salary(2L, BigDecimal.valueOf(500L), secondDate, 2L));
		salaryRepository.add(new Salary(3L, BigDecimal.valueOf(800L), thirdDate, 3L));
		salaryRepository.add(new Salary(4L, BigDecimal.valueOf(1000L), firstDate, 1L));
		salaryRepository.add(new Salary(5L, BigDecimal.valueOf(500L), secondDate, 2L));
		salaryRepository.add(new Salary(6L, BigDecimal.valueOf(800L), thirdDate, 3L));
		salaryRepository.add(new Salary(7L, BigDecimal.valueOf(120L), firstDate, 1L));
		salaryRepository.add(new Salary(8L, BigDecimal.valueOf(500L), secondDate, 2L));
		salaryRepository.add(new Salary(9L, BigDecimal.valueOf(1800L), thirdDate, 3L));
		return salaryRepository;
	}

	private LocalDateTime getDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		return LocalDateTime.parse(date, formatter);
	}
	
}
