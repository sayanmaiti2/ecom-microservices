# Ecom Product Service

## Overview
Ecom Product Service is a microservice responsible for managing products in an e-commerce application. It provides RESTful APIs for creating and retrieving product information.

## Technologies Used
- Java
- Spring Boot
- Maven
- MongoDB
- Testcontainers
- Swagger/OpenAPI

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6.3 or higher
- Docker (for Testcontainers)

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/sayanmaiti2/ecom-product-service.git
   cd ecom-product-service
   ```

2. Build the project:
   ```sh
   mvn clean install
   ```

### Running with Docker Compose

1. **Build the Docker images**:
   ```sh
   mvn clean install
   ```

2. **Run Docker Compose**:
   ```sh
   docker-compose up
   ```

   By running Docker Compose, you can quickly set up the database and other required services.

3. **Run the application**:
   ```sh
   mvn spring-boot:run
   ```

4. **Access the application**:
   Open your browser and navigate to `http://localhost:8080/swagger-ui.html` to access the Swagger UI and explore the available APIs.

### Configuration
The application can be configured using the `application.properties` file located in the `src/main/resources` directory.

Example configuration:
```ini
spring.application.name=ecom-product-service
server.port=8080

# MongoDB connection settings
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=product-service
spring.data.mongodb.username=root
spring.data.mongodb.password=password
spring.data.mongodb.authentication-database=admin

# Swagger UI Config
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.url=/swagger-ui.html
```

### API Documentation
API documentation is available via Swagger UI. Once the application is running, you can access it at:
```
http://localhost:8080/swagger-ui.html
```

### Running Tests
To run the tests, use the following command:
```sh
mvn test
```

## Project Structure
- `src/main/java/com/sayan/microservices/product` - Main source code
- `src/test/java/com/sayan/microservices/product` - Test source code
- `src/main/resources` - Configuration files

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License
This project is licensed under the MIT License.
```