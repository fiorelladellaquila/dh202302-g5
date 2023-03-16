package com.dh.billeteraVirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ApiCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCardApplication.class, args);
	}

}
