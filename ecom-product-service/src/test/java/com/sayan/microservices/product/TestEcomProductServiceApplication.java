package com.sayan.microservices.product;

import org.springframework.boot.SpringApplication;

public class TestEcomProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(EcomProductServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
