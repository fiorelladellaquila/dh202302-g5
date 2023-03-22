package com.dh2023g5.apicard.client;


import com.dh2023g5.apicard.config.LoadBalancerConfiguration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@FeignClient(name="api-margins")
@LoadBalancerClient(value="api-margins", configuration= LoadBalancerConfiguration.class)
public interface MarginsClient {

    @GetMapping("/calculate/{documentType}/{documentValue}")
    public Calification calculateCalification(@PathVariable String documentType, @PathVariable String documentValue){
        return calculateMargin.calculate(documentType,documentValue);
    }


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
