package com.interswitch.employeeportal.dto.response;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCategoryResource implements Serializable {

    @Serial
    private static final long serialVersionUID = 3437185399350162492L;

    private Integer categoryId;
    private String name;

    private String description;
//    private List<EmployeeResource> employeeResourceList;
}
