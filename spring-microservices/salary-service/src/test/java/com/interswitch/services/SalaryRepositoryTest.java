package com.interswitch.services;

import com.interswitch.services.model.Salary;
import com.interswitch.services.repository.SalaryRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;
import com.interswitch.services.model.Department;
import com.interswitch.services.repository.DepartmentRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SalaryRepositoryTest {


    private static final SalaryRepository salaryRepository = new SalaryRepository();



    @Test
    @Order(1)
    void testAddSalary() {
        LocalDateTime testDate = getDate("2012-02-11T02:06");
        Salary salary = new Salary(1L, BigDecimal.valueOf(1000), testDate, 1L);
        salary = salaryRepository.add(salary);
        Assert.notNull(salary, "Salary is null.");
        Assert.isTrue(salary.getId() == 1L, "Salary bad id.");
    }

    @Test
    @Order(2)
    void testFindAll() {
        List<Salary> salaries = salaryRepository.findAll();
        Assert.isTrue(salaries.size() == 0, "Salaries size is wrong.");
        Assert.isTrue(salaries.get(0).getId() == 1L, "Salary bad id.");
    }

//    @Test
//    @Order(3)
//    void testFindByOrganization() {
//        List<Department> departments = repository.findByOrganization(1L);
//        Assert.isTrue(departments.size() == 1, "Departments size is wrong.");
//        Assert.isTrue(departments.get(0).getId() == 1L, "Department bad id.");
//    }

    @Test
    @Order(4)
    void testFindById() {
        Salary salary = salaryRepository.findById(1L);
        Assert.notNull(salary, "Salary not found.");
        Assert.isTrue(salary.getId() == 1L, "Salary bad id.");
    }

    private LocalDateTime getDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return LocalDateTime.parse(date, formatter);
    }
}
