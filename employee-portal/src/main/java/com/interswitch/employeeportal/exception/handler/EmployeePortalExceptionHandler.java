package com.interswitch.employeeportal.exception.handler;

import com.interswitch.employeeportal.exception.EmployeePortalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeePortalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = EmployeePortalException.class)
    public ResponseEntity<?> handleCustomException(EmployeePortalException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
    }
}
