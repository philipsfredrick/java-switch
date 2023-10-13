package com.interswitch.employeeportal.converter;

import com.interswitch.employeeportal.dto.response.EmployeeResource;
import com.interswitch.employeeportal.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeToResourceConverter {

    public EmployeeResource convert(Employee employee) {
        return EmployeeResource.builder()
                .id(employee.getId())
                .name(employee.getName())
                .address(employee.getAddress())
                .dateOfBirth(employee.getDateOfBirth())
                .phoneNumber(employee.getPhoneNumber())
                .joinedDate(employee.getJoinedDate())
                .department(employee.getDepartment())
                .employeeCategory(employee.getEmployeeCategory())
                .build();
    }
}
