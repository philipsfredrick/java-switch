package com.interswitch.employeeportal.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 8686620321680468520L;

    private String name;
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
    private LocalDate joinedDate;
    private Integer departmentId;
    private Integer employeeCategoryId;
}
