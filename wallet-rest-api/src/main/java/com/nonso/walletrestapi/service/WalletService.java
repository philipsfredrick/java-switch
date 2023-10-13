package com.nonso.walletrestapi.service;

import com.nonso.walletrestapi.dto.Cart;
import com.nonso.walletrestapi.model.Customer;
import com.nonso.walletrestapi.model.Product;
import com.nonso.walletrestapi.repository.CustomerRepository;
import com.nonso.walletrestapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final ProductRepository productRepository;
    private List<Cart> cart = null;
    private List<Cart> checkedOut = null;

//    public WalletService() {
//        if (cart == null) {
//            cart = new ArrayList<>();
//            checkedOut = new ArrayList<>();
//        }
//    }

    public void addProductToCart(Long productId, Integer quantity) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) return;
        if (quantity <= 0 || quantity > product.getQuantityInStock()) return;

        Cart item = new Cart(productId, product.getName(), product.getDescription(),
                product.getUnitPrice(), quantity);
        if (!cart.contains(item)) {
            cart.add(item);
        } else {
            if (cart.remove(item)) {
                cart.add(item);
            }
        }
    }

    public List<Cart> checkOutProduct(String walletId) {
        Customer customer = null;
        return cart;
    }

}
