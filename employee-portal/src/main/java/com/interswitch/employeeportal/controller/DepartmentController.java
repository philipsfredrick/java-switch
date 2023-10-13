package com.interswitch.employeeportal.controller;

import com.interswitch.employeeportal.dto.request.DepartmentRequest;
import com.interswitch.employeeportal.dto.response.DepartmentResource;
import com.interswitch.employeeportal.dto.response.EmployeeResource;
import com.interswitch.employeeportal.dto.response.RegistrationResponse;
import com.interswitch.employeeportal.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<RegistrationResponse> createDepartment(@RequestBody DepartmentRequest departmentRequest) {
        departmentService.addDepartment(departmentRequest);
        return new ResponseEntity<>(new RegistrationResponse("Department created successfully"), CREATED);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentResource> getADepartment(@PathVariable("departmentId") Integer departmentId) {
        return new ResponseEntity<>(departmentService.getADepartment(departmentId), OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResource>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), OK);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentResource> updateDepartment(
            @PathVariable("departmentId") Integer departmentId, @RequestBody DepartmentRequest departmentRequest) {
        return new ResponseEntity<>(departmentService.updateDepartment(departmentId, departmentRequest), OK);
    }

    @GetMapping("/{departmentId}/employees")
    public ResponseEntity<List<EmployeeResource>> getEmployeesByDepartment(@PathVariable("departmentId") Integer departmentId) {
        return ResponseEntity.ok(departmentService.findEmployeesByDepartment(departmentId));
    }
}
