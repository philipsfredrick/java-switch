package com.interswitch.employeeportal.service;

import com.interswitch.employeeportal.dto.request.EmployeeCategoryRequest;
import com.interswitch.employeeportal.dto.request.EmployeeRequest;
import com.interswitch.employeeportal.dto.response.EmployeeCategoryResource;
import com.interswitch.employeeportal.dto.response.EmployeeResource;
import com.interswitch.employeeportal.dto.response.PaginatedEmployeeDetailsResource;
import com.interswitch.employeeportal.model.EmployeeCategory;

import java.util.List;

public interface EmployeeCategoryService {

    void addEmployeeCategory(EmployeeCategoryRequest employeeCategoryRequest);

    EmployeeCategoryResource updateEmployeeCategory(Integer categoryId, EmployeeCategoryRequest employeeCategoryRequest);

    List<EmployeeCategoryResource> getAllEmployeeCategories();

    EmployeeCategoryResource getAnEmployeeCategory(Integer categoryId);
}
