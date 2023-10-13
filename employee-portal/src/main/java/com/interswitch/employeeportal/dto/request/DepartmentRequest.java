package com.interswitch.employeeportal.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -6122835494244779792L;

    private String name;

    private String description;

    private Integer managerId;
}
