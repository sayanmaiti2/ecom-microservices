package com.sayan.microservices.inventory;

import org.springframework.boot.SpringApplication;

public class TestEcomInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(EcomInventoryServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
