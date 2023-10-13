package com.interswitch.employeeportal.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "salary_rates")
public class SalaryRates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(targetEntity = EmployeeCategory.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_category_id", referencedColumnName = "id")
    private EmployeeCategory employeeCategory;

    @Column(name = "salary_level")
    private Integer salaryLevel;

    @Column(name = "amount")
    private BigDecimal amount;

}
