package com.interswitch.customermgtapp.repository;

import com.interswitch.customermgtapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface CustomerRepository {

    void save(Customer customer);

    void deleteById(int id);

    void update(int id, Customer customer);

    Customer findById(int id);

    List<Customer> findAll();
}
