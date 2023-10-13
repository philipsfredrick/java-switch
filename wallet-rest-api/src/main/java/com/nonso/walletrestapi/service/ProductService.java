package com.nonso.walletrestapi.service;

import com.nonso.walletrestapi.dto.ProductDto;
import com.nonso.walletrestapi.exception.WalletRestException;
import com.nonso.walletrestapi.model.Product;
import com.nonso.walletrestapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductDto productDto) {
        try {
            Product product = Product.builder()
                    .name(productDto.getName())
                    .description(productDto.getDescription())
                    .unitPrice(productDto.getUnitPrice())
                    .quantityInStock(productDto.getQuantity())
                    .build();
            productRepository.save(product);
        } catch (Exception e) {
            log.error(format("Product could not be added successfully. " +
                    "Please contact support. Possible reasons: %s", e.getLocalizedMessage()));
            throw new WalletRestException("Product could not be added");
        }
    }
//
//    public void populateProductCatalog(List<ProductDto> productList) {
//        for (ProductDto p : productList) {
//            createProduct(p);
//        }
//    }

    public LinkedList<Product> getProductCatalog() {
        return (LinkedList<Product>) productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(
                ()-> new WalletRestException("Product not found"));
    }

    public void restockProduct(Long productId, Integer quantity) {
        if (quantity <= 0) return;
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new WalletRestException("Product not found"));
        product.setQuantityInStock(product.getQuantityInStock() + quantity);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
