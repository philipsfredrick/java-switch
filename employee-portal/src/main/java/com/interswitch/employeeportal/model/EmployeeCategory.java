package com.interswitch.employeeportal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employee_category")
public class EmployeeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

//    @OneToMany(targetEntity = SalaryRates.class, fetch = FetchType.LAZY)
//    private List<SalaryRates> salaryRatesList = new ArrayList<>();

//    @OneToMany(targetEntity = Employee.class, fetch = FetchType.LAZY)
//    private List<Employee> employees = new ArrayList<>();

}
