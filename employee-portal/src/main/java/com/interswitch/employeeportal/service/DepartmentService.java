package com.interswitch.employeeportal.service;

import com.interswitch.employeeportal.dto.request.DepartmentRequest;
import com.interswitch.employeeportal.dto.request.EmployeeRequest;
import com.interswitch.employeeportal.dto.response.DepartmentResource;
import com.interswitch.employeeportal.dto.response.EmployeeResource;

import java.util.List;

public interface DepartmentService {

    void addDepartment(DepartmentRequest departmentRequest);

    DepartmentResource updateDepartment(Integer departmentId, DepartmentRequest departmentRequest);
    List<DepartmentResource> getAllDepartments();

    DepartmentResource getADepartment(Integer departmentId);

    List<EmployeeResource> findEmployeesByDepartment(Integer id);
}
