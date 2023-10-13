package com.interswitch.producapprestapi.service;

import com.interswitch.producapprestapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);
        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    public void addProduct(Product product) {
        productRepo.put(product.getId(), product);
    }

    public void deleteProduct(String id) {
        if (productRepo.containsKey(id)) {
            productRepo.remove(id);
        }
    }

    public void updateProduct(String id, Product product) {
        if (productRepo.containsKey(id)) {
            productRepo.remove(id);
//            product.setId(id);
            productRepo.put(product.getId(), product);
        }
    }

    public Product getProduct(String id) {
        return productRepo.get(id);
    }

    public Collection<Product> getProducts() {
        return productRepo.values();
    }
}
