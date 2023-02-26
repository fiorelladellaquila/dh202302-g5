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
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getByDocumentAndDocType(@Nullable DocType docType, @Nullable String documentNumber) {
        return this.customerRepository.findByDocTypeOrDocumentNumber(docType, documentNumber);
    }

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

    public UUID softDelete(UUID customerId) throws NotFoundException, BadRequestException {
        final Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new NotFoundException("Customer Not Found")
        );
        if (customer.getIsDeleted()) throw new BadRequestException("Customer is already deleted");
        customer.softDelete();

        return customerRepository.save(customer).getId();
    }
}
