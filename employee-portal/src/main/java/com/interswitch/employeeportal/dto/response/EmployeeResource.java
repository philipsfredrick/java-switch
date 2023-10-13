package com.interswitch.employeeportal.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.interswitch.employeeportal.model.Department;
import com.interswitch.employeeportal.model.EmployeeCategory;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResource implements Serializable {
    @Serial
    private static final long serialVersionUID = 8090404254889384911L;

    private Integer id;
    private String name;
    private String phoneNumber;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinedDate;
    private Department department;
    private EmployeeCategory employeeCategory;

}
