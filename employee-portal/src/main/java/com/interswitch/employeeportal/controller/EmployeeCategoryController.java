package com.interswitch.employeeportal.controller;

import com.interswitch.employeeportal.dto.request.EmployeeCategoryRequest;
import com.interswitch.employeeportal.dto.response.EmployeeCategoryResource;
import com.interswitch.employeeportal.dto.response.RegistrationResponse;
import com.interswitch.employeeportal.service.EmployeeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employeecategories")
public class EmployeeCategoryController {

    private final EmployeeCategoryService categoryService;

    @PostMapping
    public ResponseEntity<RegistrationResponse> createNewEmployeeCategory(@RequestBody EmployeeCategoryRequest categoryRequest) {
        categoryService.addEmployeeCategory(categoryRequest);
        return new ResponseEntity<>(new RegistrationResponse("New Employee Category created successfully"), CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<EmployeeCategoryResource> getAnEmployeeCategory(
            @PathVariable("categoryId") Integer categoryId) {
        return new ResponseEntity<>(categoryService.getAnEmployeeCategory(categoryId), OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeCategoryResource>> getAllEmployeeCategories() {
        return new ResponseEntity<>(categoryService.getAllEmployeeCategories(), OK);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<EmployeeCategoryResource> updateExistingCategory(
            @PathVariable("categoryId") Integer categoryId, @RequestBody EmployeeCategoryRequest categoryRequest) {
        return new ResponseEntity<>(categoryService.updateEmployeeCategory(categoryId, categoryRequest), OK);
    }
}
