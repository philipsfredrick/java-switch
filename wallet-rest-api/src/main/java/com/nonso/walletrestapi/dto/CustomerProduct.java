package com.nonso.walletrestapi.dto;

import com.nonso.walletrestapi.utils.Utility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProduct {
    private Long customerId;
    private Long productId;
    private BigDecimal unitPrice;
    private Integer quantity;
    private String orderCode;
    private LocalDateTime createdDate;

    public CustomerProduct(Long customerId, Long productId, BigDecimal unitPrice, Integer quantity) {
        this.orderCode = Utility.generateOrderCode();
        this.createdDate = LocalDateTime.now();
        this.customerId = customerId;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
}
