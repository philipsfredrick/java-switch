package com.interswitch.customermgtapp.model;

import com.interswitch.customermgtapp.utils;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @NotNull(message = "full name cannot be null")
    @Column(name = "full_name")
    private String fullName;

    @NotNull(message = "phoneNumber cannot be null and not greater than 11 characters")
    @Column(name = "phone_number", unique = true, length = 11)
    private String phoneNumber;

    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    @Column(name = "date_joined", nullable = false)
    private LocalDateTime dateJoined;

    @UpdateTimestamp
    @Setter(AccessLevel.NONE)
    @Column(name = "date_updated")
    private LocalDateTime dateUpdated;
}
