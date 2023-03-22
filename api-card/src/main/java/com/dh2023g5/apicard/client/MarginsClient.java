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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@FeignClient(name="api-margins")
@LoadBalancerClient(value="api-margins", configuration= LoadBalancerConfiguration.class)
public interface MarginsClient {

    @GetMapping("/calculate/{documentType}/{documentValue}")
    public Calification calculateCalification(@PathVariable String documentType, @PathVariable String documentValue);



    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    class Calification {

        private String documentType;
        private String documentValue;
        private BigDecimal totalMargin;
        private BigDecimal totalMarginAdditional;
        private List<Sublimit> sublimits;
        @Getter
        @Setter
        public static class Sublimit{
            private Concept concept;
            private BigDecimal totalMargin;
        }

        public enum Concept {
            CARD,LOAN,CHECK
        }

    }

}
