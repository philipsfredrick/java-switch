package com.interswitch.employeeportal.service;

import com.interswitch.employeeportal.dto.request.EmployeeRequest;
import com.interswitch.employeeportal.dto.response.EmployeeResource;
import com.interswitch.employeeportal.dto.response.PaginatedEmployeeDetailsResource;

import java.util.List;

public interface EmployeeService {

    void addEmployee(EmployeeRequest employeeRequest);

    EmployeeResource updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);

    PaginatedEmployeeDetailsResource getAllEmployees(Integer page, Integer size);

    EmployeeResource getAnEmployee(Integer employeeId);
    List<EmployeeResource> getEmployeesByManager(Integer employeeId);
}
