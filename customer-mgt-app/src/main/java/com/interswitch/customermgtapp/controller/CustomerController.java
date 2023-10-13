package com.interswitch.customermgtapp.controller;

import com.interswitch.customermgtapp.dto.CustomerDto;
import com.interswitch.customermgtapp.model.Customer;
import com.interswitch.customermgtapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<Object> getCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") int id) {
        return new ResponseEntity<>(customerService.getCustomer(id), OK);
    }
    @PostMapping
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDto customerDto) throws RuntimeException {
        customerService.addNewCustomer(customerDto);
        return new ResponseEntity<>("Customer is created successfully", CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") int id, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(id, customerDto);
        return new ResponseEntity<>("Customer is updated successfully", OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer is deleted successfully", OK);
    }
}
