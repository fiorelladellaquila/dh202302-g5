package com.dh.g5.apicustomer.repository;

import com.dh.g5.apicustomer.model.Customer;
import com.dh.g5.apicustomer.model.DocType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    public Optional<Customer> findCustomerByDocTypeAndDocumentNumber(DocType docType, String documentNumber);
}
