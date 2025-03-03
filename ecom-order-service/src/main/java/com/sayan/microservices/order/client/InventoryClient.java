package com.sayan.microservices.order.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;


public interface InventoryClient {

    Logger log = LoggerFactory.getLogger(InventoryClient.class);

    /**
     * Checks if the specified quantity of a product is in stock.
     *
     * @param skuCode the SKU code of the product
     * @param quantity the quantity to check
     * @return true if the specified quantity is in stock, false otherwise
     */
    @GetExchange("/api/inventory")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @Retry(name = "inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);

    default boolean fallbackMethod(String code, Integer quantity, Throwable throwable) {
        log.info("Cannot get inventory for skuCode {} and quantity: {}, failure reason: {}", code, quantity, throwable.getMessage());
        return false;
    }

}
