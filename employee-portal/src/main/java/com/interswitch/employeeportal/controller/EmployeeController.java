package com.interswitch.employeeportal.controller;

import com.interswitch.employeeportal.dto.request.EmployeeRequest;
import com.interswitch.employeeportal.dto.response.EmployeeResource;
import com.interswitch.employeeportal.dto.response.PaginatedEmployeeDetailsResource;
import com.interswitch.employeeportal.dto.response.RegistrationResponse;
import com.interswitch.employeeportal.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<RegistrationResponse> createANewEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.addEmployee(employeeRequest);
        return new ResponseEntity<>(new RegistrationResponse("A new employee created successfully"), CREATED);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResource> getAnEmployee(@PathVariable("employeeId") Integer employeeId) {
        return new ResponseEntity<>(employeeService.getAnEmployee(employeeId), OK);
    }

    @GetMapping
    public ResponseEntity<PaginatedEmployeeDetailsResource> getAllEmployees(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size
    ) {
        return new ResponseEntity<>(employeeService.getAllEmployees(page, size), OK);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeResource> updateAnEmployee(
            @PathVariable("employeeId") Integer employeeId, @RequestBody EmployeeRequest employeeRequest) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeId, employeeRequest), OK);
    }

    @GetMapping("/{employeeId}/employees")
    public ResponseEntity<List<EmployeeResource>> getEmployeesByManager(@PathVariable Integer employeeId) {
        return new ResponseEntity<>(employeeService.getEmployeesByManager(employeeId), OK);
    }
}
