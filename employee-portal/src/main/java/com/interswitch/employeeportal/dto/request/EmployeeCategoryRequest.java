package com.interswitch.employeeportal.dto.request;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCategoryRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -3586707341589148837L;

    private String name;

    private String description;
}
