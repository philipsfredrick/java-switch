package com.interswitch.employeeportal.converter;

import com.interswitch.employeeportal.dto.response.SalaryRatesResource;
import com.interswitch.employeeportal.model.SalaryRates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalaryRatesToResourceConverter {

    public SalaryRatesResource convert(SalaryRates salaryRates) {
        return SalaryRatesResource.builder()
                .salaryRateId(salaryRates.getId())
                .employeeCategory(salaryRates.getEmployeeCategory())
                .salaryLevel(salaryRates.getSalaryLevel())
                .amount(salaryRates.getAmount())
                .build();
    }
}
