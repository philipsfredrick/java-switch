package com.nonso.walletrestapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull(message = "Missing required field. Product name cannot be null")
    private String name;

    @Column(name = "description", nullable = false)
    @NotNull(message = "Missing required field description. Cannot be null")
    private String description;

    @Column(name = "balance", nullable = false, scale = 9, precision = 18)
    @NotNull(message = "Missing required field. Unit price")
    private BigDecimal unitPrice;

    @Column(name = "quantity_in_stock", nullable = false)
    @NotNull(message = "Missing required field. Quantity cannot be ")
    private Integer quantityInStock;

    @Column(name = "available")
    private Boolean available;

    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    @Setter(AccessLevel.NONE)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Setter(AccessLevel.NONE)
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public Product (@NotNull String name, @NotNull String description, @NotNull BigDecimal unitPrice, @NotNull Integer quantityInStock) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
    }
}
