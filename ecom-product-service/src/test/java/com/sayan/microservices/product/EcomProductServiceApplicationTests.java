package com.sayan.microservices.product;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EcomProductServiceApplicationTests {

	@ServiceConnection
	static MongoDBContainer mongoDbContainer = new MongoDBContainer("mongo:8.0.3");

	@LocalServerPort
	private Integer serverPort;

	@BeforeEach
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = serverPort;
	}

	static {
		mongoDbContainer.start();
	}


	@Test
	void shouldCreateProduct() {
		String requestBody = """
							{
							  "name": "iPhone 13",
							  "description": "Apple iPhone from 2022",
							  "price": 1500
							}
				""";

		RestAssured.given()
				.body(requestBody)
				.contentType("application/json")
				.when()
				.post("/api/product")
				.then()
				.statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("name", Matchers.equalTo("iPhone 13"))
				.body("description", Matchers.equalTo("Apple iPhone from 2022"))
				.body("price", Matchers.equalTo(1500));
			}

}
