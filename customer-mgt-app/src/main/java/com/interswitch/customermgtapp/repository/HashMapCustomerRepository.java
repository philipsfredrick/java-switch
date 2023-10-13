package com.interswitch.customermgtapp.repository;

import com.interswitch.customermgtapp.dto.CustomerDto;
import com.interswitch.customermgtapp.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
@RequiredArgsConstructor
public class HashMapCustomerRepository implements CustomerRepository{
    private static Map<Integer, Customer> customerRepo = new HashMap<>();


    @Override
    public void save(Customer customer) {
        customerRepo.put(customer.getId(), customer);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(int id, Customer customer) {
        customerRepo.replace(id, customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepo.get(id);
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerRepo.values());
    }
}
