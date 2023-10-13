package com.interswitch.employeeportal.dto.response;

import com.interswitch.employeeportal.model.Employee;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResource implements Serializable {

    @Serial
    private static final long serialVersionUID = -1289315051407777723L;

    private Integer id;
    private String name;

    private String description;

    private Employee manager;
    private List<EmployeeResource> employees;
}
