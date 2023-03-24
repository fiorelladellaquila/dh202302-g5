package com.dh.wallet.client;

import com.dh.wallet.config.LoadBalancerConfiguration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@FeignClient(name="api-customer")
@LoadBalancerClient(value="api-customer", configuration= LoadBalancerConfiguration.class)
public interface CustomerClient {

    @GetMapping("/customers/{doctype}/{docnumentNumber}")
    CustomerDTO getCustomer (@PathVariable String doctype, @PathVariable String docnumentNumber);


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    class CustomerDTO {

        private String name;
        private String documentNumber;
        private String surname;
        private String gender;
        private LocalDate birthDate;

    }

}
