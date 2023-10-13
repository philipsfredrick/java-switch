package com.interswitch.services.controller;

import com.interswitch.services.client.DepartmentClient;
import com.interswitch.services.client.EmployeeClient;
import com.interswitch.services.model.Department;
import com.interswitch.services.model.Employee;
import com.interswitch.services.model.Salary;
import com.interswitch.services.repository.DepartmentRepository;
import com.interswitch.services.repository.SalaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@RestController
public class SalaryController {


    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    SalaryRepository salaryRepository;
    EmployeeClient employeeClient;

    DepartmentClient departmentClient;

    public SalaryController(SalaryRepository salaryRepository, EmployeeClient employeeClient, DepartmentClient departmentClient) {
        this.salaryRepository = salaryRepository;
        this.employeeClient = employeeClient;
        this.departmentClient = departmentClient;
    }

    @PostMapping("/salaries")
    public Salary add(@RequestBody Salary salary) {
        LOGGER.info("Department add: {}", salary);
        return salaryRepository.add(salary);
    }

    @GetMapping("salaries/{id}")
    public Salary findById(@PathVariable("id") Long id) {
        LOGGER.info("Salary find: id={}", id);
        return salaryRepository.findById(id);
    }

    @GetMapping("/salaries")
    public List<Salary> findAll() {
        LOGGER.info("Salary find");
        return salaryRepository.findAll();
    }


    @GetMapping("/salaries/employees/{employeeId}")
    public List<Salary> findSalariesByEmployeeId(@PathVariable("employeeId") Long employeeId) {
//        Employee employee = employeeClient.findEmployeeById(employeeId);
        LOGGER.info("Salary find: employeeId={}", employeeId);

        return salaryRepository.findByEmployeeId(employeeId);
    }

    @PatchMapping("/salaries/employees/{employeeId}/{departmentId}")
    public void updateSalaryDepartment(@PathVariable("employeeId") Long employeeId, @PathVariable("departmentId") Long departmentId) throws Exception {
        LOGGER.info("Add department to salary: departmentId={}", departmentId);
        Department department = departmentClient.findDepartment(departmentId);
        Employee employee = employeeClient.findEmployeeById(employeeId);
        if (department == null) {
            LOGGER.error("Department is null. ");
            throw new Exception("Department not found");
        }
        salaryRepository.addDepartmentIdToSalary(employee.getId(), department.getId());
    }
}
