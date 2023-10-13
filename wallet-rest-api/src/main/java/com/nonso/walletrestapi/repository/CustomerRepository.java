package com.nonso.walletrestapi.repository;

import com.nonso.walletrestapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> getCustomerByWallet(String walletId);
}
