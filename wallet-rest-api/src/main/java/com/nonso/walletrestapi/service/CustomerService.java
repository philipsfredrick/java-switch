package com.nonso.walletrestapi.service;

import com.nonso.walletrestapi.dto.SignUpRequest;
import com.nonso.walletrestapi.exception.WalletRestException;
import com.nonso.walletrestapi.model.Customer;
import com.nonso.walletrestapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Transactional
    public void registerCustomer(SignUpRequest signUpRequest) {
        try {
            Customer customer = Customer.builder()
                    .name(signUpRequest.getName())
                    .phoneNumber(signUpRequest.getPhoneNumber())
                    .address(signUpRequest.getAddress())
                    .build();
            customerRepository.save(customer);
        } catch (Exception e) {
            log.error(format("Customer could not be registered. Please contact providers. " +
                    "Possible reasons: %s", e.getLocalizedMessage()));
            throw new WalletRestException("Customer could not be registered", INTERNAL_SERVER_ERROR);
        }
    }

    public Customer getCustomerByWallet(String walletID) {
        return customerRepository.getCustomerByWallet(walletID).orElseThrow(
                ()-> new WalletRestException("Customer with this wallet id " + walletID + " not found"));
    }

    public Customer fundCustomerWallet(String walletID, BigDecimal amount) {
        try {
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new WalletRestException("Amount must be greater than zero");
            }
            Customer customer = getCustomerByWallet(walletID);
            customer.setBalance(customer.getBalance().add(amount));
            return customerRepository.save(customer);
        } catch (Exception e) {
            log.error(format("Customer wallet could not be funded. Please contact support. " +
                    "Possible reasons: %s", e.getLocalizedMessage()));
            throw new WalletRestException("Customer wallet could not be funded");
        }
    }
}
