package com.interswitch.employeeportal.service.impl;

import com.interswitch.employeeportal.converter.EmployeeToResourceConverter;
import com.interswitch.employeeportal.dto.request.EmployeeRequest;
import com.interswitch.employeeportal.dto.response.EmployeeResource;
import com.interswitch.employeeportal.dto.response.PaginatedEmployeeDetailsResource;
import com.interswitch.employeeportal.exception.EmployeePortalException;
import com.interswitch.employeeportal.model.Department;
import com.interswitch.employeeportal.model.Employee;
import com.interswitch.employeeportal.model.EmployeeCategory;
import com.interswitch.employeeportal.repository.DepartmentRepository;
import com.interswitch.employeeportal.repository.EmployeeCategoryRepository;
import com.interswitch.employeeportal.repository.EmployeeRepository;
import com.interswitch.employeeportal.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@Slf4j
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeCategoryRepository categoryRepository;
    private final EmployeeToResourceConverter employeeToResourceConverter;


    @Override
    @Transactional
    public void addEmployee(EmployeeRequest employeeRequest) {
        try {
            EmployeeCategory category = categoryRepository.findById(
                    employeeRequest.getEmployeeCategoryId()).orElseThrow(
                            ()-> new RuntimeException("Employee category with id: " +
                                    employeeRequest.getEmployeeCategoryId() + " not found"));
            Department department = departmentRepository.findById(employeeRequest.getDepartmentId())
                    .orElseThrow(()-> new RuntimeException("Department with id: " + employeeRequest.getDepartmentId()
                    + " not found"));
            Employee employee = Employee.builder()
                    .name(employeeRequest.getName())
                    .dateOfBirth(employeeRequest.getDateOfBirth())
                    .phoneNumber(employeeRequest.getPhoneNumber())
                    .address(employeeRequest.getAddress())
                    .joinedDate(employeeRequest.getJoinedDate())
                    .employeeCategory(category)
                    .department(department)
                    .build();
            employeeRepository.save(employee);
        } catch (Exception e) {
            log.error(format("An error occurred while creating employee, please contact support." +
                    "Possible reasons: %s", e.getLocalizedMessage()));
            throw new EmployeePortalException("An error occurred while creating employee, " +
                    "please contact support.", INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public PaginatedEmployeeDetailsResource getAllEmployees(Integer page, Integer size) {
        try {
            Page<Employee> employees = retrieveAllEmployees(page, size);
            List<EmployeeResource> employeeResourceList = employees.getContent()
                    .parallelStream().map(employeeToResourceConverter::convert).toList();

            return PaginatedEmployeeDetailsResource.builder()
                    .employeeResourceList(employeeResourceList)
                    .currentPage(employees.getPageable().getPageNumber() + 1)
                    .totalElements(employees.getTotalElements())
                    .totalPage(employees.getTotalPages())
                    .build();
        } catch (Exception e) {
            log.error(format("An error occurred while viewing all employees, please contact support" +
                    "Possible reasons: %s", e.getLocalizedMessage()));
            throw new EmployeePortalException(
                    "An error occurred viewing all employees. Please contact support", INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public EmployeeResource getAnEmployee(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new RuntimeException("Employee with id: " + employeeId + " could not be found"));
        return employeeToResourceConverter.convert(employee);
    }

    @Override
    public List<EmployeeResource> getEmployeesByManager(Integer employeeId) {
        Department department = departmentRepository.findByManagerId(employeeId)
                .orElseThrow(() -> new RuntimeException("Department not found."));

        List<Employee> employees = employeeRepository.findByDepartmentId(department.getId());

        return employees.parallelStream().map(employeeToResourceConverter::convert).toList();
    }


    @Override
    @Transactional
    public EmployeeResource updateEmployee(Integer employeeId, EmployeeRequest employeeRequest) {
        try {
            Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(()-> new RuntimeException("Employee not found"));
            employee.setName(employeeRequest.getName());
            employee.setDateOfBirth(employeeRequest.getDateOfBirth());
            employee.setAddress(employeeRequest.getAddress());
            employee.setPhoneNumber(employeeRequest.getPhoneNumber());
            employeeRepository.save(employee);
            return employeeToResourceConverter.convert(employee);
        } catch (Exception e) {
            log.error(format("An error occurred while updating employee, please contact support." +
                    "Possible reasons: %s", e.getLocalizedMessage()));
            throw new EmployeePortalException(
                    "An error occurred updating employee", INTERNAL_SERVER_ERROR);
        }
    }


    private Page<Employee> retrieveAllEmployees(Integer page, Integer size) {
        return employeeRepository.findAll(getPageable(page, size));
    }

    private Pageable getPageable(Integer page, Integer size) {
        size = size < 1 || size > 10 ? 5 : size;
        page = page < 1 ? 1 : page;
        return PageRequest.of(--page, size, Sort.Direction.DESC, "joinedDate");
    }
}
