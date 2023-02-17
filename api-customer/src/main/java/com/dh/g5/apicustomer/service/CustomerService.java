package com.dh.g5.apicustomer.service;

import com.dh.g5.apicustomer.dto.CustomerInput;
import com.dh.g5.apicustomer.dto.CustomerUpdateInput;
import com.dh.g5.apicustomer.model.Customer;
import com.dh.g5.apicustomer.repository.CustomerRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Log4j
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(CustomerInput input) {
        return customerRepository.save(
                new Customer(input)
        );
    }

    public Customer update(CustomerUpdateInput input, UUID customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Not Found")
        );

        return customerRepository.save(customer.update(input));
    }

    public UUID softDelete(UUID customerId) {
        final Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Not Found")
        );
        if (!customer.getActive())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer is already deleted");
        customer.softDelete();

        return customerRepository.save(customer).getId();
    }
}
