package com.sayan.microservices.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign client interface for interacting with the Inventory service.
 */
@FeignClient(value = "inventory", url = "${inventory.url}")
public interface InventoryClient {

    /**
     * Checks if the specified quantity of a product is in stock.
     *
     * @param skuCode the SKU code of the product
     * @param quantity the quantity to check
     * @return true if the specified quantity is in stock, false otherwise
     */
    @GetMapping("/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);

}
