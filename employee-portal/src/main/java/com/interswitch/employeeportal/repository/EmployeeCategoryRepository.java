package com.interswitch.employeeportal.repository;

import com.interswitch.employeeportal.model.Employee;
import com.interswitch.employeeportal.model.EmployeeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCategoryRepository extends JpaRepository<EmployeeCategory, Integer> {
}
