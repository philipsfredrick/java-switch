package com.interswitch.employeeportal.converter;

import com.interswitch.employeeportal.dto.response.DepartmentResource;
import com.interswitch.employeeportal.model.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentToResourceConverter {

    public DepartmentResource convert(Department department) {
        return DepartmentResource.builder()
                .id(department.getId())
                .name(department.getName())
                .description(department.getDescription())
                .manager(department.getManager())
                .build();
    }
}
