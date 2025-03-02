package com.sayan.microservices.order.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;


public interface InventoryClient {

    /**
     * Checks if the specified quantity of a product is in stock.
     *
     * @param skuCode the SKU code of the product
     * @param quantity the quantity to check
     * @return true if the specified quantity is in stock, false otherwise
     */
    @GetExchange("/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);

}
