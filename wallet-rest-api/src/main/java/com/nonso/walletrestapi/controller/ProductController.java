package com.nonso.walletrestapi.controller;

import com.nonso.walletrestapi.dto.ProductDto;
import com.nonso.walletrestapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity<?> getProducts() {
        return new ResponseEntity<>(productService.getProductCatalog(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") Long productId) {
        return new ResponseEntity<>(productService.getProductById(productId), OK);
    }


    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
        return new ResponseEntity<>("Product created successfully", CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> restockProduct(
            @PathVariable("id") Long productId,
            @RequestParam(value = "quantity") Integer quantity) {
        productService.restockProduct(productId, quantity);
        return new ResponseEntity<>("Product restocked successfully", OK);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateCustomer(@PathVariable("id") Long productId, @RequestBody ProductDto productDto) {
//        productService.u(id, customerDto);
//        return new ResponseEntity<>("Customer is updated successfully", OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Customer is deleted successfully", OK);
    }
}
