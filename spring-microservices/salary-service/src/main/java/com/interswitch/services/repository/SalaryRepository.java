package com.interswitch.services.repository;

import com.interswitch.services.model.Salary;

import java.util.ArrayList;
import java.util.List;

public class SalaryRepository {

    private List<Salary> salaries = new ArrayList<>();

    public Salary add(Salary salary) {
        salary.setId((long) (salaries.size()+1));
        salaries.add(salary);
        return salary;
    }

    public Salary findById(Long id) {
        return salaries.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Salary> findAll() {
        return salaries;
    }


    public List<Salary> findByEmployeeId(Long employeeId) {
        return salaries.stream()
                .filter(a -> a.getEmployeeId().equals(employeeId))
                .toList();
    }

    public void addDepartmentIdToSalary(Long employeeId, Long departmentId) {
        List<Salary> salaryList = findByEmployeeId(employeeId);
        salaryList.forEach(salary -> salary.setDepartmentId(departmentId));
    }
}
