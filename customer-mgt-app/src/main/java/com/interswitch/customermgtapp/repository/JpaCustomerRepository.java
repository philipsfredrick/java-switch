package com.interswitch.customermgtapp.repository;

import com.interswitch.customermgtapp.model.Customer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//@Repository
@AllArgsConstructor
public class JpaCustomerRepository implements CustomerRepository{

    private final JpaRepository<Customer, Long> jpaRepository;


    @Override
    public void save(Customer customer) {
        jpaRepository.save(customer);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(int id, Customer customer) {
        var foundCustomer = jpaRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Customer not found")
        );
        foundCustomer.setFullName(customer.getFullName());
        jpaRepository.save(foundCustomer);
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}
