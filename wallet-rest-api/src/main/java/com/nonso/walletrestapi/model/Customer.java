package com.nonso.walletrestapi.model;

import com.nonso.walletrestapi.utils.Utility;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@ToString
@AllArgsConstructor
@SQLDelete(sql = "UPDATE customers SET deleted_at=NOW() where id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted_at IS NULL")
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @NotNull(message = "Missing required field. Name cannot be null")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false, length = 11)
    @NotNull(message = "Missing required field. Phone number cannot be null")
    @Size(message = "phone number should not exceed 11 digit characters", min = 11, max = 11)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "wallet", nullable = false)
    private String wallet;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    @Column(name = "registered_date", nullable = false)
    private LocalDateTime registeredDate;

    @UpdateTimestamp
    @Setter(AccessLevel.NONE)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Setter(AccessLevel.NONE)
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public Customer() {
        this.wallet = Utility.generateWalletID();
    }

    public Customer(String name, String phoneNumber, String address) {
        this();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
