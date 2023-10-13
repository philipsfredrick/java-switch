package com.interswitch.employeeportal.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePortalException extends RuntimeException {

    private String message;
    protected HttpStatus status;

}
