package com.nonso.walletrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Cart {
    private Long productId;
    private String productName;
    private String description;
    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal subTotal;

    public Cart(Long productId, String productName, String description, BigDecimal unitPrice, Integer quantity) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.subTotal = calcSubTotal();
    }

    private BigDecimal calcSubTotal() {
        return this.unitPrice.multiply(BigDecimal.valueOf((long) quantity));
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        this.subTotal = calcSubTotal();
    }
}
