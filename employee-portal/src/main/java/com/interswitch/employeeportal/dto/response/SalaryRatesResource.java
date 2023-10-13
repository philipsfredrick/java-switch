package com.interswitch.employeeportal.dto.response;

import com.interswitch.employeeportal.model.EmployeeCategory;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalaryRatesResource implements Serializable {

    @Serial
    private static final long serialVersionUID = 1059673470367998207L;

    private Integer salaryRateId;

    private BigDecimal amount;

    private Integer salaryLevel;

    private EmployeeCategory employeeCategory;
}
