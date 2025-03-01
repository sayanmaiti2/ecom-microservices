package com.sayan.microservices.order.stub;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * This class provides stubs for the InventoryClient to simulate responses
 * from the Inventory service during testing.
 */
public class InventoryClientStub {

    /**
     * Stubs the inventory call to return a Success response.
     *
     * @param skuCode the SKU code of the product
     * @param quantity the quantity to check
     */
    public static void stubInventoryCall(String skuCode, Integer quantity) {
        stubFor(get(urlEqualTo("/api/inventory?skuCode=" + skuCode + "&quantity=" + quantity))
                .willReturn(
                    aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody("true")
                ));
    }
}
