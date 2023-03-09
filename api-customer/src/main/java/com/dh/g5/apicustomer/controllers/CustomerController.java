package com.dh.g5.apicustomer.controllers;

import com.dh.g5.apicustomer.dto.CustomerInput;
import com.dh.g5.apicustomer.dto.CustomerUpdateInput;
import com.dh.g5.apicustomer.exceptions.BadRequestException;
import com.dh.g5.apicustomer.exceptions.NotFoundException;
import com.dh.g5.apicustomer.models.Customer;
import com.dh.g5.apicustomer.models.DocType;
import com.dh.g5.apicustomer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{doctype}/{docnumentNumber}")
    public ResponseEntity<Customer> getByDocumentAndDocType(@PathVariable String doctype, @PathVariable String docnumentNumber) throws NotFoundException {
        return new ResponseEntity<>(customerService.getByDocumentAndDocType(doctype,docnumentNumber), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody CustomerInput customer) throws BadRequestException {
        return ResponseEntity.ok(customerService.create(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable UUID id, @RequestBody @Valid CustomerUpdateInput customer) throws NotFoundException {
        return ResponseEntity.ok(customerService.update(customer, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) throws NotFoundException, BadRequestException {
                     customerService.softDelete(id);
        return ResponseEntity.ok("Customer deleted ID: "+id );
    }
}
