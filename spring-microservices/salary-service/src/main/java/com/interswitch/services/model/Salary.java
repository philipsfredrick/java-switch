package com.interswitch.services.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Salary {

    private Long id;
    private BigDecimal amount;
    private LocalDateTime date;
    private Long employeeId;

    private Long departmentId;

    public Salary() {
    }



    public Salary(BigDecimal amount, LocalDateTime date, Long employeeId) {
        this.amount = amount;
        this.date = date;
        this.employeeId = employeeId;
    }

    public Salary(Long id, BigDecimal amount, LocalDateTime date, Long employeeId) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.employeeId = employeeId;
    }

    public Salary(Long id, BigDecimal amount, LocalDateTime date, Long employeeId, Long departmentId) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.employeeId = employeeId;
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }


    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", employeeId=" + employeeId +
                ", departmentId=" + departmentId +
                '}';
    }
}
