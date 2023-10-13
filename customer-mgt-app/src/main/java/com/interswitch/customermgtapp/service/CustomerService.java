package com.interswitch.customermgtapp.service;

import com.interswitch.customermgtapp.repository.CustomerRepository;
import com.interswitch.customermgtapp.dto.CustomerDto;
import com.interswitch.customermgtapp.model.Customer;
import com.interswitch.customermgtapp.repository.HashMapCustomerRepository;
import com.interswitch.customermgtapp.repository.JpaCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class CustomerService extends Thread {


    private final HashMapCustomerRepository hashMapCustomerRepository;
//    private static Map<Integer, Customer> customerRepo = new HashMap<>();
//
//    static {
//        Customer customer1 = new Customer();
//        customer1.setId(1);
//        customer1.setFullName("James");
//        customer1.setDateJoined(LocalDateTime.now());
//        customer1.setPhoneNumber("09022344561");
//        customerRepo.put(customer1.getId(), customer1);
//
//        Customer customer2 = new Customer();
//        customer2.setId(2);
//        customer2.setFullName("John");
//        customer2.setDateJoined(LocalDateTime.now());
//        customer2.setPhoneNumber("09122344561");
//        customerRepo.put(customer2.getId(), customer2);
//
//        Customer customer3 = new Customer();
//        customer3.setId(3);
//        customer3.setFullName("Jane");
//        customer3.setDateJoined(LocalDateTime.now());
//        customer3.setPhoneNumber("08122344561");
//        customerRepo.put(customer3.getId(), customer3);
//    }

    private final JpaCustomerRepository jpaCustomerRepository;
    public void addNewCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .fullName(customerDto.getFullName())
                .phoneNumber(customerDto.getPhoneNumber())
                .build();
        customerRepository.save(customer);

//        if (customerRepo.containsKey(customer.getId())) {
//            throw new RuntimeException("Customer with this id already exists");
//        }
//        if (checkPhoneNumber(customer.getPhoneNumber())) {
//            throw new RuntimeException("Phone number already exists");
//        }
////        customer.setId(customer.getId());
////        customer.setFullName(customer.getFullName());
////        customer.setPhoneNumber(customer.getPhoneNumber());
////        customer.setDateJoined(LocalDateTime.now());
//        customerRepo.put(customer.getId(), customer);
    }
//
//    private boolean checkPhoneNumber(String phoneNumber) throws RuntimeException {
//        try {
//            for (Customer customer: customerRepo.values()) {
//                if (customer.getPhoneNumber().equals(phoneNumber)) {
//                    return true;
//                }
//            }
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }

    public void deleteCustomer(int id) {
//        if (customerRepo.containsKey(id)) {
//            customerRepo.remove(id);
//        }
        customerRepository.deleteById(id);
    }

    public void updateCustomer(int id, CustomerDto customerDto) {
//        if (customerRepo.containsKey(id)) {
//            customerRepo.remove(id);
//            customer.setId(customer.getId());
//            customer.setFullName(customer.getFullName());
//            customer.setPhoneNumber(customer.getPhoneNumber());
//            customer.setDateJoined(LocalDateTime.now());
//            customerRepo.put(customer.getId(), customer);
//        }

        Customer customer = customerRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Customer with id " + id + " not found"));
        customer.setFullName(customerDto.getFullName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customerRepository.save(customer);
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Customer not found"));
    }

    public Collection<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
