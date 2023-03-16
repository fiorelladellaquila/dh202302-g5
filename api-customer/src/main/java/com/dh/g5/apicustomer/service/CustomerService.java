package com.dh.g5.apicustomer.service;

import com.dh.g5.apicustomer.dto.CustomerInput;
import com.dh.g5.apicustomer.dto.CustomerUpdateInput;
import com.dh.g5.apicustomer.exceptions.BadRequestException;
import com.dh.g5.apicustomer.exceptions.NotFoundException;
import com.dh.g5.apicustomer.models.Customer;
import com.dh.g5.apicustomer.models.DocType;
import com.dh.g5.apicustomer.repository.CustomerRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getByDocumentAndDocType(@Nullable String docType, @Nullable String documentNumber) throws NotFoundException {

        return customerRepository.findByDocTypeAndDocumentNumber(docType,documentNumber).orElseThrow(
                ()-> new NotFoundException("Customer not found")
        );


    }

    @Transactional
    public Customer create(CustomerInput input) {


        return customerRepository.save(
                new Customer(input)


        );
    }

    public Customer update(CustomerUpdateInput input, UUID customerId) throws NotFoundException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new NotFoundException("Customer Not Found")
        );

        return customerRepository.save(customer.update(input));
    }

    public void softDelete(UUID customerId) throws NotFoundException, BadRequestException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new NotFoundException("Customer Not Found")
        );


        customerRepository.delete(customer);
    }
}
