package com.interswitch.employeeportal.service.impl;

import com.interswitch.employeeportal.converter.EmployeeToResourceConverter;
import com.interswitch.employeeportal.converter.SalaryRatesToResourceConverter;
import com.interswitch.employeeportal.dto.request.SalaryRatesRequest;
import com.interswitch.employeeportal.dto.response.EmployeeResource;
import com.interswitch.employeeportal.dto.response.SalaryRatesResource;
import com.interswitch.employeeportal.exception.EmployeePortalException;
import com.interswitch.employeeportal.model.Employee;
import com.interswitch.employeeportal.model.EmployeeCategory;
import com.interswitch.employeeportal.model.SalaryRates;
import com.interswitch.employeeportal.repository.EmployeeCategoryRepository;
import com.interswitch.employeeportal.repository.EmployeeRepository;
import com.interswitch.employeeportal.repository.SalaryRatesRepository;
import com.interswitch.employeeportal.service.SalaryRatesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@Service
@AllArgsConstructor
public class SalaryRatesServiceImpl implements SalaryRatesService {

    private final EmployeeRepository employeeRepository;
    private final SalaryRatesRepository salaryRatesRepository;
    private final EmployeeCategoryRepository categoryRepository;
    private final EmployeeToResourceConverter employeeToResourceConverter;
    private final SalaryRatesToResourceConverter ratesToResourceConverter;

    @Override
    @Transactional
    public void addSalaryRates(SalaryRatesRequest salaryRatesRequest) {
        try {
            EmployeeCategory category = categoryRepository.findById(salaryRatesRequest.getEmployeeCategoryId())
                    .orElseThrow(()-> new RuntimeException("Category id not found"));
            SalaryRates salaryRates = SalaryRates.builder()
                    .employeeCategory(category)
                    .salaryLevel(salaryRatesRequest.getSalaryLevel())
                    .amount(salaryRatesRequest.getAmount())
                    .build();
            salaryRatesRepository.save(salaryRates);
        } catch (Exception e) {
            log.error(format("An error occurred while creating salary rates, please contact support" +
                    " Possible reasons: %s", e.getLocalizedMessage()));
            throw new EmployeePortalException("An error occurred creating salary rates", INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public List<SalaryRatesResource> getAllSalaryRates() {
        return salaryRatesRepository.findAll().parallelStream().map(ratesToResourceConverter::convert).toList();
    }

    @Override
    public SalaryRatesResource getASalaryRate(Integer salaryRatesId) {
        SalaryRates salaryRates = salaryRatesRepository.findById(salaryRatesId)
                .orElseThrow(()-> new RuntimeException("Salary rate could not be found"));
        return ratesToResourceConverter.convert(salaryRates);
    }

    @Override
    public List<EmployeeResource> getEmployeesBySalaryRate(Integer id) {
        SalaryRates salaryRates = salaryRatesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SalaryRate not found."));

        List<Employee> employees = employeeRepository.findByEmployeeCategoryId(salaryRates.getEmployeeCategory().getId());

        return employees.parallelStream().map(employeeToResourceConverter::convert).toList();
    }

    @Override
    @Transactional
    public SalaryRatesResource updateSalaryRates(Integer salaryRatesId, SalaryRatesRequest salaryRatesRequest) {
        try {
            SalaryRates salaryRates = salaryRatesRepository.findById(salaryRatesId)
                    .orElseThrow(()-> new RuntimeException("Salary rate could not be found"));
            EmployeeCategory category = categoryRepository.findById(
                    salaryRatesRequest.getEmployeeCategoryId()).orElseThrow(()-> new RuntimeException("Category not found"));
            salaryRates.setEmployeeCategory(category);
            salaryRates.setSalaryLevel(salaryRatesRequest.getSalaryLevel());
            salaryRates.setAmount(salaryRatesRequest.getAmount());
            salaryRatesRepository.save(salaryRates);
            return ratesToResourceConverter.convert(salaryRates);
        } catch (Exception e) {
            log.error(format("An error occurred while updating salary rate, please contact support" +
                    " Possible reasons: %s", e.getLocalizedMessage()));
            throw new EmployeePortalException("An error occurred while updating salary rate ", INTERNAL_SERVER_ERROR);
        }
    }
}
