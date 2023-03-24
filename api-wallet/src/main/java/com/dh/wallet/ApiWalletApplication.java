package com.dh.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableJpaRepositories
public class ApiWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiWalletApplication.class, args);
	}

}
