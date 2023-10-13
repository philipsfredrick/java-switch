package com.interswitch.employeeportal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "joined_date")
    private LocalDate joinedDate;

    @ToString.Exclude
    @ManyToOne(targetEntity = Department.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @ToString.Exclude
    @ManyToOne(targetEntity = EmployeeCategory.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_category_id", referencedColumnName = "id")
    private EmployeeCategory employeeCategory;

}
