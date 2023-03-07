package com.dh.g5.apiwallet.client;

import com.dh.g5.apiwallet.config.LoadBalancerConfiguration;
import com.dh.g5.apiwallet.models.DocType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@FeignClient(name="api-customer")
@LoadBalancerClient(value="api-customer", configuration= LoadBalancerConfiguration.class)
public interface CustomerFeign {

    @GetMapping("/customers/{docType}/{documentNumber}")
    List<Customer> getCustomer (@PathVariable DocType docType, @PathVariable String documentNumber);
    @Getter
    @Setter
    class Customer {
        private UUID customerId;
        private DocType docType;
        private String documentNumber;
        private String name;
        private String lastname;
        private LocalDate birthDate;

    }
}
