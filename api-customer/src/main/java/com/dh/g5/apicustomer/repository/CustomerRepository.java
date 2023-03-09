package com.dh.g5.apicustomer.repository;

import com.dh.g5.apicustomer.models.Customer;
import com.dh.g5.apicustomer.models.DocType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID>, QuerydslPredicateExecutor<Customer> {
    Optional<Customer> findByDocTypeAndDocumentNumber(String docType, String documentNumber);

}
