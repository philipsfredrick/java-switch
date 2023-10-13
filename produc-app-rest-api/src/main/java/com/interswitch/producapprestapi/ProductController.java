package com.interswitch.producapprestapi;

import com.interswitch.producapprestapi.model.Product;
import com.interswitch.producapprestapi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), OK);
    }

    @RequestMapping(value = "/products/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") String id) {
        return new ResponseEntity<>(productService.getProduct(id), OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>("Product is created successfully", CREATED);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successfully", OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successfully", OK);
    }
}
