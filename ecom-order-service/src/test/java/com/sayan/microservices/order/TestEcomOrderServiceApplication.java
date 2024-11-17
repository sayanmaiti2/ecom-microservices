package com.sayan.microservices.order;

import org.springframework.boot.SpringApplication;

public class TestEcomOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(EcomOrderServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
