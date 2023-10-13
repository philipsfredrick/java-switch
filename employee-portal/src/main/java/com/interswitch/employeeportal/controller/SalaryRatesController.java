package com.interswitch.employeeportal.controller;

import com.interswitch.employeeportal.dto.request.SalaryRatesRequest;
import com.interswitch.employeeportal.dto.response.EmployeeResource;
import com.interswitch.employeeportal.dto.response.RegistrationResponse;
import com.interswitch.employeeportal.dto.response.SalaryRatesResource;
import com.interswitch.employeeportal.service.SalaryRatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/salaryrates")
public class SalaryRatesController {

    private final SalaryRatesService salaryRatesService;

    @PostMapping
    public ResponseEntity<RegistrationResponse> createNewSalaryRate(@RequestBody SalaryRatesRequest ratesRequest) {
        salaryRatesService.addSalaryRates(ratesRequest);
        return new ResponseEntity<>(new RegistrationResponse("New Salary Rate created successfully"), CREATED);
    }

    @GetMapping("/{rateId}")
    public ResponseEntity<SalaryRatesResource> getASalaryRate(@PathVariable("rateId") Integer rateId) {
        return new ResponseEntity<>(salaryRatesService.getASalaryRate(rateId), OK);
    }

//    @GetMapping
//    public ResponseEntity<List<SalaryRatesResource>> getAllSalaryRates() {
//        return new ResponseEntity<>(salaryRatesService.getAllSalaryRates(), OK);
//    }

    @GetMapping
    public ResponseEntity<List<SalaryRatesResource>> getAllSalaryRates() {
        return new ResponseEntity<>(salaryRatesService.getAllSalaryRates(), OK);
    }

    @PutMapping("/{rateId}")
    public ResponseEntity<SalaryRatesResource> updateSalaryRate(@PathVariable("rateId") Integer rateId, @RequestBody SalaryRatesRequest ratesRequest) {
        return new ResponseEntity<>(salaryRatesService.updateSalaryRates(rateId, ratesRequest), OK);
    }

    @GetMapping("/{rateId}/employees")
    public ResponseEntity<List<EmployeeResource>> getEmployeesBySalaryRates(@PathVariable("rateId") Integer rateId) {
        return new ResponseEntity<>(salaryRatesService.getEmployeesBySalaryRate(rateId), OK);
    }
}
