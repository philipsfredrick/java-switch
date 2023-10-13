package com.interswitch.employeeportal.repository;

import com.interswitch.employeeportal.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Optional<Department> findByManagerId(Integer id);

}
