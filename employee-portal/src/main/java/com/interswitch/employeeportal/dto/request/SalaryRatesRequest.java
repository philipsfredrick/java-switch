package com.interswitch.employeeportal.dto.request;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalaryRatesRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 4203136959447908902L;

    private BigDecimal amount;

    private Integer salaryLevel;

    private Integer employeeCategoryId;
}
