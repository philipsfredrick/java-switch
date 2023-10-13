package com.interswitch.employeeportal.repository;

import com.interswitch.employeeportal.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByDepartmentId(Integer departmentId);
    List<Employee> findByEmployeeCategoryId(Integer employeeCategoryId);
}
