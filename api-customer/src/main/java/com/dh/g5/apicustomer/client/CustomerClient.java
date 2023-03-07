package com.dh.g5.apicustomer.client;


import com.dh.g5.apicustomer.config.LoadBalancerConfiguration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.Optional;

@FeignClient(name="api-wallet")
@LoadBalancerClient(value="api-wallet", configuration= LoadBalancerConfiguration.class)
public interface CustomerClient {

    @GetMapping("/find-document-currency/{documentType}/{document}/{code}")
    WalletDTO findByDocumentAndCurrency(@PathVariable String documentType,
                                            @PathVariable String document,
                                            @PathVariable String code);

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    class WalletDTO {
        private Long id;
        private Double balance;

    }

}
