package com.dh.g5.apicustomer.controller;

import com.dh.g5.apicustomer.dto.CustomerInput;
import com.dh.g5.apicustomer.dto.CustomerUpdateInput;
import com.dh.g5.apicustomer.model.Customer;
import com.dh.g5.apicustomer.model.DocType;
import com.dh.g5.apicustomer.service.CustomerService;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer create(@RequestBody @Valid CustomerInput input) {
        return customerService.create(input);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody @Valid CustomerUpdateInput input,
                           @PathVariable UUID id) {
        return customerService.update(input, id);
    }

    @DeleteMapping("/{id}")
    public UUID softDelete(@PathVariable UUID id) {
        return softDelete(id);
    }

    @GetMapping
    public List<Customer> getBy(@RequestParam(required = false) DocType docType,
                                @RequestParam(required = false) String documentNumber) {
        return customerService.getAllBy(docType, documentNumber);
    }
}
