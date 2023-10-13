package com.interswitch.employeeportal.service;

import com.interswitch.employeeportal.dto.request.EmployeeRequest;
import com.interswitch.employeeportal.dto.request.SalaryRatesRequest;
import com.interswitch.employeeportal.dto.response.EmployeeResource;
import com.interswitch.employeeportal.dto.response.PaginatedEmployeeDetailsResource;
import com.interswitch.employeeportal.dto.response.SalaryRatesResource;
import com.interswitch.employeeportal.model.SalaryRates;

import java.util.List;

public interface SalaryRatesService {

    void addSalaryRates(SalaryRatesRequest salaryRatesRequest);

    SalaryRatesResource updateSalaryRates(Integer salaryRatesId, SalaryRatesRequest salaryRatesRequest);

    List<SalaryRatesResource> getAllSalaryRates();

//    List<SalaryRates> getAllSalaryRates();

    SalaryRatesResource getASalaryRate(Integer salaryRatesId);

    List<EmployeeResource> getEmployeesBySalaryRate(Integer id);
}
