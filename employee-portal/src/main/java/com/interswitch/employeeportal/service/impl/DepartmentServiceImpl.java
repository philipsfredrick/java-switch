package com.interswitch.employeeportal.service.impl;

import com.interswitch.employeeportal.converter.DepartmentToResourceConverter;
import com.interswitch.employeeportal.converter.EmployeeToResourceConverter;
import com.interswitch.employeeportal.dto.request.DepartmentRequest;
import com.interswitch.employeeportal.dto.response.DepartmentResource;
import com.interswitch.employeeportal.dto.response.EmployeeResource;
import com.interswitch.employeeportal.exception.EmployeePortalException;
import com.interswitch.employeeportal.model.Department;
import com.interswitch.employeeportal.model.Employee;
import com.interswitch.employeeportal.repository.DepartmentRepository;
import com.interswitch.employeeportal.repository.EmployeeRepository;
import com.interswitch.employeeportal.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeToResourceConverter employeeToResourceConverter;
    private final DepartmentToResourceConverter departmentToResourceConverter;

    @Override
    @Transactional
    public void addDepartment(DepartmentRequest departmentRequest) {
        try {
            Integer managerId = departmentRequest.getManagerId();
            Employee employee = null;

            if (managerId != null) {
                employee = employeeRepository.findById(managerId)
                        .orElseThrow(() -> new RuntimeException("Employee with id: " + managerId + " was not found."));
            }
            Department department = Department.builder()
                    .name(departmentRequest.getName())
                    .description(departmentRequest.getDescription())
                    .manager(employee)
                    .build();
            departmentRepository.save(department);
        } catch (Exception e) {
            log.error(format("An error occurred while creating a department, please contact support" +
                    " Possible reasons: %s", e.getLocalizedMessage()));
            throw new EmployeePortalException("An error occurred while creating department, " +
                    " please contact contact", INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<DepartmentResource> getAllDepartments() {
        return departmentRepository.findAll().parallelStream()
                .map(departmentToResourceConverter::convert).toList();
    }

    @Override
    public DepartmentResource getADepartment(Integer departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new RuntimeException("Department could not be found"));
        return departmentToResourceConverter.convert(department);
    }

    @Override
    public List<EmployeeResource> findEmployeesByDepartment(Integer id) {
        departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found."));

        List<Employee> employees = employeeRepository.findByDepartmentId(id);

        return employees.parallelStream().map(employeeToResourceConverter::convert).toList();
    }

    @Override
    @Transactional
    public DepartmentResource updateDepartment(Integer departmentId, DepartmentRequest departmentRequest) {
        try {
            Department department = departmentRepository.findById(departmentId)
                    .orElseThrow(()-> new RuntimeException("Department could not be found"));
            Integer managerId = departmentRequest.getManagerId();
            Employee employee = null;

            if (managerId != null) {
                employee = employeeRepository.findById(managerId)
                        .orElseThrow(() -> new RuntimeException("Employee with id: " + managerId + " was not found."));
            }
            department.setName(departmentRequest.getName());
            department.setDescription(departmentRequest.getDescription());
            department.setManager(employee);
            departmentRepository.save(department);
            return departmentToResourceConverter.convert(department);
        } catch (Exception e) {
            log.error(format("An error occurred while updating department, please contact support" +
                    "Possible reasons: %s", e.getLocalizedMessage()));
            throw new EmployeePortalException("An error occurred updating department", INTERNAL_SERVER_ERROR);

        }
    }
}
