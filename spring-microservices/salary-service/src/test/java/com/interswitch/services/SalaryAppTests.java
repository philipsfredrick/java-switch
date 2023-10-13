package com.interswitch.services;

import com.interswitch.services.client.DepartmentClient;
import com.interswitch.services.model.Salary;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import com.interswitch.services.client.EmployeeClient;
import com.interswitch.services.model.Department;
import com.interswitch.services.model.Employee;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {
        "spring.cloud.discovery.enabled=false",
        "spring.cloud.config.discovery.enabled=false"
    }
)
public class SalaryAppTests {

    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    EmployeeClient employeeClient;
    @MockBean
    DepartmentClient departmentClient;

    @Test
    void findAll() {
        Salary[] salaries = restTemplate.getForObject("/", Salary[].class);
        assertTrue(salaries.length > 0);
    }

    @Test
    void findById() {
        Salary salary = restTemplate.getForObject("/salaries/{id}", Salary.class, 1L);
        assertNotNull(salary);
        assertNotNull(salary.getId());
        assertNotNull(salary.getAmount());
        assertNotNull(salary.getEmployeeId());
        assertNull(salary.getDepartmentId());
        Assertions.assertEquals(1L, salary.getId());
    }

    @Test
    void findSalariesByEmployee() {
//        Department[] departments = restTemplate.getForObject("/organization/{organizationId}", Department[].class, 1L);
//        Assertions.assertTrue(departments.length > 0);
        Mockito.when(employeeClient.findEmployeeById(Mockito.anyLong()))
                .thenReturn(Instancio.of(Employee.class).create());
        Salary[] salaries = restTemplate.getForObject("/salaries/employees/{employeeId}", Salary[].class, 1L);
        assertTrue(salaries.length > 0);
    }

//    @Test
//    void findByOrganizationWithEmployees() {
//        Mockito.when(employeeClient.findByDepartment(Mockito.anyLong()))
//                .thenReturn(Instancio.ofList(Employee.class).create());
//        Department[] departments = restTemplate.getForObject("/organization/{organizationId}/with-employees", Department[].class, 1L);
//        assertTrue(departments.length > 0);
//    }

    @Test
    void add() {
        Salary salary = Instancio.create(Salary.class);
        salary = restTemplate.postForObject("/salaries", salary, Salary.class);
        assertNotNull(salary);
        assertNotNull(salary.getId());
        assertNotNull(salary.getAmount());
        assertNotNull(salary.getEmployeeId());
    }

    @ParameterizedTest
    @CsvSource({"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void testFileSomeMonthsARE30DaysLongCsv(Month month) {
        final boolean isALeapYear = false;
        assertEquals(30, month.length(isALeapYear));
    }
}
