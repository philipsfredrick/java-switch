package com.interswitch.employeeportal.converter;

import com.interswitch.employeeportal.dto.response.EmployeeCategoryResource;
import com.interswitch.employeeportal.model.EmployeeCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryToResourceConverter {

    public EmployeeCategoryResource convert(EmployeeCategory employeeCategory) {
        return EmployeeCategoryResource.builder()
                .categoryId(employeeCategory.getId())
                .name(employeeCategory.getName())
                .description(employeeCategory.getDescription())
                .build();
    }
}
